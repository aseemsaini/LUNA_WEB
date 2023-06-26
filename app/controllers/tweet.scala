package controllers

import Models.TaskListInDatabaseModel
import org.h2.jdbc.JdbcDatabaseMetaData
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.{ExecutionContext, Future}
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

  def createUserForm = Action.async { implicit request =>
    loginForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.login2(formWithErrors))),
      ld => {
        val username = ld.username
        val password = ld.password
        model.createUser(username, password).map { _ =>
          Redirect(routes.tweet.login).flashing("Done" -> "User creation Done.")
        }.recover {
          case _ =>
            Redirect(routes.tweet.login).flashing("error" -> "User creation failed.")
        }
      }
    )
  }


}