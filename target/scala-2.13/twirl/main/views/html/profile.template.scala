
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[Models.Tables.MessagesRow],Seq[String],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], followers: Seq[String])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Hello, Welcome to your profile</h1>
<h3>Following</h3>
    """),_display_(/*7.6*/for(people <- followers) yield /*7.30*/{_display_(Seq[Any](format.raw/*7.31*/("""
        """),format.raw/*8.9*/("""<p>"""),_display_(/*8.13*/people),format.raw/*8.19*/("""</p>
    """)))}),format.raw/*9.6*/("""

"""),format.raw/*11.1*/("""<ul>
    """),_display_(/*12.6*/for(message <- tweets) yield /*12.28*/ {_display_(Seq[Any](format.raw/*12.30*/("""
    """),format.raw/*13.5*/("""<li>
        <p>Message: """),_display_(/*14.22*/message/*14.29*/.text),format.raw/*14.34*/("""</p>
        <form method="post" action=""""),_display_(/*15.38*/routes/*15.44*/.tweet.deleteTweet),format.raw/*15.62*/("""">
            """),_display_(/*16.14*/helper/*16.20*/.CSRF.formField),format.raw/*16.35*/("""
            """),format.raw/*17.13*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*17.61*/message/*17.68*/.text),format.raw/*17.73*/("""">
            <button type="submit">Delete</button>
        </form>
    </li>
    """)))}),format.raw/*21.6*/("""
"""),format.raw/*22.1*/("""</ul>
<div>
    <a href=""""),_display_(/*24.15*/routes/*24.21*/.tweet.logout),format.raw/*24.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*28.15*/routes/*28.21*/.tweet.home),format.raw/*28.32*/("""" id="home">Home</a>
</div>
</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],followers:Seq[String],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,followers)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,followers) => (request,flash) => apply(tweets,followers)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 0595b645cc3990616d71a015749f5d76dbcdbc0e
                  MATRIX: 795->1|1008->121|1035->122|1138->200|1177->224|1215->225|1250->234|1280->238|1306->244|1345->254|1374->256|1410->266|1448->288|1488->290|1520->295|1573->321|1589->328|1615->333|1684->375|1699->381|1738->399|1781->415|1796->421|1832->436|1873->449|1948->497|1964->504|1990->509|2104->593|2132->594|2185->620|2200->626|2234->639|2314->692|2329->698|2361->709
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|32->8|32->8|33->9|35->11|36->12|36->12|36->12|37->13|38->14|38->14|38->14|39->15|39->15|39->15|40->16|40->16|40->16|41->17|41->17|41->17|41->17|45->21|46->22|48->24|48->24|48->24|52->28|52->28|52->28
                  -- GENERATED --
              */
          