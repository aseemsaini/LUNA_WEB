
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[Seq[Models.Tables.MessagesRow],Seq[String],String,Boolean,MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], followers: Seq[String], user:String, exists:Boolean)(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Profile Search</h1>
"""),_display_(/*6.2*/if(exists == false)/*6.21*/ {_display_(Seq[Any](format.raw/*6.23*/("""
    """),format.raw/*7.5*/("""<p>User not found</p>
""")))}/*8.3*/else/*8.8*/{_display_(Seq[Any](format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""<div id="user_name">
    <h2>"""),_display_(/*10.10*/user),format.raw/*10.14*/("""</h2>
</div>
<div id ="follow">
    <a href=""""),_display_(/*13.15*/routes/*13.21*/.tweet.follow),format.raw/*13.34*/("""">Follow</a>
</div>

<div id="followers">
    <h3>Following</h3>
    """),_display_(/*18.6*/for(people <- followers) yield /*18.30*/{_display_(Seq[Any](format.raw/*18.31*/("""
    """),format.raw/*19.5*/("""<p>"""),_display_(/*19.9*/people),format.raw/*19.15*/("""</p>
    """)))}),format.raw/*20.6*/("""
"""),format.raw/*21.1*/("""</div>
<ul>
    """),_display_(/*23.6*/for(message <- tweets) yield /*23.28*/ {_display_(Seq[Any](format.raw/*23.30*/("""
    """),format.raw/*24.5*/("""<li>
        <p>Message: """),_display_(/*25.22*/message/*25.29*/.text),format.raw/*25.34*/("""</p>
    </li>
    """)))}),format.raw/*27.6*/("""
"""),format.raw/*28.1*/("""</ul>
""")))}),format.raw/*29.2*/("""
"""),format.raw/*30.1*/("""<div>
    <a href=""""),_display_(/*31.15*/routes/*31.21*/.tweet.logout),format.raw/*31.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*35.15*/routes/*35.21*/.tweet.home),format.raw/*35.32*/("""" id="home">Home</a>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],followers:Seq[String],user:String,exists:Boolean,request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,followers,user,exists)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],String,Boolean) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,followers,user,exists) => (request,flash) => apply(tweets,followers,user,exists)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: bec6ba87ff9d949483442e9d95edceaf9beb9be4
                  MATRIX: 816->1|1058->150|1085->151|1149->190|1176->209|1215->211|1246->216|1286->240|1297->245|1334->246|1361->247|1418->277|1443->281|1516->327|1531->333|1565->346|1661->416|1701->440|1740->441|1772->446|1802->450|1829->456|1869->466|1897->467|1940->484|1978->506|2018->508|2050->513|2103->539|2119->546|2145->551|2195->571|2223->572|2260->579|2288->580|2335->600|2350->606|2384->619|2464->672|2479->678|2511->689
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|37->13|37->13|37->13|42->18|42->18|42->18|43->19|43->19|43->19|44->20|45->21|47->23|47->23|47->23|48->24|49->25|49->25|49->25|51->27|52->28|53->29|54->30|55->31|55->31|55->31|59->35|59->35|59->35
                  -- GENERATED --
              */
          