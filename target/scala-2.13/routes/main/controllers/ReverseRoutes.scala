// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.mvc.Call


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: Call = {
      
      Call("GET", _prefix)
    }
  
  }

  // @LINE:13
  class ReverseTaskList5(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:13
    def login: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login2")
    }
  
    // @LINE:15
    def createUserForm: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserForm2")
    }
  
  }

  // @LINE:21
  class ReverseAssets(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned(file:String): Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "assets/" + implicitly[play.api.mvc.PathBindable[String]].unbind("file", file))
    }
  
  }


}
