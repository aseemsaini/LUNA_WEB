// @GENERATOR:play-routes-compiler
// @SOURCE:conf/routes

import play.api.routing.JavaScriptReverseRoute


import _root_.controllers.Assets.Asset

// @LINE:6
package controllers.javascript {

  // @LINE:6
  class ReverseHomeController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:6
    def index: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.HomeController.index",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + """"})
        }
      """
    )
  
  }

  // @LINE:10
  class ReverseAsyncController(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:10
    def message: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.AsyncController.message",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "message"})
        }
      """
    )
  
  }

  // @LINE:13
  class Reversetweet(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:34
    def searchMessage: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.searchMessage",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "searchMessage"})
        }
      """
    )
  
    // @LINE:38
    def reTweet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.reTweet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "retweet"})
        }
      """
    )
  
    // @LINE:36
    def editTweet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.editTweet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "editmessage"})
        }
      """
    )
  
    // @LINE:14
    def createUser: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.createUser",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "create"})
        }
      """
    )
  
    // @LINE:18
    def createUserForm: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.createUserForm",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "createUserForm2"})
        }
      """
    )
  
    // @LINE:29
    def deleteTweet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.deleteTweet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "dtweet"})
        }
      """
    )
  
    // @LINE:32
    def follow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.follow",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "follow"})
        }
      """
    )
  
    // @LINE:30
    def searchProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.searchProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "search"})
        }
      """
    )
  
    // @LINE:26
    def logout: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.logout",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "logout"})
        }
      """
    )
  
    // @LINE:15
    def loginValidate: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.loginValidate",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "validate"})
        }
      """
    )
  
    // @LINE:33
    def unfollow: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.unfollow",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "unfollow"})
        }
      """
    )
  
    // @LINE:24
    def home: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.home",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "home"})
        }
      """
    )
  
    // @LINE:28
    def addTweet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.addTweet",
      """
        function() {
          return _wA({method:"POST", url:"""" + _prefix + { _defaultPrefix } + """" + "tweet"})
        }
      """
    )
  
    // @LINE:37
    def likeTweet: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.likeTweet",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "like"})
        }
      """
    )
  
    // @LINE:27
    def showProfile: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.showProfile",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "profile"})
        }
      """
    )
  
    // @LINE:13
    def login: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.tweet.login",
      """
        function() {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "login"})
        }
      """
    )
  
  }

  // @LINE:21
  class ReverseAssets(_prefix: => String) {

    def _defaultPrefix: String = {
      if (_prefix.endsWith("/")) "" else "/"
    }

  
    // @LINE:21
    def versioned: JavaScriptReverseRoute = JavaScriptReverseRoute(
      "controllers.Assets.versioned",
      """
        function(file0) {
          return _wA({method:"GET", url:"""" + _prefix + { _defaultPrefix } + """" + "assets/" + (""" + implicitly[play.api.mvc.PathBindable[String]].javascriptUnbind + """)("file", file0)})
        }
      """
    )
  
  }


}
