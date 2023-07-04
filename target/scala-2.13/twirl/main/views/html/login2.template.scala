
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

object login2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /* Login Template File */
  def apply/*2.2*/()(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
    <form method="post" action=""""),_display_(/*13.34*/routes/*13.40*/.tweet.loginValidate),format.raw/*13.60*/("""" class="login-form">
        """),_display_(/*14.10*/helper/*14.16*/.CSRF.formField),format.raw/*14.31*/("""

        """),format.raw/*16.9*/("""<div class="image-container">
            <img src="/assets/images/luna.png" alt="Luna Logo">
        </div>
        <h3>LUNA</h3>

        <div class="form-group">
            <label for="username">Username</label>
            <input type="text" id="username" name="Username" class="hidden-input" placeholder="Enter your username" required>
        </div>
        <div class="form-group">
            <label for="password">Password</label>
            <input type="password" id="password" name="Password" class="hidden-input" placeholder="Enter your password" required>
        </div>
        <div class="form-actions">
            <button type="submit">Login</button>
        </div>
    </form>


    """),_display_(/*35.6*/flash/*35.11*/.get("error").map/*35.28*/ { error =>_display_(Seq[Any](format.raw/*35.39*/("""
    """),format.raw/*36.5*/("""<div class="flash-error">
        """),_display_(/*37.10*/error),format.raw/*37.15*/("""
    """),format.raw/*38.5*/("""</div>
    """)))}),format.raw/*39.6*/("""
    """),_display_(/*40.6*/flash/*40.11*/.get("Done").map/*40.27*/ { message =>_display_(Seq[Any](format.raw/*40.40*/("""
    """),format.raw/*41.5*/("""<div class="flash-success">
        """),_display_(/*42.10*/message),format.raw/*42.17*/("""
    """),format.raw/*43.5*/("""</div>
    """)))}),format.raw/*44.6*/("""
"""),format.raw/*45.1*/("""</div>
</body>
</html>
"""))
      }
    }
  }

  def render(request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply()(request,flash)

  def f:(() => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = () => (request,flash) => apply()(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login2.scala.html
                  HASH: 88d618004b41aeaff9b2103159d3678e7e0421a5
                  MATRIX: 772->27|923->85|950->86|1206->315|1221->321|1262->341|1320->372|1335->378|1371->393|1408->403|2138->1107|2152->1112|2178->1129|2227->1140|2259->1145|2321->1180|2347->1185|2379->1190|2421->1202|2453->1208|2467->1213|2492->1229|2543->1242|2575->1247|2639->1284|2667->1291|2699->1296|2741->1308|2769->1309
                  LINES: 21->2|26->3|27->4|36->13|36->13|36->13|37->14|37->14|37->14|39->16|58->35|58->35|58->35|58->35|59->36|60->37|60->37|61->38|62->39|63->40|63->40|63->40|63->40|64->41|65->42|65->42|66->43|67->44|68->45
                  -- GENERATED --
              */
          