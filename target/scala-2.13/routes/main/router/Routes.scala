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
  // @LINE:18
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
    // @LINE:18
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
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserForm2""", """controllers.tweet.createUserForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """home""", """controllers.tweet.home"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """logout""", """controllers.tweet.logout"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """profile""", """controllers.tweet.showProfile"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """tweet""", """controllers.tweet.addTweet"""),
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

  // @LINE:15
  private[this] lazy val controllers_tweet_createUserForm3_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserForm2")))
  )
  private[this] lazy val controllers_tweet_createUserForm3_invoker = createInvoker(
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

  // @LINE:18
  private[this] lazy val controllers_Assets_versioned4_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned4_invoker = createInvoker(
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

  // @LINE:21
  private[this] lazy val controllers_tweet_home5_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("home")))
  )
  private[this] lazy val controllers_tweet_home5_invoker = createInvoker(
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

  // @LINE:23
  private[this] lazy val controllers_tweet_logout6_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("logout")))
  )
  private[this] lazy val controllers_tweet_logout6_invoker = createInvoker(
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

  // @LINE:24
  private[this] lazy val controllers_tweet_showProfile7_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("profile")))
  )
  private[this] lazy val controllers_tweet_showProfile7_invoker = createInvoker(
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

  // @LINE:25
  private[this] lazy val controllers_tweet_addTweet8_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("tweet")))
  )
  private[this] lazy val controllers_tweet_addTweet8_invoker = createInvoker(
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
  
    // @LINE:15
    case controllers_tweet_createUserForm3_route(params@_) =>
      call { 
        controllers_tweet_createUserForm3_invoker.call(tweet_2.createUserForm)
      }
  
    // @LINE:18
    case controllers_Assets_versioned4_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned4_invoker.call(Assets_3.versioned(file))
      }
  
    // @LINE:21
    case controllers_tweet_home5_route(params@_) =>
      call { 
        controllers_tweet_home5_invoker.call(tweet_2.home)
      }
  
    // @LINE:23
    case controllers_tweet_logout6_route(params@_) =>
      call { 
        controllers_tweet_logout6_invoker.call(tweet_2.logout)
      }
  
    // @LINE:24
    case controllers_tweet_showProfile7_route(params@_) =>
      call { 
        controllers_tweet_showProfile7_invoker.call(tweet_2.showProfile)
      }
  
    // @LINE:25
    case controllers_tweet_addTweet8_route(params@_) =>
      call { 
        controllers_tweet_addTweet8_invoker.call(tweet_2.addTweet)
      }
  }
}
