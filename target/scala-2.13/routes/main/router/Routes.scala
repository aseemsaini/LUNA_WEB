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
  // @LINE:13
  TaskList5_1: controllers.TaskList5,
  // @LINE:21
  Assets_2: controllers.Assets,
  val prefix: String
) extends GeneratedRouter {

   @javax.inject.Inject()
   def this(errorHandler: play.api.http.HttpErrorHandler,
    // @LINE:6
    HomeController_0: controllers.HomeController,
    // @LINE:13
    TaskList5_1: controllers.TaskList5,
    // @LINE:21
    Assets_2: controllers.Assets
  ) = this(errorHandler, HomeController_0, TaskList5_1, Assets_2, "/")

  def withPrefix(addPrefix: String): Routes = {
    val prefix = play.api.routing.Router.concatPrefix(addPrefix, this.prefix)
    router.RoutesPrefix.setPrefix(prefix)
    new Routes(errorHandler, HomeController_0, TaskList5_1, Assets_2, prefix)
  }

  private[this] val defaultPrefix: String = {
    if (this.prefix.endsWith("/")) "" else "/"
  }

  def documentation = List(
    ("""GET""", this.prefix, """controllers.HomeController.index"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """login2""", """controllers.TaskList5.login"""),
    ("""POST""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """createUserForm2""", """controllers.TaskList5.createUserForm"""),
    ("""GET""", this.prefix + (if(this.prefix.endsWith("/")) "" else "/") + """assets/""" + "$" + """file<.+>""", """controllers.Assets.versioned(file:String)"""),
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

  // @LINE:13
  private[this] lazy val controllers_TaskList5_login1_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("login2")))
  )
  private[this] lazy val controllers_TaskList5_login1_invoker = createInvoker(
    TaskList5_1.login,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TaskList5",
      "login",
      Nil,
      "GET",
      this.prefix + """login2""",
      """""",
      Seq()
    )
  )

  // @LINE:15
  private[this] lazy val controllers_TaskList5_createUserForm2_route = Route("POST",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("createUserForm2")))
  )
  private[this] lazy val controllers_TaskList5_createUserForm2_invoker = createInvoker(
    TaskList5_1.createUserForm,
    play.api.routing.HandlerDef(this.getClass.getClassLoader,
      "router",
      "controllers.TaskList5",
      "createUserForm",
      Nil,
      "POST",
      this.prefix + """createUserForm2""",
      """""",
      Seq()
    )
  )

  // @LINE:21
  private[this] lazy val controllers_Assets_versioned3_route = Route("GET",
    PathPattern(List(StaticPart(this.prefix), StaticPart(this.defaultPrefix), StaticPart("assets/"), DynamicPart("file", """.+""",false)))
  )
  private[this] lazy val controllers_Assets_versioned3_invoker = createInvoker(
    Assets_2.versioned(fakeValue[String]),
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


  def routes: PartialFunction[RequestHeader, Handler] = {
  
    // @LINE:6
    case controllers_HomeController_index0_route(params@_) =>
      call { 
        controllers_HomeController_index0_invoker.call(HomeController_0.index)
      }
  
    // @LINE:13
    case controllers_TaskList5_login1_route(params@_) =>
      call { 
        controllers_TaskList5_login1_invoker.call(TaskList5_1.login)
      }
  
    // @LINE:15
    case controllers_TaskList5_createUserForm2_route(params@_) =>
      call { 
        controllers_TaskList5_createUserForm2_invoker.call(TaskList5_1.createUserForm)
      }
  
    // @LINE:21
    case controllers_Assets_versioned3_route(params@_) =>
      call(params.fromPath[String]("file", None)) { (file) =>
        controllers_Assets_versioned3_invoker.call(Assets_2.versioned(file))
      }
  }
}
