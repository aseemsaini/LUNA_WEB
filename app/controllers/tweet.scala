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

  private var user =""


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
    var tweet = ""
    var tweet2 = ""
    val userOption = request.session.get("username")
    userOption.map { username => user = username}
    val postVals2 = request.body.asFormUrlEncoded
    val searchUser2: Any = postVals2.map { args =>
      tweet2 = args("search").head
    }
    println(tweet2)
    println(user)
    if (user == tweet2) {
      println("Working")
      Future.successful(Redirect(routes.tweet.showProfile))
      }
    else {
      val postVals = request.body.asFormUrlEncoded
      val searchUser: Future[(Seq[MessagesRow], Seq[String], Boolean)] = postVals.map { args =>
        tweet = args("search").head
        val follower: Future[Seq[String]] = model.getFollowers(tweet)
        val exist: Future[Boolean] = model.validate(tweet)(ec).flatMap(result => Future.successful(result))(ec)
        println(tweet)
        val existFuture = exist.flatMap { yes =>
          if (yes) {
            model.getTweets(tweet)
          }
          else
            Future.successful(Seq.empty[MessagesRow])
        }(ec)
        existFuture.flatMap { tweets =>
          val userExists = Await.result(exist, Duration.Inf)
          //println(tweets.nonEmpty)
          follower.map(followers => (tweets, followers, userExists))(ec)
        }(ec)
      }.getOrElse(Future.successful((Seq.empty[MessagesRow], Seq.empty[String], false)))

    println(user)
    searchUser.map { case(tweets, followers,userExists) =>
      println(userExists)
      Ok(views.html.searchProfile(tweets,followers,tweet, userExists))
    }(ec)
  }}

  def follow = Action {implicit request =>
    ???
  }




}