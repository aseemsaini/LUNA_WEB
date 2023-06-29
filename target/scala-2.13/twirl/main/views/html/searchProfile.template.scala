
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template7[Seq[Models.Tables.MessagesRow],Seq[String],String,Boolean,Boolean,MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], user:String, exists:Boolean, followExist:Boolean)(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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

"""),_display_(/*13.2*/if(followExist == false)/*13.26*/ {_display_(Seq[Any](format.raw/*13.28*/("""
"""),format.raw/*14.1*/("""<div id ="follow">
    <a href=""""),_display_(/*15.15*/routes/*15.21*/.tweet.follow),format.raw/*15.34*/("""">Follow</a>
</div>
""")))}),format.raw/*17.2*/("""

"""),format.raw/*19.1*/("""<div id="following">
    <h3>Following</h3>
    """),_display_(/*21.6*/for(people <- following) yield /*21.30*/{_display_(Seq[Any](format.raw/*21.31*/("""
    """),format.raw/*22.5*/("""<p>"""),_display_(/*22.9*/people),format.raw/*22.15*/("""</p>
    """)))}),format.raw/*23.6*/("""
"""),format.raw/*24.1*/("""</div>

<ul>
    """),_display_(/*27.6*/for(message <- tweets) yield /*27.28*/ {_display_(Seq[Any](format.raw/*27.30*/("""
    """),format.raw/*28.5*/("""<li>
        <p>Message: """),_display_(/*29.22*/message/*29.29*/.text),format.raw/*29.34*/("""</p>
    </li>
    """)))}),format.raw/*31.6*/("""
"""),format.raw/*32.1*/("""</ul>
""")))}),format.raw/*33.2*/("""
"""),format.raw/*34.1*/("""<div>
    <a href=""""),_display_(/*35.15*/routes/*35.21*/.tweet.logout),format.raw/*35.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*39.15*/routes/*39.21*/.tweet.home),format.raw/*39.32*/("""" id="home">Home</a>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],user:String,exists:Boolean,followExist:Boolean,request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,user,exists,followExist)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],String,Boolean,Boolean) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,user,exists,followExist) => (request,flash) => apply(tweets,following,user,exists,followExist)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: df7687013e1b51b08e1beca961375a1d8177404c
                  MATRIX: 824->1|1087->171|1114->172|1178->211|1205->230|1244->232|1275->237|1315->261|1326->266|1363->267|1390->268|1447->298|1472->302|1513->317|1546->341|1586->343|1614->344|1674->377|1689->383|1723->396|1774->417|1803->419|1878->468|1918->492|1957->493|1989->498|2019->502|2046->508|2086->518|2114->519|2158->537|2196->559|2236->561|2268->566|2321->592|2337->599|2363->604|2413->624|2441->625|2478->632|2506->633|2553->653|2568->659|2602->672|2682->725|2697->731|2729->742
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|37->13|37->13|37->13|38->14|39->15|39->15|39->15|41->17|43->19|45->21|45->21|45->21|46->22|46->22|46->22|47->23|48->24|51->27|51->27|51->27|52->28|53->29|53->29|53->29|55->31|56->32|57->33|58->34|59->35|59->35|59->35|63->39|63->39|63->39
                  -- GENERATED --
              */
          