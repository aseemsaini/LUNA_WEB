
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Seq[Models.Tables.MessagesRow],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Profile Search</h1>
"""),_display_(/*6.2*/if(tweets.isEmpty)/*6.20*/ {_display_(Seq[Any](format.raw/*6.22*/("""
"""),format.raw/*7.1*/("""<p>User not found</p>
""")))}/*8.3*/else/*8.8*/{_display_(Seq[Any](format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""<ul>
    """),_display_(/*10.6*/for(message <- tweets) yield /*10.28*/ {_display_(Seq[Any](format.raw/*10.30*/("""
    """),format.raw/*11.5*/("""<li>
        <p>Message: """),_display_(/*12.22*/message/*12.29*/.text),format.raw/*12.34*/("""</p>
    </li>
    """)))}),format.raw/*14.6*/("""
"""),format.raw/*15.1*/("""</ul>
""")))}),format.raw/*16.2*/("""
"""),format.raw/*17.1*/("""<div>
    <a href=""""),_display_(/*18.15*/routes/*18.21*/.tweet.logout),format.raw/*18.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*22.15*/routes/*22.21*/.tweet.home),format.raw/*22.32*/("""" id="home">Home</a>
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
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: ce8d0c61970afb785d6def60f996c4a647028d7b
                  MATRIX: 789->1|978->97|1005->98|1069->137|1095->155|1134->157|1161->158|1201->182|1212->187|1249->188|1276->189|1312->199|1350->221|1390->223|1422->228|1475->254|1491->261|1517->266|1567->286|1595->287|1632->294|1660->295|1707->315|1722->321|1756->334|1836->387|1851->393|1883->404
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|34->10|35->11|36->12|36->12|36->12|38->14|39->15|40->16|41->17|42->18|42->18|42->18|46->22|46->22|46->22
                  -- GENERATED --
              */
          