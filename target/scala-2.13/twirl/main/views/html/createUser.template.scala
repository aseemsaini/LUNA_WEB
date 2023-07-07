
package views.html

import _root_.play.twirl.api.TwirlFeatureImports._
import _root_.play.twirl.api.TwirlHelperImports._
import _root_.play.twirl.api.Html
import _root_.play.twirl.api.JavaScript
import _root_.play.twirl.api.Txt
import _root_.play.twirl.api.Xml
import models._
import controllers._
import play.api.i18n._
import views.html._
import play.api.templates.PlayMagic._
import play.api.mvc._
import play.api.data._

object createUser extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData2],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /* Login Template File */
  def apply/*2.2*/(loginForm: Form[LoginData2])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <link rel="stylesheet" href="/assets/stylesheets/index.css">
</head>
<body>
<div class="container">
    """),_display_(/*13.6*/helper/*13.12*/.form(action = routes.tweet.createUserForm)/*13.55*/ {_display_(Seq[Any](format.raw/*13.57*/("""
    """),_display_(/*14.6*/helper/*14.12*/.CSRF.formField),format.raw/*14.27*/("""
    """),format.raw/*15.5*/("""<div class="login-form2">
        <div class="image-container">
            <img src="/assets/images/luna.png">
        </div>
        <h3>LUNA</h3>
        <div class="form-group">
            """),_display_(/*21.14*/helper/*21.20*/.inputText(loginForm("Username"), Symbol("maxlength") -> None, Symbol("minlength") -> None, Symbol("class") -> "hidden-input")),format.raw/*21.146*/("""
        """),format.raw/*22.9*/("""</div>
        <div class="form-group">
            """),_display_(/*24.14*/helper/*24.20*/.inputPassword(loginForm("Password"), Symbol("maxlength") -> None, Symbol("minlength") -> None, Symbol("class") -> "hidden-input")),format.raw/*24.150*/("""
        """),format.raw/*25.9*/("""</div>
        <div class="form-actions">
            <button type="submit">Create Account</button>
        </div>

        <hr class="division-line2">
        <p class = "already">OR</p>
        <p>
            <button type="button" onclick="window.location.href='"""),_display_(/*33.67*/routes/*33.73*/.tweet.login),format.raw/*33.85*/("""'" class="login-account-btn">Login</button>
        </p>


    </div>
    """)))}),format.raw/*38.6*/("""
    """),_display_(/*39.6*/flash/*39.11*/.get("error").map/*39.28*/ { error =>_display_(Seq[Any](format.raw/*39.39*/("""
    """),format.raw/*40.5*/("""<div class="flash-error">
        """),_display_(/*41.10*/error),format.raw/*41.15*/("""
    """),format.raw/*42.5*/("""</div>
    """)))}),format.raw/*43.6*/("""
    """),_display_(/*44.6*/flash/*44.11*/.get("Done").map/*44.27*/ { message =>_display_(Seq[Any](format.raw/*44.40*/("""
    """),format.raw/*45.5*/("""<div class="flash-success">
        """),_display_(/*46.10*/message),format.raw/*46.17*/("""
    """),format.raw/*47.5*/("""</div>
    """)))}),format.raw/*48.6*/("""
"""),format.raw/*49.1*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(loginForm:Form[LoginData2],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)(request,flash)

  def f:((Form[LoginData2]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => (request,flash) => apply(loginForm)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/createUser.scala.html
                  HASH: d4acf2ec0099f47ad29715600106c78b337ffb68
                  MATRIX: 793->27|971->112|998->113|1225->314|1240->320|1292->363|1332->365|1364->371|1379->377|1415->392|1447->397|1669->592|1684->598|1832->724|1868->733|1948->786|1963->792|2115->922|2151->931|2444->1197|2459->1203|2492->1215|2597->1290|2629->1296|2643->1301|2669->1318|2718->1329|2750->1334|2812->1369|2838->1374|2870->1379|2912->1391|2944->1397|2958->1402|2983->1418|3034->1431|3066->1436|3130->1473|3158->1480|3190->1485|3232->1497|3260->1498
                  LINES: 21->2|26->3|27->4|36->13|36->13|36->13|36->13|37->14|37->14|37->14|38->15|44->21|44->21|44->21|45->22|47->24|47->24|47->24|48->25|56->33|56->33|56->33|61->38|62->39|62->39|62->39|62->39|63->40|64->41|64->41|65->42|66->43|67->44|67->44|67->44|67->44|68->45|69->46|69->46|70->47|71->48|72->49
                  -- GENERATED --
              */
          