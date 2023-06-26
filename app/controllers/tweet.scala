package controllers

import Models.TaskListInDatabaseModel
import org.h2.jdbc.JdbcDatabaseMetaData
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}
import Models.Tables.MessagesRow
import Models.Tables.UsersRow
import slick.jdbc.MySQLProfile.api._

import scala.concurrent.ExecutionContext
import javax.inject._
case class LoginData2(username: String, password: String)

@Singleton
class tweet @Inject()(protected val dbConfigProvider:DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder, ec:ExecutionContext)
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile]{

  private val model = new TaskListInDatabaseModel(db)
  val loginForm = Form(mapping(
    "Username" -> text(3, 10),
    "Password" -> text(8))(LoginData2.apply)(LoginData2.unapply))

  def login = Action { implicit request =>
    Ok(views.html.login2(loginForm))
  }


  import Models.Tables.MessagesRow

  import Models.Tables.MessagesRow

  def home = Action.async { implicit request =>
    val limit = 10
    val messagesWithUsers: Future[Seq[(MessagesRow, UsersRow)]] = model.getMessagesWithUsers(limit)

    messagesWithUsers.map { messagesAndUsers =>
      val messages: Seq[MessagesRow] = messagesAndUsers.map { case (message, _) => message }
      val users: Seq[UsersRow] = messagesAndUsers.map { case (_, user) => user }
      Ok(views.html.home(messages, users))
    }
  }

  import scala.concurrent.ExecutionContext.Implicits.global

  def createUserForm = Action.async { implicit request =>
    val executionContext = scala.concurrent.ExecutionContext.global

    loginForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.login2(formWithErrors))),
      ld => {
        val username = ld.username
        val password = ld.password

        // Validate if the username already exists
        model.validate(username)(executionContext).flatMap { exists =>
          if (exists) {
            // Username already exists, return a flashing error
            Future.successful(Redirect(routes.tweet.home).flashing("error" -> "User already exists."))
          } else {
            // Username doesn't exist, create a new user
            model.createUser(username, password)(executionContext).map { _ =>
              Redirect(routes.tweet.login).flashing("Done" -> "User creation Done.")
            }(executionContext).recover {
              case _ =>
                Redirect(routes.tweet.login).flashing("error" -> "User creation failed.")
            }(executionContext)
          }
        }(executionContext)
      }
    )
  }



}