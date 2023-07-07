
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

"""),_display_(/*13.2*/flash/*13.7*/.get("error").map/*13.24*/ { error =>_display_(Seq[Any](format.raw/*13.35*/("""
"""),format.raw/*14.1*/("""<div class="flash-error">
    """),_display_(/*15.6*/error),format.raw/*15.11*/("""
"""),format.raw/*16.1*/("""</div>
""")))}),format.raw/*17.2*/("""
"""),_display_(/*18.2*/flash/*18.7*/.get("Done").map/*18.23*/ { message =>_display_(Seq[Any](format.raw/*18.36*/("""
"""),format.raw/*19.1*/("""<div class="flash-success">
    """),_display_(/*20.6*/message),format.raw/*20.13*/("""
"""),format.raw/*21.1*/("""</div>
""")))}),format.raw/*22.2*/("""


"""),format.raw/*25.1*/("""<div class="container">
    <form method="post" action=""""),_display_(/*26.34*/routes/*26.40*/.tweet.loginValidate),format.raw/*26.60*/("""" class="login-form">
        """),_display_(/*27.10*/helper/*27.16*/.CSRF.formField),format.raw/*27.31*/("""

        """),format.raw/*29.9*/("""<div class="image-container">
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
        <hr class="division-line">
        <p>
            <button type="button" onclick="window.location.href='"""),_display_(/*47.67*/routes/*47.73*/.tweet.createUser),format.raw/*47.90*/("""'" class="create-account-btn">Create New Account</button>
        </p>

    </form>


</div>
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
                  HASH: 96efae2ac59b140d40b69845daeba4e00466624a
                  MATRIX: 772->27|923->85|950->86|1150->260|1163->265|1189->282|1238->293|1266->294|1323->325|1349->330|1377->331|1415->339|1443->341|1456->346|1481->362|1532->375|1560->376|1619->409|1647->416|1675->417|1713->425|1743->428|1827->485|1842->491|1883->511|1941->542|1956->548|1992->563|2029->573|2854->1371|2869->1377|2907->1394
                  LINES: 21->2|26->3|27->4|36->13|36->13|36->13|36->13|37->14|38->15|38->15|39->16|40->17|41->18|41->18|41->18|41->18|42->19|43->20|43->20|44->21|45->22|48->25|49->26|49->26|49->26|50->27|50->27|50->27|52->29|70->47|70->47|70->47
                  -- GENERATED --
              */
          