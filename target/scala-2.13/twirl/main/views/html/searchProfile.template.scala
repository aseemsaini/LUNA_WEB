
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

object searchProfile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template10[Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],String,Boolean,Boolean,Seq[Int],Seq[java.sql.Timestamp],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers: Seq[String], user:String, exists:Boolean, followExist:Boolean, likes: Seq[Int], time: Seq[java.sql.Timestamp])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
            """),_display_(/*49.14*/for(((message, likes), index) <- tweets.zip(likes).zipWithIndex) yield /*49.78*/  {_display_(Seq[Any](format.raw/*49.81*/("""
            """),format.raw/*50.13*/("""<li class="tweet-item">
                <div class="message-container">
                    <p class="message-text">Tweet: <span id="message-"""),_display_(/*52.71*/message/*52.78*/.messageId),format.raw/*52.88*/("""">"""),_display_(/*52.91*/message/*52.98*/.text),format.raw/*52.103*/("""</span></p>
                    <p class="likes"><span class="heart"></span> """),_display_(/*53.67*/likes),format.raw/*53.72*/("""
                        """),format.raw/*54.25*/("""<span class="time">
                      <script>
                        var timestamp = new Date(""""),_display_(/*56.52*/time(index)),format.raw/*56.63*/("""");
                        var options = """),format.raw/*57.39*/("""{"""),format.raw/*57.40*/("""
                          """),format.raw/*58.27*/("""day: "2-digit",
                          month: "long",
                          year: "2-digit",
                          hour: "2-digit",
                          minute: "2-digit",
                        """),format.raw/*63.25*/("""}"""),format.raw/*63.26*/(""";
                        var formattedTime = timestamp.toLocaleString("en-UK", options);
                        document.write(formattedTime);
                      </script>
                    </span>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*71.14*/("""
        """),format.raw/*72.9*/("""</ul>
    </div>
</div>

""")))}),format.raw/*76.2*/("""
"""),format.raw/*77.1*/("""<a class="logout" href=""""),_display_(/*77.26*/routes/*77.32*/.tweet.logout),format.raw/*77.45*/("""">Logout</a>
<a class="home" href=""""),_display_(/*78.24*/routes/*78.30*/.tweet.home),format.raw/*78.41*/("""">Home</a>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>
</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],user:String,exists:Boolean,followExist:Boolean,likes:Seq[Int],time:Seq[java.sql.Timestamp],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,followers,user,exists,followExist,likes,time)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],String,Boolean,Boolean,Seq[Int],Seq[java.sql.Timestamp]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,followers,user,exists,followExist,likes,time) => (request,flash) => apply(tweets,following,followers,user,exists,followExist,likes,time)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchProfile.scala.html
                  HASH: e8e0761b8f26bb1dd56b5989529d8f00b0c09335
                  MATRIX: 870->1|1205->243|1232->244|1524->510|1552->529|1592->531|1620->532|1722->617|1734->622|1772->623|1800->624|1870->667|1895->671|1935->685|1968->709|2008->711|2037->713|2089->738|2104->744|2138->757|2171->773|2183->778|2221->779|2249->780|2303->807|2318->813|2354->828|2400->844|2428->845|2598->988|2638->1012|2678->1014|2714->1023|2770->1052|2797->1058|2842->1072|2874->1077|3020->1196|3060->1220|3100->1222|3136->1231|3192->1260|3219->1266|3264->1280|3296->1285|3442->1404|3522->1468|3563->1471|3604->1484|3773->1626|3789->1633|3820->1643|3850->1646|3866->1653|3893->1658|3998->1736|4024->1741|4077->1766|4206->1868|4238->1879|4308->1921|4337->1922|4392->1949|4632->2161|4661->2162|4976->2446|5012->2455|5068->2481|5096->2482|5148->2507|5163->2513|5197->2526|5260->2562|5275->2568|5307->2579
                  LINES: 21->1|26->2|27->3|39->15|39->15|39->15|40->16|44->20|44->20|44->20|45->21|46->22|46->22|48->24|48->24|48->24|50->26|50->26|50->26|50->26|52->28|52->28|52->28|53->29|53->29|53->29|53->29|54->30|55->31|58->34|58->34|58->34|59->35|59->35|59->35|60->36|61->37|64->40|64->40|64->40|65->41|65->41|65->41|66->42|67->43|73->49|73->49|73->49|74->50|76->52|76->52|76->52|76->52|76->52|76->52|77->53|77->53|78->54|80->56|80->56|81->57|81->57|82->58|87->63|87->63|95->71|96->72|100->76|101->77|101->77|101->77|101->77|102->78|102->78|102->78
                  -- GENERATED --
              */
          