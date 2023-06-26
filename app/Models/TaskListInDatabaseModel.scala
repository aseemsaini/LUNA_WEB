package Models
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._


class TaskListInDatabaseModel (db: Database) (implicit ec: ExecutionContext) {
  def validate(username: String)(implicit ec: ExecutionContext): Future[Boolean] = {
    db.run(Users.filter(_.username === username).exists.result)
  }

  def createUser(username: String, password: String)(implicit ec: ExecutionContext): Future[Unit] = {
    val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
    db.run(Users += UsersRow(-1, username, hashedPassword)).map(_ => ())
  }

  import Models.Tables._

  import Models.Tables._
  import slick.jdbc.MySQLProfile.api._

  def getMessagesWithUsers(limit: Int): Future[Seq[(MessagesRow, UsersRow)]] = {
    val query = for {
      (message, user) <- Messages.sortBy(_.createdAt.desc.nullsLast).take(limit) join Users on (_.userId === _.id.asColumnOf[Int])
    } yield (message, user)
    db.run(query.result)
  }



  def addTask(username: String, task: String): Unit = { ???
  }


  def removeTask(username: String, index: Int): Boolean = ???
}