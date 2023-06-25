package Models
import slick.jdbc.MySQLProfile.api._
import scala.concurrent.ExecutionContext
import scala.concurrent.Future
import org.mindrot.jbcrypt.BCrypt
import Models.Tables._

class TaskListInDatabaseModel (db: Database) (implicit ec: ExecutionContext) {
  def validate(username: String, password: String): Boolean = { ???
    //db.run(Users.filter(userRow => userRow.username === username && userRow.password === password).result)
  }

  def createUser(username: String, password: String): Future[Unit] = {
    val hashedPassword = BCrypt.hashpw(password, BCrypt.gensalt())
    db.run(Users += UsersRow(-1, username, hashedPassword)).map(_ => ())
  }

  def getTasks(username: String): Seq[String] = { ???
  }

  def addTask(username: String, task: String): Unit = { ???
  }


  def removeTask(username: String, index: Int): Boolean = ???
}