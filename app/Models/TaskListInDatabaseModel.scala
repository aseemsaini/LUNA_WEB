package Models

import slick.jdbc.PostgresProfile.api._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._
import java.sql.{Date, Timestamp}


class TaskListInDatabaseModel(db: Database)(implicit ec: ExecutionContext) {
  def validate(username: String)(implicit ec: ExecutionContext): Future[Boolean] = {
    db.run(Users.filter(_.username === username).exists.result)
  }

  def validatePass(username:String, password:String):Future[Boolean] = {
    db.run(Users.filter(_.username === username).map(_.password).result.headOption).map{
      case Some(hashedPassword) => BCrypt.checkpw(password,hashedPassword)
      case None => false
    }
  }


  def createUser(username: String, password: String)(implicit ec: ExecutionContext): Future[Unit] = {
    val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
    db.run(Users += UsersRow(-1, username, hashedPassword)).map(_ => ())
  }


  def getMessagesWithUsers(limit: Int): Future[Seq[(MessagesRow, UsersRow, Int, Timestamp)]] = {
    val query = for {
      ((message, user), likeCount) <- Messages
        .sortBy(_.messageId.desc.nullsLast)
        .take(limit)
        .join(Users)
        .on(_.userId === _.id.asColumnOf[Int])
        .joinLeft(Messages
          .groupBy(_.messageId)
          .map { case (messageId, group) => (messageId, group.map(_.likes).sum) }
        )
        .on(_._1.messageId === _._1)
    } yield (message, user, likeCount.flatMap(_._2).getOrElse(0))

    val queryTime = query.joinLeft(Messages)
      .on(_._1.messageId === _.messageId)
      .map { case ((message, user, likeCount), messageWithTimestamp) =>
        (message, user, likeCount, messageWithTimestamp.flatMap(_.createdAt).getOrElse(new Timestamp(0)))
      }
    db.run(queryTime.result)
  }


  def getTweets(username: String): Future[Seq[MessagesRow]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      messages <- Messages.filter(_.userId === userId.asColumnOf[Int])
    } yield messages
    val query2 = query.sortBy(_.createdAt.asc.nullsLast).result
    db.run(query2)

  }


  def addTweet(username: String, message: String): Future[Unit] = {
    val userID = Users.filter(_.username === username).map(_.id).result.head
    val createMessageAction = userID.flatMap { userId =>
      val messageRow = MessagesRow(-1, userId.toInt, message, 0, Some(new Timestamp(System.currentTimeMillis())))
      Messages += messageRow
    }
    db.run(createMessageAction).map(_ => ())
  }


  def deleteTweet(username: String, message: String, messageId:Long): Future[Boolean] = {
    val deleteAction = Messages
      .filter(msg => msg.text === message && msg.userId.in(Users.filter(_.username === username).map(_.id.asColumnOf[Int])) && msg.messageId === messageId.asColumnOf[Int])
      .delete
    db.run(deleteAction).map(count => count > 0)
  }

  def getFollowing(username: String): Future[Seq[String]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      following <- Followers.filter(_.followerId === userId.asColumnOf[Int])
      followingUsernames <- Users.filter(_.id === following.followedId).map(_.username)
    } yield followingUsernames
    db.run(query.result)
  }

  def getFollowers(username:String):Future[Seq[String]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      followerID <- Followers.filter(_.followedId === userId.asColumnOf[Int])
      followerUsernames <- Users.filter(_.id === followerID.followerId).map(_.username)
    } yield followerUsernames
    db.run(query.result)
  }

  def follow(user: String, searchUser: String): Future[Unit] = {
    val userIDquery = Users.filter(_.username === user).map(_.id).result.head
    val searchIDquery = Users.filter(_.username === searchUser).map(_.id).result.head
    val followAction = userIDquery.flatMap { userID =>
      searchIDquery.flatMap {
        searchID =>
          val follow = FollowersRow(userID.toInt, searchID.toInt)
          Followers += follow
      }
    }
    db.run(followAction).map(_ => ())
  }

  def unfollow(user:String, searchUser:String):Future[Unit] = {
    val userIDquery = Users.filter(_.username === user).map(_.id).result.head
    val searchIDquery = Users.filter(_.username === searchUser).map(_.id).result.head
    val deleteAction = for {
      userID <- userIDquery
      searchID <- searchIDquery
      _ <- Followers.filter(f => f.followerId === userID.asColumnOf[Int] && f.followedId === searchID.asColumnOf[Int]).delete
    }yield ()
    db.run(deleteAction)
  }

  def followValidate(user: String, searchUser: String): Future[Boolean] = {
    val userIDquery = Users.filter(_.username === user).map(_.id).result.head
    val searchIDquery = Users.filter(_.username === searchUser).map(_.id).result.head
        val query = for {
          userID <- userIDquery
          searchID <- searchIDquery
          exist <- Followers.filter(f => f.followerId === userID.asColumnOf[Int] && f.followedId === searchID.asColumnOf[Int]).exists.result
        } yield exist
    db.run(query)
  }

  def getUserID(username: String): Future[Int] = {
    val userIDquery = Users.filter(_.username === username).map(_.id).result.head
    val result = db.run(userIDquery).map(id => id)
    result
  }


  def searchMessageUser(message: String): Future[List[(String, String, Int, Timestamp)]] = {
    val messageQuery = Messages
      .filter(m => m.text.like(s"%$message%"))
      .join(Users)
      .on(_.userId === _.id.asColumnOf[Int])
      .result
    val messageFuture = db.run(messageQuery).map { results =>
      results.map { case (matchingMessage, matchingUser) =>
        (
          matchingMessage.text,
          matchingUser.username,
          matchingMessage.likes,
          matchingMessage.createdAt.getOrElse(new Timestamp(0))
        )
      }.toList
    }
    messageFuture
  }


  def editMessage(message:String, messageID:Long): Future[Unit] = {
    val query = Messages.filter(_.messageId === messageID.asColumnOf[Int]).map(_.text).update(message)
    db.run(query).map(_ => ())
  }

  def likeInc(message_id:Long, like:Int):Future[Unit] = {
    val likeAdder = like + 1
    val query = Messages.filter(_.messageId === message_id.asColumnOf[Int])
      .map(_.likes).update(likeAdder)
    db.run(query).map(_ => ())
  }

  def likeDec(message_id: Long, like: Int): Future[Unit] = {
    val likeDecrement = like - 1
    val query = Messages.filter(_.messageId === message_id.asColumnOf[Int])
      .map(_.likes).update(likeDecrement)
    db.run(query).map(_ => ())
  }

  def getLikes(message_id:Long):Future[Int] = {
    val query = Messages.filter(_.messageId === message_id.asColumnOf[Int]).map(_.likes).result.headOption
    db.run(query).map(_.getOrElse(0))
  }

  def getLikesByUsername(username: String): Future[Seq[Int]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id).result.headOption
      likes <- userId match {
        case Some(id) => Messages.filter(_.userId === id.asColumnOf[Int]).map(_.likes).result
        case None => DBIO.successful(Seq.empty[Int])
      }
    } yield likes
    db.run(query)
  }

  def getTime(username:String):Future[Seq[Timestamp]] = {
    val query = for {
      user <- Users.filter(_.username === username)
      time <- Messages.filter(_.userId === user.id.asColumnOf[Int]).map(_.createdAt)
    }yield time.getOrElse(new Timestamp(0))
    db.run(query.result)
  }

  def reTweet(messageId: Long, userId: Long): Future[Unit] = {
    val query = Messages.filter(_.messageId === messageId.asColumnOf[Int]).map(_.text).result.head
    var original = ""
    val originalUser = Messages.filter(_.messageId === messageId.asColumnOf[Int])
      .join(Users)
      .on(_.userId === _.id.asColumnOf[Int])
      .map {
      case (_, user) => user.username
      }
      .result.head
    db.run(originalUser).map {user =>
      original = user
    }
    val newMessage = query.flatMap { message =>
      val messageText = if (message.toLowerCase.contains("retweet")) {
        s"$message"
      } else {
        s"Retweet:$original  $message"
      }
      val messageRow = MessagesRow(-1, userId.toInt, messageText, 0, Some(new Timestamp(System.currentTimeMillis())))
        Messages += messageRow
        }
    db.run(newMessage).map(_ => ())
    }


}

