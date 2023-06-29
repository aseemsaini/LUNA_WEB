package Models

import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._
import slick.jdbc.MySQLProfile.api._

import java.sql.Timestamp


class TaskListInDatabaseModel(db: Database)(implicit ec: ExecutionContext) {
  def validate(username: String)(implicit ec: ExecutionContext): Future[Boolean] = {
    db.run(Users.filter(_.username === username).exists.result)
  }

  def createUser(username: String, password: String)(implicit ec: ExecutionContext): Future[Unit] = {
    val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
    db.run(Users += UsersRow(-1, username, hashedPassword)).map(_ => ())
  }

  def getMessagesWithUsers(limit: Int): Future[Seq[(MessagesRow, UsersRow)]] = {
    val query = for {
      (message, user) <- Messages.sortBy(_.createdAt.desc.nullsLast).take(limit) join Users on (_.userId === _.id.asColumnOf[Int])
    } yield (message, user)
    db.run(query.result)
  }

  def getTweets(username: String): Future[Seq[MessagesRow]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      messages <- Messages.filter(_.userId === userId.asColumnOf[Int])
    } yield messages
    db.run(query.sortBy(_.createdAt.desc.nullsLast).result)
  }

  def addTweet(username: String, message: String): Future[Unit] = {
    val userID = Users.filter(_.username === username).map(_.id).result.head
    val createMessageAction = userID.flatMap { userId =>
      val messageRow = MessagesRow(-1, userId.toInt, message, 0, Some(new Timestamp(System.currentTimeMillis())))
      Messages += messageRow
    }
    db.run(createMessageAction).map(_ => ())
  }


  def deleteTweet(username: String, message: String): Future[Boolean] = {
    val deleteAction = Messages
      .filter(msg => msg.text === message && msg.userId.in(Users.filter(_.username === username).map(_.id.asColumnOf[Int])))
      .delete
    println(deleteAction)
    println(username)
    println(message)
    db.run(deleteAction).map(count => count > 0)
  }

  def getFollowing(username: String): Future[Seq[String]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      following <- Followers.filter(_.followerId === userId.asColumnOf[Int])
      followingUsernames <- Users.filter(_.id === following.followedId.asColumnOf[Long]).map(_.username)
    } yield followingUsernames
    db.run(query.result)
  }

  def getFollowers(username:String):Future[Seq[String]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      followerID <- Followers.filter(_.followedId === userId.asColumnOf[Int])
      followerUsernames <- Users.filter(_.id === followerID.followerId.asColumnOf[Long]).map(_.username)
    } yield followerUsernames
    db.run(query.result)
  }

  def followedBy(username: String): Future[Seq[String]] = {
    ???
    //    val query = for{
    //      userID <- Users.filter(_.username === username).map(_.id)
    //      followed <- Followers.filter()
    //
    //    }yield followedUsernames
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

  def getUserID(username:String):Future[Long] = {
    val userIDquery = Users.filter(_.username === username).map(_.id).result.head
    val result = db.run(userIDquery).map(id => id)
    println(result)
    result
  }

  def searchMessageUser(message:String):(Future[String]) = {
    val messageQuery = Messages.filter(m => m.text.like(s"%$message%")).result.headOption
    val messageFuture = db.run(messageQuery).map {
      case Some(matchingMessage) => matchingMessage.text
      case None => "No matching message found"
    }
    messageFuture
  }
}

