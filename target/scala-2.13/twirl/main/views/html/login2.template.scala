
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
            <h3>Create User with Play Form</h3>
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
    </div> """)))}),format.raw/*31.13*/("""
"""),format.raw/*32.1*/("""</div>
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
                  HASH: 49670aac6228fdab305b20106b9815f808cd425f
                  MATRIX: 789->27|967->112|994->113|1222->315|1237->321|1289->364|1329->366|1361->372|1376->378|1412->393|1444->398|1651->578|1666->584|1720->617|1761->630|1850->692|1865->698|1923->735|1964->748|2141->894|2169->895
                  LINES: 21->2|26->3|27->4|37->14|37->14|37->14|37->14|38->15|38->15|38->15|39->16|44->21|44->21|44->21|45->22|48->25|48->25|48->25|49->26|54->31|55->32
                  -- GENERATED --
              */
          