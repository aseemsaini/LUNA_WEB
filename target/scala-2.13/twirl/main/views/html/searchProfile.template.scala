
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
    """),_display_(/*6.6*/if(tweets.isEmpty)/*6.24*/ {_display_(Seq[Any](format.raw/*6.26*/("""
"""),format.raw/*7.1*/("""<p>User not found</p>
""")))}/*8.3*/else/*8.8*/{_display_(Seq[Any](format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""<div id ="follow">
    <a href=""""),_display_(/*10.15*/routes/*10.21*/.tweet.follow),format.raw/*10.34*/("""">Follow</a>
</div>
<ul>
    """),_display_(/*13.6*/for(message <- tweets) yield /*13.28*/ {_display_(Seq[Any](format.raw/*13.30*/("""
    """),format.raw/*14.5*/("""<li>
        <p>Message: """),_display_(/*15.22*/message/*15.29*/.text),format.raw/*15.34*/("""</p>
    </li>
    """)))}),format.raw/*17.6*/("""
"""),format.raw/*18.1*/("""</ul>
""")))}),format.raw/*19.2*/("""
"""),format.raw/*20.1*/("""<div>
    <a href=""""),_display_(/*21.15*/routes/*21.21*/.tweet.logout),format.raw/*21.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*25.15*/routes/*25.21*/.tweet.home),format.raw/*25.32*/("""" id="home">Home</a>
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
                  HASH: 8db2a57bccf6927f1e19340a5236b96b1a9627db
                  MATRIX: 789->1|978->97|1005->98|1073->141|1099->159|1138->161|1165->162|1205->186|1216->191|1253->192|1280->193|1340->226|1355->232|1389->245|1445->275|1483->297|1523->299|1555->304|1608->330|1624->337|1650->342|1700->362|1728->363|1765->370|1793->371|1840->391|1855->397|1889->410|1969->463|1984->469|2016->480
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|34->10|37->13|37->13|37->13|38->14|39->15|39->15|39->15|41->17|42->18|43->19|44->20|45->21|45->21|45->21|49->25|49->25|49->25
                  -- GENERATED --
              */
          