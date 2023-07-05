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

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "message")
    }
  
  }

  // @LINE:13
  class Reversetweet(_prefix: => String) {
    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def searchMessage: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "searchMessage")
    }
  
    // @LINE:39
    def reTweet: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "retweet")
    }
  
    // @LINE:36
    def editTweet: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "editmessage")
    }
  
    // @LINE:14
    def createUser: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "create")
    }
  
    // @LINE:18
    def createUserForm: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "createUserForm2")
    }
  
    // @LINE:29
    def deleteTweet: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "dtweet")
    }
  
    // @LINE:32
    def follow: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "follow")
    }
  
    // @LINE:30
    def searchProfile: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "search")
    }
  
    // @LINE:26
    def logout: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "logout")
    }
  
    // @LINE:15
    def loginValidate: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "validate")
    }
  
    // @LINE:33
    def unfollow: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "unfollow")
    }
  
    // @LINE:24
    def home: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "home")
    }
  
    // @LINE:28
    def addTweet: Call = {
      
      Call("POST", _prefix + { _defaultPrefix } + "tweet")
    }
  
    // @LINE:37
    def likeTweet: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "like")
    }
  
    // @LINE:27
    def showProfile: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "profile")
    }
  
    // @LINE:13
    def login: Call = {
      
      Call("GET", _prefix + { _defaultPrefix } + "login")
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
