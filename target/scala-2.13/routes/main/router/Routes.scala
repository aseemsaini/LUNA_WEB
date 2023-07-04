// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

package router

import play.core.routing._
import play.core.routing.HandlerInvokerFactory._

import play.api.mvc._

import _root_.controllers.Assets.Asset

class Routes(
  override val errorHandler: play.api.http.HttpErrorHandler, 
  // @LINE:6
  HomeController_0: controllers.HomeController,
  // @LINE:10
  AsyncController_1: controllers.AsyncController,
  // @LINE:13
  tweet_2: controllers.tweet,
  // @LINE:21
  Assets_3: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:10
    AsyncController_1: controllers.AsyncController,
    // @LINE:13
    tweet_2: controllers.tweet,
    // @LINE:21
    Assets_3: controllers.Assets
  ) = this(errorHandler, HomeController_0, AsyncController_1, tweet_2, Assets_3, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, AsyncController_1, tweet_2, Assets_3, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """message""", """controllers.AsyncController.message"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login""", """controllers.tweet.login"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """create""", """controllers.tweet.createUser"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """validate""", """controllers.tweet.loginValidate"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserForm2""", """controllers.tweet.createUserForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.tweet.home"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.tweet.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.tweet.showProfile"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tweet""", """controllers.tweet.addTweet"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """dtweet""", """controllers.tweet.deleteTweet"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """search""", """controllers.tweet.searchProfile"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """follow""", """controllers.tweet.follow"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """unfollow""", """controllers.tweet.unfollow"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """searchMessage""", """controllers.tweet.searchMessage"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """editmessage""", """controllers.tweet.editTweet"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """like""", """controllers.tweet.likeTweet"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """retweet""", """controllers.tweet.reTweet"""),
    Nil
  ).foldLeft(List.empty[(String,String,String)]) { (s,e) => e.asInstanceOf[Any] match {
    case r @ (_,_,_) => s :+ r.asInstanceOf[(String,String,String)]
    case l => s ++ l.asInstanceOf[List[(String,String,String)]]
  }}


  // @LINE:6
  private[this] lazy val controllers_HomeController_index0_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix)))
  )
  private[this] lazy val controllers_HomeController_index0_invoker = createInvoker(
    HomeController_0.index,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.HomeController",
      "index",
      Nil,
      "GET",
      this.prefix + """""",
      """ An example controller showing a sample home page""",
      Seq()
    )
  )

  // @LINE:10
  private[this] lazy val controllers_AsyncController_message1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("message")))
  )
  private[this] lazy val controllers_AsyncController_message1_invoker = createInvoker(
    AsyncController_1.message,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.AsyncController",
      "message",
      Nil,
      "GET",
      this.prefix + """message""",
      """TaskList Route
 An example controller showing how to write asynchronous code""",
      Seq()
    )
  )

  // @LINE:13
  private[this] lazy val controllers_tweet_login2_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login")))
  )
  private[this] lazy val controllers_tweet_login2_invoker = createInvoker(
    tweet_2.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "login",
      Nil,
      "GET",
      this.prefix + """login""",
      """""",
      Seq()
    )
  )

  // @LINE:14
  private[this] lazy val controllers_tweet_createUser3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("create")))
  )
  private[this] lazy val controllers_tweet_createUser3_invoker = createInvoker(
    tweet_2.createUser,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "createUser",
      Nil,
      "GET",
      this.prefix + """create""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_tweet_loginValidate4_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("validate")))
  )
  private[this] lazy val controllers_tweet_loginValidate4_invoker = createInvoker(
    tweet_2.loginValidate,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "loginValidate",
      Nil,
      "POST",
      this.prefix + """validate""",
      """""",
      Seq()
    )
  )

  // @LINE:18
  private[this] lazy val controllers_tweet_createUserForm5_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserForm2")))
  )
  private[this] lazy val controllers_tweet_createUserForm5_invoker = createInvoker(
    tweet_2.createUserForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "createUserForm",
      Nil,
      "POST",
      this.prefix + """createUserForm2""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned6_invoker = createInvoker(
    Assets_3.versioned(fakeValue[String]),
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.Assets",
      "versioned",
      Seq(classOf[String]),
      "GET",
      this.prefix + """assets/""" + "$" + """file<.+>""",
      """ Map static resources from the /public folder to the /assets URL path""",
      Seq()
    )
  )

  // @LINE:24
  private[this] lazy val controllers_tweet_home7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_tweet_home7_invoker = createInvoker(
    tweet_2.home,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "home",
      Nil,
      "GET",
      this.prefix + """home""",
      """Home Page""",
      Seq()
    )
  )

  // @LINE:26
  private[this] lazy val controllers_tweet_logout8_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_tweet_logout8_invoker = createInvoker(
    tweet_2.logout,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "logout",
      Nil,
      "GET",
      this.prefix + """logout""",
      """""",
      Seq()
    )
  )

  // @LINE:27
  private[this] lazy val controllers_tweet_showProfile9_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_tweet_showProfile9_invoker = createInvoker(
    tweet_2.showProfile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "showProfile",
      Nil,
      "GET",
      this.prefix + """profile""",
      """""",
      Seq()
    )
  )

  // @LINE:28
  private[this] lazy val controllers_tweet_addTweet10_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tweet")))
  )
  private[this] lazy val controllers_tweet_addTweet10_invoker = createInvoker(
    tweet_2.addTweet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "addTweet",
      Nil,
      "POST",
      this.prefix + """tweet""",
      """""",
      Seq()
    )
  )

  // @LINE:29
  private[this] lazy val controllers_tweet_deleteTweet11_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("dtweet")))
  )
  private[this] lazy val controllers_tweet_deleteTweet11_invoker = createInvoker(
    tweet_2.deleteTweet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "deleteTweet",
      Nil,
      "POST",
      this.prefix + """dtweet""",
      """""",
      Seq()
    )
  )

  // @LINE:30
  private[this] lazy val controllers_tweet_searchProfile12_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("search")))
  )
  private[this] lazy val controllers_tweet_searchProfile12_invoker = createInvoker(
    tweet_2.searchProfile,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "searchProfile",
      Nil,
      "GET",
      this.prefix + """search""",
      """""",
      Seq()
    )
  )

  // @LINE:32
  private[this] lazy val controllers_tweet_follow13_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("follow")))
  )
  private[this] lazy val controllers_tweet_follow13_invoker = createInvoker(
    tweet_2.follow,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "follow",
      Nil,
      "GET",
      this.prefix + """follow""",
      """""",
      Seq()
    )
  )

  // @LINE:33
  private[this] lazy val controllers_tweet_unfollow14_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("unfollow")))
  )
  private[this] lazy val controllers_tweet_unfollow14_invoker = createInvoker(
    tweet_2.unfollow,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "unfollow",
      Nil,
      "GET",
      this.prefix + """unfollow""",
      """""",
      Seq()
    )
  )

  // @LINE:34
  private[this] lazy val controllers_tweet_searchMessage15_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("searchMessage")))
  )
  private[this] lazy val controllers_tweet_searchMessage15_invoker = createInvoker(
    tweet_2.searchMessage,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "searchMessage",
      Nil,
      "GET",
      this.prefix + """searchMessage""",
      """""",
      Seq()
    )
  )

  // @LINE:36
  private[this] lazy val controllers_tweet_editTweet16_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("editmessage")))
  )
  private[this] lazy val controllers_tweet_editTweet16_invoker = createInvoker(
    tweet_2.editTweet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "editTweet",
      Nil,
      "POST",
      this.prefix + """editmessage""",
      """""",
      Seq()
    )
  )

  // @LINE:37
  private[this] lazy val controllers_tweet_likeTweet17_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("like")))
  )
  private[this] lazy val controllers_tweet_likeTweet17_invoker = createInvoker(
    tweet_2.likeTweet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "likeTweet",
      Nil,
      "GET",
      this.prefix + """like""",
      """""",
      Seq()
    )
  )

  // @LINE:38
  private[this] lazy val controllers_tweet_reTweet18_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("retweet")))
  )
  private[this] lazy val controllers_tweet_reTweet18_invoker = createInvoker(
    tweet_2.reTweet,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.tweet",
      "reTweet",
      Nil,
      "POST",
      this.prefix + """retweet""",
      """""",
      Seq()
    )
  )


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:10
    case controllers_AsyncController_message1_route(params@_) =>
      call { 
        controllers_AsyncController_message1_invoker.call(AsyncController_1.message)
      }
  
    // @LINE:13
    case controllers_tweet_login2_route(params@_) =>
      call { 
        controllers_tweet_login2_invoker.call(tweet_2.login)
      }
  
    // @LINE:14
    case controllers_tweet_createUser3_route(params@_) =>
      call { 
        controllers_tweet_createUser3_invoker.call(tweet_2.createUser)
      }
  
    // @LINE:15
    case controllers_tweet_loginValidate4_route(params@_) =>
      call { 
        controllers_tweet_loginValidate4_invoker.call(tweet_2.loginValidate)
      }
  
    // @LINE:18
    case controllers_tweet_createUserForm5_route(params@_) =>
      call { 
        controllers_tweet_createUserForm5_invoker.call(tweet_2.createUserForm)
      }
  
    // @LINE:21
    case controllers_Assets_versioned6_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned6_invoker.call(Assets_3.versioned(file))
      }
  
    // @LINE:24
    case controllers_tweet_home7_route(params@_) =>
      call { 
        controllers_tweet_home7_invoker.call(tweet_2.home)
      }
  
    // @LINE:26
    case controllers_tweet_logout8_route(params@_) =>
      call { 
        controllers_tweet_logout8_invoker.call(tweet_2.logout)
      }
  
    // @LINE:27
    case controllers_tweet_showProfile9_route(params@_) =>
      call { 
        controllers_tweet_showProfile9_invoker.call(tweet_2.showProfile)
      }
  
    // @LINE:28
    case controllers_tweet_addTweet10_route(params@_) =>
      call { 
        controllers_tweet_addTweet10_invoker.call(tweet_2.addTweet)
      }
  
    // @LINE:29
    case controllers_tweet_deleteTweet11_route(params@_) =>
      call { 
        controllers_tweet_deleteTweet11_invoker.call(tweet_2.deleteTweet)
      }
  
    // @LINE:30
    case controllers_tweet_searchProfile12_route(params@_) =>
      call { 
        controllers_tweet_searchProfile12_invoker.call(tweet_2.searchProfile)
      }
  
    // @LINE:32
    case controllers_tweet_follow13_route(params@_) =>
      call { 
        controllers_tweet_follow13_invoker.call(tweet_2.follow)
      }
  
    // @LINE:33
    case controllers_tweet_unfollow14_route(params@_) =>
      call { 
        controllers_tweet_unfollow14_invoker.call(tweet_2.unfollow)
      }
  
    // @LINE:34
    case controllers_tweet_searchMessage15_route(params@_) =>
      call { 
        controllers_tweet_searchMessage15_invoker.call(tweet_2.searchMessage)
      }
  
    // @LINE:36
    case controllers_tweet_editTweet16_route(params@_) =>
      call { 
        controllers_tweet_editTweet16_invoker.call(tweet_2.editTweet)
      }
  
    // @LINE:37
    case controllers_tweet_likeTweet17_route(params@_) =>
      call { 
        controllers_tweet_likeTweet17_invoker.call(tweet_2.likeTweet)
      }
  
    // @LINE:38
    case controllers_tweet_reTweet18_route(params@_) =>
      call { 
        controllers_tweet_reTweet18_invoker.call(tweet_2.reTweet)
      }
  }
}
