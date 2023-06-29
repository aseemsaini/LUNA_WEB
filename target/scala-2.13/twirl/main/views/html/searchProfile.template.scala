
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],String,Boolean,Boolean,MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers: Seq[String], user:String, exists:Boolean, followExist:Boolean)(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Profile Search</h1>
"""),_display_(/*6.2*/if(exists == false)/*6.21*/ {_display_(Seq[Any](format.raw/*6.23*/("""
"""),format.raw/*7.1*/("""<p>User not found</p>
""")))}/*8.3*/else/*8.8*/{_display_(Seq[Any](format.raw/*8.9*/("""
"""),format.raw/*9.1*/("""<div id="user_name">
    <h2>"""),_display_(/*10.10*/user),format.raw/*10.14*/("""</h2>
</div>

"""),_display_(/*13.2*/if(followExist == false)/*13.26*/ {_display_(Seq[Any](format.raw/*13.28*/("""
"""),format.raw/*14.1*/("""<div id="follow">
    <a href=""""),_display_(/*15.15*/routes/*15.21*/.tweet.follow),format.raw/*15.34*/("""">Follow</a>
</div>
""")))}),format.raw/*17.2*/("""

"""),format.raw/*19.1*/("""<div id="following">
    <h3>Following</h3>
    """),_display_(/*21.6*/for(people <- following) yield /*21.30*/{_display_(Seq[Any](format.raw/*21.31*/("""
    """),format.raw/*22.5*/("""<p>"""),_display_(/*22.9*/people),format.raw/*22.15*/("""</p>
    """)))}),format.raw/*23.6*/("""
"""),format.raw/*24.1*/("""</div>

<div id="followers">
    <h3>Followers</h3>
    """),_display_(/*28.6*/for(people <- followers) yield /*28.30*/{_display_(Seq[Any](format.raw/*28.31*/("""
        """),format.raw/*29.9*/("""<p>"""),_display_(/*29.13*/people),format.raw/*29.19*/("""</p>
    """)))}),format.raw/*30.6*/("""
"""),format.raw/*31.1*/("""</div>

<ul>
    """),_display_(/*34.6*/for(message <- tweets) yield /*34.28*/ {_display_(Seq[Any](format.raw/*34.30*/("""
    """),format.raw/*35.5*/("""<li>
        <p>Message: """),_display_(/*36.22*/message/*36.29*/.text),format.raw/*36.34*/("""</p>
    </li>
    """)))}),format.raw/*38.6*/("""
"""),format.raw/*39.1*/("""</ul>
""")))}),format.raw/*40.2*/("""
"""),format.raw/*41.1*/("""<div>
    <a href=""""),_display_(/*42.15*/routes/*42.21*/.tweet.logout),format.raw/*42.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*46.15*/routes/*46.21*/.tweet.home),format.raw/*46.32*/("""" id="home">Home</a>
</div>
</body>
</html>

"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],user:String,exists:Boolean,followExist:Boolean,request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,followers,user,exists,followExist)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],String,Boolean,Boolean) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,followers,user,exists,followExist) => (request,flash) => apply(tweets,following,followers,user,exists,followExist)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: 308317011b2d888a48d68135a12e7529b8739df7
                  MATRIX: 836->1|1123->195|1150->196|1214->235|1241->254|1280->256|1307->257|1347->281|1358->286|1395->287|1422->288|1479->318|1504->322|1545->337|1578->361|1618->363|1646->364|1705->396|1720->402|1754->415|1805->436|1834->438|1909->487|1949->511|1988->512|2020->517|2050->521|2077->527|2117->537|2145->538|2228->595|2268->619|2307->620|2343->629|2374->633|2401->639|2441->649|2469->650|2513->668|2551->690|2591->692|2623->697|2676->723|2692->730|2718->735|2768->755|2796->756|2833->763|2861->764|2908->784|2923->790|2957->803|3037->856|3052->862|3084->873
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|37->13|37->13|37->13|38->14|39->15|39->15|39->15|41->17|43->19|45->21|45->21|45->21|46->22|46->22|46->22|47->23|48->24|52->28|52->28|52->28|53->29|53->29|53->29|54->30|55->31|58->34|58->34|58->34|59->35|60->36|60->36|60->36|62->38|63->39|64->40|65->41|66->42|66->42|66->42|70->46|70->46|70->46
                  -- GENERATED --
              */
          