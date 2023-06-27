
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
    </li>
    """)))}),format.raw/*11.6*/("""
"""),format.raw/*12.1*/("""</ul>
<div>
    <a href=""""),_display_(/*14.15*/routes/*14.21*/.tweet.logout),format.raw/*14.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*18.15*/routes/*18.21*/.tweet.home),format.raw/*18.32*/("""" id="home">Home</a>
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
                  HASH: 96895c6cac6508d9fb236ca7d7bb8ebc58b7bf15
                  MATRIX: 783->1|972->97|999->98|1088->162|1125->184|1164->186|1195->191|1247->217|1262->224|1287->229|1337->249|1365->250|1418->276|1433->282|1467->295|1547->348|1562->354|1594->365
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|33->9|33->9|33->9|35->11|36->12|38->14|38->14|38->14|42->18|42->18|42->18
                  -- GENERATED --
              */
          