package controllers

import Models.TaskListInDatabaseModel
import org.h2.jdbc.JdbcDatabaseMetaData
import play.api.mvc._
import play.api.data._
import play.api.data.Forms._
import play.api.db.slick.{DatabaseConfigProvider, HasDatabaseConfigProvider}
import slick.jdbc.JdbcProfile
import scala.concurrent.duration._


import scala.concurrent.{Await, ExecutionContext, Future}
import Models.Tables.{FollowersRow, MessagesRow, UsersRow}
import slick.jdbc.MySQLProfile.api._

import javax.inject._
case class LoginData2(username: String, password: String)

@Singleton
class tweet @Inject()(protected val dbConfigProvider:DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder, ec:ExecutionContext)
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {

  private val model = new TaskListInDatabaseModel(db)
  val loginForm = Form(mapping(
    "Username" -> text(3, 10),
    "Password" -> text(8))(LoginData2.apply)(LoginData2.unapply))

  def login = Action { implicit request =>
    Ok(views.html.login2(loginForm))
  }

  private var user = ""
  private var searchUser = ""

  def home = Action.async { implicit request =>
    val limit = 10
    val messagesWithUsers: Future[Seq[(MessagesRow, UsersRow)]] = model.getMessagesWithUsers(limit)

    messagesWithUsers.map { messagesAndUsers =>
      val messages: Seq[MessagesRow] = messagesAndUsers.map { case (message, _) => message }
      val users: Seq[UsersRow] = messagesAndUsers.map { case (_, user) => user }
      //val likes: Seq[MessagesRow] = messagesAndUsers.map (_,likes) => likes}
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
            Future.successful(Redirect(routes.tweet.home).flashing("error" -> "User already exists.").withSession("username" -> ld.username))
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
      })
  }


  def logout = Action { implicit request =>
    Redirect(routes.tweet.login).withNewSession
  }

  def showProfile = Action.async { implicit request =>
    val usernameOption = request.session.get("username")

    usernameOption match {
      case Some(username) =>
        val tweetsFuture: Future[Seq[MessagesRow]] = model.getTweets(username)
        val followersFuture: Future[Seq[String]] = model.getFollowers(username)

        tweetsFuture.flatMap { tweets =>
          followersFuture.map { followers =>
            Ok(views.html.profile(tweets, followers))
          }(ec)
        }(ec)
      case None =>
        Future.successful(Redirect(routes.tweet.login))
    }
  }



  def addTweet = Action.async { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
        val tweet = args("newTweet").head
        val addTweetFuture = model.addTweet(username, tweet)
        addTweetFuture.map(_ => Redirect(routes.tweet.home))(ec)
      }.getOrElse(Future.successful(Redirect(routes.tweet.home)))
    }.getOrElse(Future.successful(Redirect(routes.tweet.login)))
  }

  def deleteTweet = Action.async {implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
        val tweet = args("deleteTweet").head
        val delTweetFuture = model.deleteTweet(username, tweet)
        delTweetFuture.map(_ => Redirect(routes.tweet.showProfile))(ec)
      }.getOrElse(Future.successful(Redirect(routes.tweet.showProfile)))
    }.getOrElse(Future.successful(Redirect(routes.tweet.login)))
  }

  def searchProfile = Action.async { implicit request =>
    val userOption = request.session.get("username")
    userOption.map { username =>
      user = username
      val searchUserOption = request.queryString.get("search").flatMap(_.headOption)
      searchUserOption match {
        case Some(search) =>
          searchUser = search
          println(search)
          println(user)
          if (user == search) {
            println("Working")
            Future.successful(Redirect(routes.tweet.showProfile))
          } else {
            val follower: Future[Seq[String]] = model.getFollowers(search)
            val exist: Future[Boolean] = model.validate(search)(ec).flatMap(result => Future.successful(result))(ec)
            //println(searchUser)
            val existFuture = exist.flatMap { yes =>
              if (yes) {
                model.getTweets(search)
              } else {
                Future.successful(Seq.empty[MessagesRow])
              }
            }(ec)
            existFuture.flatMap { tweets =>
              val userExists = Await.result(exist, Duration.Inf)
              //println(tweets.nonEmpty)
              follower.map(followers => (tweets, followers, userExists))(ec)
            }(ec).map { case (tweets, followers, userExists) =>
              //println(userExists)
              Ok(views.html.searchProfile(tweets, followers, searchUser, userExists))
            }(ec)
          }
        case None =>
          Future.successful(Ok("No search query provided"))
      }
    }.getOrElse {
      Future.successful(Ok("User not logged in"))
    }
  }

  def follow = Action.async { implicit request =>
    println(searchUser)
    println(user)
    model.follow(user, searchUser).map { _ =>
      Redirect(routes.tweet.home).flashing("followSuccess" -> "Follow successful")
    }(ec)
  }




}