
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
""")))}/*17.3*/else/*17.8*/{_display_(Seq[Any](format.raw/*17.9*/("""
"""),format.raw/*18.1*/("""<a href=""""),_display_(/*18.11*/routes/*18.17*/.tweet.unfollow),format.raw/*18.32*/("""">Unfollow</a>
""")))}),format.raw/*19.2*/("""

"""),format.raw/*21.1*/("""<div id="following">
    <h3>Following</h3>
    """),_display_(/*23.6*/for(people <- following) yield /*23.30*/{_display_(Seq[Any](format.raw/*23.31*/("""
    """),format.raw/*24.5*/("""<p>"""),_display_(/*24.9*/people),format.raw/*24.15*/("""</p>
    """)))}),format.raw/*25.6*/("""
"""),format.raw/*26.1*/("""</div>

<div id="followers">
    <h3>Followers</h3>
    """),_display_(/*30.6*/for(people <- followers) yield /*30.30*/{_display_(Seq[Any](format.raw/*30.31*/("""
        """),format.raw/*31.9*/("""<p>"""),_display_(/*31.13*/people),format.raw/*31.19*/("""</p>
    """)))}),format.raw/*32.6*/("""
"""),format.raw/*33.1*/("""</div>

<ul>
    """),_display_(/*36.6*/for(message <- tweets) yield /*36.28*/ {_display_(Seq[Any](format.raw/*36.30*/("""
    """),format.raw/*37.5*/("""<li>
        <p>Message: """),_display_(/*38.22*/message/*38.29*/.text),format.raw/*38.34*/("""</p>
    </li>
    """)))}),format.raw/*40.6*/("""
"""),format.raw/*41.1*/("""</ul>
""")))}),format.raw/*42.2*/("""
"""),format.raw/*43.1*/("""<div>
    <a href=""""),_display_(/*44.15*/routes/*44.21*/.tweet.logout),format.raw/*44.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*48.15*/routes/*48.21*/.tweet.home),format.raw/*48.32*/("""" id="home">Home</a>
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
                  HASH: d432247b176fb156f0b6deb2eafe6b1c601444fa
                  MATRIX: 836->1|1123->195|1150->196|1214->235|1241->254|1280->256|1307->257|1347->281|1358->286|1395->287|1422->288|1479->318|1504->322|1545->337|1578->361|1618->363|1646->364|1705->396|1720->402|1754->415|1793->437|1805->442|1843->443|1871->444|1908->454|1923->460|1959->475|2005->491|2034->493|2109->542|2149->566|2188->567|2220->572|2250->576|2277->582|2317->592|2345->593|2428->650|2468->674|2507->675|2543->684|2574->688|2601->694|2641->704|2669->705|2713->723|2751->745|2791->747|2823->752|2876->778|2892->785|2918->790|2968->810|2996->811|3033->818|3061->819|3108->839|3123->845|3157->858|3237->911|3252->917|3284->928
                  LINES: 21->1|26->2|27->3|30->6|30->6|30->6|31->7|32->8|32->8|32->8|33->9|34->10|34->10|37->13|37->13|37->13|38->14|39->15|39->15|39->15|41->17|41->17|41->17|42->18|42->18|42->18|42->18|43->19|45->21|47->23|47->23|47->23|48->24|48->24|48->24|49->25|50->26|54->30|54->30|54->30|55->31|55->31|55->31|56->32|57->33|60->36|60->36|60->36|61->37|62->38|62->38|62->38|64->40|65->41|66->42|67->43|68->44|68->44|68->44|72->48|72->48|72->48
                  -- GENERATED --
              */
          