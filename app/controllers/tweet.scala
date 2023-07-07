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
import java.sql.Timestamp

import javax.inject._
import scala.concurrent.Future

case class LoginData2(username: String, password: String)

@Singleton
class tweet @Inject()(protected val dbConfigProvider: DatabaseConfigProvider, cc: MessagesControllerComponents)(implicit assetsFinder: AssetsFinder, ec: ExecutionContext)
  extends MessagesAbstractController(cc) with HasDatabaseConfigProvider[JdbcProfile] {

  private val model = new TaskListInDatabaseModel(db)
  val loginForm = Form(mapping(
    "Username" -> text(3, 10),
    "Password" -> text(8))(LoginData2.apply)(LoginData2.unapply))

  def login = Action { implicit request =>
    Ok(views.html.login2())
  }

  private var user = ""
  private var searchUser = ""

  def home = Action.async { implicit request =>
    request.session.get("username").map { username =>
      user = username
    val limit = 10
    val messagesWithUsers: Future[Seq[(MessagesRow, UsersRow, Int, Timestamp)]] = model.getMessagesWithUsers(limit)
    messagesWithUsers.map { messagesAndUsers =>
      val messages: Seq[MessagesRow] = messagesAndUsers.map { case (message, _, _, _) => message }
      val users: Seq[UsersRow] = messagesAndUsers.map { case (_, user, _, _) => user }
      val likes: Seq[Int] = messagesAndUsers.map { case(_, _,like, _) => like }
      val time: Seq[Timestamp] = messagesAndUsers.map {case (_,_,_,time) => time }
      Ok(views.html.home(messages, users, likes, time))
    }
    }.getOrElse {
      Future.successful(Redirect(routes.tweet.login))
    }
  }


  def createUserForm = Action.async { implicit request =>
    val executionContext = scala.concurrent.ExecutionContext.global
    loginForm.bindFromRequest().fold(
      formWithErrors => Future.successful(BadRequest(views.html.createUser(formWithErrors))),
      ld => {
        val username = ld.username
        val password = ld.password
        // Validate if the username already exists
        model.validate(username)(executionContext).flatMap { exists =>
          if (exists) {
            // Username already exists, return a flashing error
            Future.successful(Redirect(routes.tweet.login).flashing("error" -> "USER ALREADY EXIST").withNewSession)
          } else {
            // Username doesn't exist, create a new user
            model.createUser(username, password)(executionContext).map { _ =>
              Redirect(routes.tweet.login).flashing("Done" -> "USER CREATION DONE")
            }(executionContext).recover {
              case _ =>
                Redirect(routes.tweet.createUser).flashing("error" -> "USER CREATION FAILED")
            }(executionContext)
          }
        }(executionContext)
      })
  }

  def createUser = Action { implicit request =>
    Ok(views.html.createUser(loginForm))
  }

  def loginValidate: Action[AnyContent] = Action.async { implicit request =>
    val formData = request.body.asFormUrlEncoded.get
    val username = formData("Username").head
    val password = formData("Password").head
    println(username, password)
    val resultFuture = model.validatePass(username, password)
    resultFuture.flatMap { result =>
      println(result)
      if (result) {
        val sessionData = Map("username" -> username)
        val redirectResult = Redirect(routes.tweet.home).withSession(sessionData.toSeq: _*)
        Future.successful(redirectResult)
      } else {
        val result = Redirect(routes.tweet.login).flashing("error" -> "INVALID CREDENTIALS")
        Future.successful(result)
      }
    }
  }

  def logout = Action { implicit request =>
    Redirect(routes.tweet.login).withNewSession
  }

  def showProfile = Action.async { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption match {
      case Some(username) =>
        val tweetsFuture: Future[Seq[MessagesRow]] = model.getTweets(username)
        val followingFuture: Future[Seq[String]] = model.getFollowing(username)
        val followerFuture: Future[Seq[String]] = model.getFollowers(username)
        val likeFuture: Future[Seq[Int]] = model.getLikesByUsername(username)
        val timeFuture: Future[Seq[Timestamp]] = model.getTime(username)
        tweetsFuture.flatMap { tweets =>
          followingFuture.flatMap { following =>
            followerFuture.flatMap { followers =>
              likeFuture.flatMap { likes =>
                timeFuture.map { time =>
                  Ok(views.html.profile(username, tweets, following, followers, likes, time))
                }(ec)
              }(ec)
            }(ec)
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

  def deleteTweet = Action.async { implicit request =>
    val usernameOption = request.session.get("username")
    usernameOption.map { username =>
      val postVals = request.body.asFormUrlEncoded
      postVals.map { args =>
        val tweet = args("deleteTweet").head
        val tweetId = args("TweetId").head
        println(tweetId)
        val delTweetFuture = model.deleteTweet(username, tweet, tweetId.toLong)
        delTweetFuture.map(_ => Redirect(routes.tweet.showProfile))(ec)
      }.getOrElse(Future.successful(Redirect(routes.tweet.showProfile)))
    }.getOrElse(Future.successful(Redirect(routes.tweet.login)))
  }

  def editTweet = Action.async {implicit request =>
    val formValues = request.body.asFormUrlEncoded
    val messageIdOption = formValues.flatMap(_.get("editTweetId").flatMap(_.headOption))
    val newTextOption = formValues.flatMap(_.get("editTweetText").flatMap(_.headOption))

    (messageIdOption, newTextOption) match {
      case (Some(messageId), Some(newText)) =>
        val messageIdLong = messageId.toLong
        model.editMessage(newText, messageIdLong).map(_ => Redirect(routes.tweet.showProfile))(ec)
      case _ =>
        Future.successful(BadRequest("Invalid form data"))
    }
  }


  def searchProfile = Action.async { implicit request =>
    val userOption = request.session.get("username")
    userOption.fold(Future.successful(Ok("User not logged in"): Result)) { username =>
      user = username

      val searchUserOption = request.queryString.get("search").flatMap(_.headOption)

      searchUserOption.fold(Future.successful(Ok("No search query provided"): Result)) { search =>
        searchUser = search
        println(search)
        println(user)

        if (user == search) {
          println("Working")
          Future.successful(Redirect(routes.tweet.showProfile))
        } else {
          val followingFuture: Future[Seq[String]] = model.getFollowing(search)
          val existFuture: Future[Boolean] = model.validate(search)(ec)

          val existAndTweetsFuture = existFuture.flatMap { exists =>
            if (exists) {
              model.getTweets(search).map(tweets => (tweets, exists))(ec)
            } else {
              Future.successful((Seq.empty[MessagesRow], exists))
            }
          }(ec)
          existAndTweetsFuture.flatMap { case (tweets, exists) =>
            val userExists = exists
            followingFuture.flatMap { following =>
              val followerFuture = model.getFollowers(search)
              followerFuture.flatMap{ follower =>
                val followExistFuture = model.followValidate(user, searchUser)
                followExistFuture.flatMap { followExist =>
                  val timeFuture = model.getTime(searchUser)
                  timeFuture.flatMap { time =>
                    val likesFuture = model.getLikesByUsername(searchUser)
                    likesFuture.map { likes =>
                      Ok(views.html.searchProfile(tweets, following, follower, searchUser, userExists, followExist, likes, time))
                    }(ec)
                  }(ec)
                }(ec)
              }(ec)
            }(ec)
          }(ec).recover {
            case ex: Throwable =>
              Ok(views.html.searchProfile(Seq.empty, Seq.empty, Seq.empty, searchUser, false, false, Seq.empty[Int], Seq(new Timestamp(0))))
          }(ec)
        }
      }
    }
  }


  def follow = Action.async { implicit request =>
    model.follow(user, searchUser).map { _ =>
      Redirect(routes.tweet.home).flashing("followSuccess" -> "Follow successful")
    }(ec)
  }

  def unfollow = Action.async {implicit request =>
    model.unfollow(user,searchUser).map{ _ =>
      Redirect(routes.tweet.home).flashing("UnfollowSuccess" -> "UnFollow successful")
    }(ec)
  }

  def searchMessage = Action.async {implicit request =>
    val searchMessageOption = request.queryString.get("messageSearch").flatMap(_.headOption).getOrElse("")
    val messagesFuture = model.searchMessageUser(searchMessageOption)
    messagesFuture.map { messages =>
      val matchingMessages = messages.map(_._1)
      val matchingUsers = messages.map(_._2)
      val likes = messages.map(_._3)
      val time = messages.map(_._4)
      Ok(views.html.searchMessage(matchingMessages, matchingUsers,likes, time))
    }(ec)
  }

  def likeTweet: Action[AnyContent] = Action.async { implicit request =>
    val likeOption = request.queryString.get("tweetId").flatMap(_.headOption).map(_.toLong)
    likeOption match {
      case Some(tweetId) =>
        val likesFuture = model.getLikes(tweetId)
        likesFuture.flatMap { likes =>
          val incrementLikesFuture: Future[Unit] = model.likeInc(tweetId, likes)
          incrementLikesFuture.map { _ =>
            Redirect(routes.tweet.home)
          }(ec)
        }(ec)
      case None =>
        Future.successful(BadRequest("Invalid tweetId"))
    }
  }

  def reTweet = Action.async { implicit request =>
    val reTweetIdOption = request.body.asFormUrlEncoded.flatMap(_.get("reTweetId").flatMap(_.headOption))
    reTweetIdOption match {
      case Some(reTweetId) =>
        val futureUserId = model.getUserID(user)
        futureUserId.flatMap { user =>
          model.reTweet(reTweetId.toLong, user).map { _ =>
            Redirect(routes.tweet.home)
          }
        }
      case None => Future.successful(BadRequest("Missing reTweetId parameter"))
    }
  }

}