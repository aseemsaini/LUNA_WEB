
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Seq[Models.Tables.MessagesRow],Seq[String],Any,MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], followers: Seq[String], exists:Any)(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Profile Search</h1>
"""),_display_(/*6.2*/if(exists == false)/*6.21*/ {_display_(Seq[Any](format.raw/*6.23*/("""
    """),format.raw/*7.5*/("""<p>User not found</p>
""")))}/*8.3*/else/*8.8*/{_display_(Seq[Any](format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""<div id ="follow">
    <a href=""""),_display_(/*10.15*/routes/*10.21*/.tweet.follow),format.raw/*10.34*/("""">Follow</a>
</div>

<div id="followers">
    <h3>Following</h3>
    """),_display_(/*15.6*/for(people <- followers) yield /*15.30*/{_display_(Seq[Any](format.raw/*15.31*/("""
    """),format.raw/*16.5*/("""<p>"""),_display_(/*16.9*/people),format.raw/*16.15*/("""</p>
    """)))}),format.raw/*17.6*/("""
"""),format.raw/*18.1*/("""</div>
<ul>
    """),_display_(/*20.6*/for(message <- tweets) yield /*20.28*/ {_display_(Seq[Any](format.raw/*20.30*/("""
    """),format.raw/*21.5*/("""<li>
        <p>Message: """),_display_(/*22.22*/message/*22.29*/.text),format.raw/*22.34*/("""</p>
    </li>
    """)))}),format.raw/*24.6*/("""
"""),format.raw/*25.1*/("""</ul>
""")))}),format.raw/*26.2*/("""
"""),format.raw/*27.1*/("""<div>
    <a href=""""),_display_(/*28.15*/routes/*28.21*/.tweet.logout),format.raw/*28.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*32.15*/routes/*32.21*/.tweet.home),format.raw/*32.32*/("""" id="home">Home</a>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],followers:Seq[String],exists:Any,request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,followers,exists)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Any) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,followers,exists) => (request,flash) => apply(tweets,followers,exists)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: f5a4569f13fc26327321a2a9221ba92473b9913b
                  MATRIX: 805->1|1030->133|1057->134|1121->173|1148->192|1187->194|1218->199|1258->223|1269->228|1306->229|1333->230|1393->263|1408->269|1442->282|1538->352|1578->376|1617->377|1649->382|1679->386|1706->392|1746->402|1774->403|1817->420|1855->442|1895->444|1927->449|1980->475|1996->482|2022->487|2072->507|2100->508|2137->515|2165->516|2212->536|2227->542|2261->555|2341->608|2356->614|2388->625
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|34->10|39->15|39->15|39->15|40->16|40->16|40->16|41->17|42->18|44->20|44->20|44->20|45->21|46->22|46->22|46->22|48->24|49->25|50->26|51->27|52->28|52->28|52->28|56->32|56->32|56->32
                  -- GENERATED --
              */
          