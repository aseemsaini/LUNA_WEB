
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
    """),_display_(/*14.6*/helper/*14.12*/.form(action = routes.tweet.createUserForm)/*14.55*/ {_display_(Seq[Any](format.raw/*14.57*/("""
    """),_display_(/*15.6*/helper/*15.12*/.CSRF.formField),format.raw/*15.27*/("""
    """),format.raw/*16.5*/("""<div class="login-form">
        <form action="routes.tweet.createUserForm">
            <h3>Create User with LUNA</h3>
            <div class="form-group">

                """),_display_(/*21.18*/helper/*21.24*/.inputText(loginForm("Username"))),format.raw/*21.57*/("""
            """),format.raw/*22.13*/("""</div>
            <div class="form-group">

                """),_display_(/*25.18*/helper/*25.24*/.inputPassword(loginForm("Password"))),format.raw/*25.61*/("""
            """),format.raw/*26.13*/("""</div>
            <div class="form-actions">
                <button type="submit">Login</button>
            </div>
        </form>
        """),_display_(/*31.10*/flash/*31.15*/.get("error").map/*31.32*/ { error =>_display_(Seq[Any](format.raw/*31.43*/("""
        """),format.raw/*32.9*/("""<div class="flash-error">
            """),_display_(/*33.14*/error),format.raw/*33.19*/("""
        """),format.raw/*34.9*/("""</div>
        """)))}),format.raw/*35.10*/("""
        """),_display_(/*36.10*/flash/*36.15*/.get("Done").map/*36.31*/ { message =>_display_(Seq[Any](format.raw/*36.44*/("""
        """),format.raw/*37.9*/("""<div class="flash-success">
            """),_display_(/*38.14*/message),format.raw/*38.21*/("""
        """),format.raw/*39.9*/("""</div>
        """)))}),format.raw/*40.10*/("""
    """),format.raw/*41.5*/("""</div> """)))}),format.raw/*41.13*/("""
"""),format.raw/*42.1*/("""</div>
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
                  HASH: e77b4c3b0a2b37ea8a6f86f8f39d86585ed93479
                  MATRIX: 789->27|967->112|994->113|1222->315|1237->321|1289->364|1329->366|1361->372|1376->378|1412->393|1444->398|1646->573|1661->579|1715->612|1756->625|1845->687|1860->693|1918->730|1959->743|2129->886|2143->891|2169->908|2218->919|2254->928|2320->967|2346->972|2382->981|2429->997|2466->1007|2480->1012|2505->1028|2556->1041|2592->1050|2660->1091|2688->1098|2724->1107|2771->1123|2803->1128|2842->1136|2870->1137
                  LINES: 21->2|26->3|27->4|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|44->21|44->21|44->21|45->22|48->25|48->25|48->25|49->26|54->31|54->31|54->31|54->31|55->32|56->33|56->33|57->34|58->35|59->36|59->36|59->36|59->36|60->37|61->38|61->38|62->39|63->40|64->41|64->41|65->42
                  -- GENERATED --
              */
          