
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Seq[Models.Tables.MessagesRow],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Hello, Welcome to your profile</h1>
<ul>
    """),_display_(/*7.6*/for(message <- tweets) yield /*7.28*/ {_display_(Seq[Any](format.raw/*7.30*/("""
    """),format.raw/*8.5*/("""<li>
        <p>Message: """),_display_(/*9.22*/message/*9.29*/.text),format.raw/*9.34*/("""</p>
        <form method="post" action=""""),_display_(/*10.38*/routes/*10.44*/.tweet.deleteTweet),format.raw/*10.62*/("""">
            """),_display_(/*11.14*/helper/*11.20*/.CSRF.formField),format.raw/*11.35*/("""
            """),format.raw/*12.13*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*12.61*/message/*12.68*/.messageId),format.raw/*12.78*/("""">
            <button type="submit">Delete</button>
        </form>
    </li>
    """)))}),format.raw/*16.6*/("""
"""),format.raw/*17.1*/("""</ul>
<div>
    <a href=""""),_display_(/*19.15*/routes/*19.21*/.tweet.logout),format.raw/*19.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*23.15*/routes/*23.21*/.tweet.home),format.raw/*23.32*/("""" id="home">Home</a>
</div>
</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets) => (request,flash) => apply(tweets)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 53841424f4c0aefe2d911a793ae3a9163a981f50
                  MATRIX: 783->1|972->97|999->98|1088->162|1125->184|1164->186|1195->191|1247->217|1262->224|1287->229|1356->271|1371->277|1410->295|1453->311|1468->317|1504->332|1545->345|1620->393|1636->400|1667->410|1781->494|1809->495|1862->521|1877->527|1911->540|1991->593|2006->599|2038->610
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|33->9|33->9|33->9|34->10|34->10|34->10|35->11|35->11|35->11|36->12|36->12|36->12|36->12|40->16|41->17|43->19|43->19|43->19|47->23|47->23|47->23
                  -- GENERATED --
              */
          