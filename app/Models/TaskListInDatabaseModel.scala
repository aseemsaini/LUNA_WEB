package Models
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._
import slick.jdbc.MySQLProfile.api._

import java.sql.Timestamp


class TaskListInDatabaseModel (db: Database) (implicit ec: ExecutionContext) {
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
    db.run(deleteAction).map(_ > 0)
  }

  def getFollowers(username: String):Future[Seq[String]] = {
    val query = for {
      userId <- Users.filter(_.username === username).map(_.id)
      followers <- Followers.filter(_.followerId === userId.asColumnOf[Int])
      followerUsernames <- Users.filter(_.id === followers.followedId.asColumnOf[Long]).map(_.username)
    } yield followerUsernames
    db.run(query.result)
  }

  def followedBy = {
    ???
  }
}

