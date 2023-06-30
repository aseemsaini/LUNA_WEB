
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
<head>
    <meta charset="UTF-8">
    <title>Luna | SearchProfile</title>
    <link rel="stylesheet" href="/assets/stylesheets/searchProfile.css">
</head>
<body>

<div class="logo">
    <img src="/assets/images/luna_logo.png">
</div>
<h1>Profile Search</h1>
"""),_display_(/*15.2*/if(exists == false)/*15.21*/ {_display_(Seq[Any](format.raw/*15.23*/("""
"""),format.raw/*16.1*/("""<div class="user-not-found">
    <h2>Error</h2>
    <h3>User not found</h3>
</div>
""")))}/*20.3*/else/*20.8*/{_display_(Seq[Any](format.raw/*20.9*/("""
"""),format.raw/*21.1*/("""<div id="user_name">
    <h2 class="user">"""),_display_(/*22.23*/user),format.raw/*22.27*/("""</h2>
</div>
"""),_display_(/*24.2*/if(followExist == false)/*24.26*/ {_display_(Seq[Any](format.raw/*24.28*/("""

"""),format.raw/*26.1*/("""<a class="follow" href=""""),_display_(/*26.26*/routes/*26.32*/.tweet.follow),format.raw/*26.45*/("""">Follow</a>

""")))}/*28.3*/else/*28.8*/{_display_(Seq[Any](format.raw/*28.9*/("""
"""),format.raw/*29.1*/("""<a class="unfollow" href=""""),_display_(/*29.28*/routes/*29.34*/.tweet.unfollow),format.raw/*29.49*/("""">Unfollow</a>
""")))}),format.raw/*30.2*/("""
"""),format.raw/*31.1*/("""<div id="followers-following">
    <div id="followers" class="followers-section">
        <h3 class="followers-header">Followers</h3>
        """),_display_(/*34.10*/for(people <- followers) yield /*34.34*/ {_display_(Seq[Any](format.raw/*34.36*/("""
        """),format.raw/*35.9*/("""<p class="followers-person">"""),_display_(/*35.38*/people),format.raw/*35.44*/("""</p>
        """)))}),format.raw/*36.10*/("""
    """),format.raw/*37.5*/("""</div>
    <div id="following" class="following-section">
        <h3 class="following-header">Following</h3>
        """),_display_(/*40.10*/for(people <- following) yield /*40.34*/ {_display_(Seq[Any](format.raw/*40.36*/("""
        """),format.raw/*41.9*/("""<p class="following-person">"""),_display_(/*41.38*/people),format.raw/*41.44*/("""</p>
        """)))}),format.raw/*42.10*/("""
    """),format.raw/*43.5*/("""</div>
</div>

<div class="tweets-container">
    <div class="container">
        <ul class="tweet-list">
            """),_display_(/*49.14*/for(message <- tweets) yield /*49.36*/ {_display_(Seq[Any](format.raw/*49.38*/("""
            """),format.raw/*50.13*/("""<li class="tweet-item">
                <div class="message-container">
                    <p class="message-text">Tweet: <span id="message-"""),_display_(/*52.71*/message/*52.78*/.messageId),format.raw/*52.88*/("""">"""),_display_(/*52.91*/message/*52.98*/.text),format.raw/*52.103*/("""</span></p>
                </div>
            </li>
            """)))}),format.raw/*55.14*/("""
        """),format.raw/*56.9*/("""</ul>
    </div>
</div>

""")))}),format.raw/*60.2*/("""
"""),format.raw/*61.1*/("""<a class="logout" href=""""),_display_(/*61.26*/routes/*61.32*/.tweet.logout),format.raw/*61.45*/("""">Logout</a>
<a class="home" href=""""),_display_(/*62.24*/routes/*62.30*/.tweet.home),format.raw/*62.41*/("""">Home</a>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>
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
                  HASH: 30cb1abffa22163c96851dca1939950febcb9d1c
                  MATRIX: 836->1|1123->195|1150->196|1442->462|1470->481|1510->483|1538->484|1640->569|1652->574|1690->575|1718->576|1788->619|1813->623|1853->637|1886->661|1926->663|1955->665|2007->690|2022->696|2056->709|2089->725|2101->730|2139->731|2167->732|2221->759|2236->765|2272->780|2318->796|2346->797|2516->940|2556->964|2596->966|2632->975|2688->1004|2715->1010|2760->1024|2792->1029|2938->1148|2978->1172|3018->1174|3054->1183|3110->1212|3137->1218|3182->1232|3214->1237|3360->1356|3398->1378|3438->1380|3479->1393|3648->1535|3664->1542|3695->1552|3725->1555|3741->1562|3768->1567|3865->1633|3901->1642|3957->1668|3985->1669|4037->1694|4052->1700|4086->1713|4149->1749|4164->1755|4196->1766
                  LINES: 21->1|26->2|27->3|39->15|39->15|39->15|40->16|44->20|44->20|44->20|45->21|46->22|46->22|48->24|48->24|48->24|50->26|50->26|50->26|50->26|52->28|52->28|52->28|53->29|53->29|53->29|53->29|54->30|55->31|58->34|58->34|58->34|59->35|59->35|59->35|60->36|61->37|64->40|64->40|64->40|65->41|65->41|65->41|66->42|67->43|73->49|73->49|73->49|74->50|76->52|76->52|76->52|76->52|76->52|76->52|79->55|80->56|84->60|85->61|85->61|85->61|85->61|86->62|86->62|86->62
                  -- GENERATED --
              */
          