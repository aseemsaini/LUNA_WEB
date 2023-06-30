
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

object login2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData2],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

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
    """),format.raw/*15.5*/("""<div class="login-form">
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
            <button type="submit">Login</button>
        </div>
    </div>
    """)))}),format.raw/*30.6*/("""
    """),_display_(/*31.6*/flash/*31.11*/.get("error").map/*31.28*/ { error =>_display_(Seq[Any](format.raw/*31.39*/("""
    """),format.raw/*32.5*/("""<div class="flash-error">
        """),_display_(/*33.10*/error),format.raw/*33.15*/("""
    """),format.raw/*34.5*/("""</div>
    """)))}),format.raw/*35.6*/("""
    """),_display_(/*36.6*/flash/*36.11*/.get("Done").map/*36.27*/ { message =>_display_(Seq[Any](format.raw/*36.40*/("""
    """),format.raw/*37.5*/("""<div class="flash-success">
        """),_display_(/*38.10*/message),format.raw/*38.17*/("""
    """),format.raw/*39.5*/("""</div>
    """)))}),format.raw/*40.6*/("""
"""),format.raw/*41.1*/("""</div>
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
                  SOURCE: app/views/login2.scala.html
                  HASH: d3fa57b96fd791fdf104a6f057e6ca88e57f77a2
                  MATRIX: 789->27|967->112|994->113|1221->314|1236->320|1288->363|1328->365|1360->371|1375->377|1411->392|1443->397|1664->591|1679->597|1827->723|1863->732|1943->785|1958->791|2110->921|2146->930|2298->1052|2330->1058|2344->1063|2370->1080|2419->1091|2451->1096|2513->1131|2539->1136|2571->1141|2613->1153|2645->1159|2659->1164|2684->1180|2735->1193|2767->1198|2831->1235|2859->1242|2891->1247|2933->1259|2961->1260
                  LINES: 21->2|26->3|27->4|36->13|36->13|36->13|36->13|37->14|37->14|37->14|38->15|44->21|44->21|44->21|45->22|47->24|47->24|47->24|48->25|53->30|54->31|54->31|54->31|54->31|55->32|56->33|56->33|57->34|58->35|59->36|59->36|59->36|59->36|60->37|61->38|61->38|62->39|63->40|64->41
                  -- GENERATED --
              */
          