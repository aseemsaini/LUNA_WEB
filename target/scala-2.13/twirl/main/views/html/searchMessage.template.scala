
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

object searchMessage extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[String],Seq[String],Seq[Int],Seq[java.sql.Timestamp],play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(matchingMessages: Seq[String], matchingUsers: Seq[String], likes:Seq[Int], time: Seq[java.sql.Timestamp]):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Search Results</title>
    <link rel="stylesheet" href="/assets/stylesheets/searchProfile.css">
</head>
<body>
<div class="logo">
    <img src="/assets/images/luna_logo.png">
</div>
<h1>Search Results</h1>
"""),_display_(/*15.2*/if(matchingMessages.isEmpty)/*15.30*/ {_display_(Seq[Any](format.raw/*15.32*/("""
"""),format.raw/*16.1*/("""<div class="user-not-found">
    <h2>Error</h2>
    <h3>No matching messages found</h3>
</div>
""")))}/*20.3*/else/*20.8*/{_display_(Seq[Any](format.raw/*20.9*/("""
"""),format.raw/*21.1*/("""<div class="tweets-container">
    <div class="container">
        <ul class="tweet-list">
            """),_display_(/*24.14*/for((message, index) <- matchingMessages.zipWithIndex) yield /*24.68*/ {_display_(Seq[Any](format.raw/*24.70*/("""
            """),format.raw/*25.13*/("""<li class="tweet-item">
                <div class="message-container">

                    <p class="message-text"><em style="color: #6a5cd0; font-size: 0.9em; margin-right: 15px;">"""),_display_(/*28.112*/matchingUsers(index)),format.raw/*28.132*/(""":</em><span id="message-"""),_display_(/*28.157*/message),format.raw/*28.164*/("""">"""),_display_(/*28.167*/message),format.raw/*28.174*/("""</span></p>
                    <p class="likes"><span class="heart"></span> """),_display_(/*29.67*/likes(index)),format.raw/*29.79*/("""
                        """),format.raw/*30.25*/("""<span class="time">
                      <script>
                        var timestamp = new Date(""""),_display_(/*32.52*/time(index)),format.raw/*32.63*/("""");
                        var options = """),format.raw/*33.39*/("""{"""),format.raw/*33.40*/("""
                          """),format.raw/*34.27*/("""day: "2-digit",
                          month: "long",
                          year: "2-digit",
                          hour: "2-digit",
                          minute: "2-digit",
                        """),format.raw/*39.25*/("""}"""),format.raw/*39.26*/(""";
                        var formattedTime = timestamp.toLocaleString("en-UK", options);
                        document.write(formattedTime);
                      </script>
                    </span>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*47.14*/("""
        """),format.raw/*48.9*/("""</ul>
    </div>
</div>
""")))}),format.raw/*51.2*/("""
"""),format.raw/*52.1*/("""<a class="logout" href=""""),_display_(/*52.26*/routes/*52.32*/.tweet.logout),format.raw/*52.45*/("""">Logout</a>
<a class="home" href=""""),_display_(/*53.24*/routes/*53.30*/.tweet.home),format.raw/*53.41*/("""">Home</a>
<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>
</body>
</html>
"""))
      }
    }
  }

  def render(matchingMessages:Seq[String],matchingUsers:Seq[String],likes:Seq[Int],time:Seq[java.sql.Timestamp]): play.twirl.api.HtmlFormat.Appendable = apply(matchingMessages,matchingUsers,likes,time)

  def f:((Seq[String],Seq[String],Seq[Int],Seq[java.sql.Timestamp]) => play.twirl.api.HtmlFormat.Appendable) = (matchingMessages,matchingUsers,likes,time) => apply(matchingMessages,matchingUsers,likes,time)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/searchMessage.scala.html
                  HASH: c1459fec7506a30d4f07b777d2cf04087afea8cf
                  MATRIX: 787->1|987->108|1014->109|1325->394|1362->422|1402->424|1430->425|1544->522|1556->527|1594->528|1622->529|1753->633|1823->687|1863->689|1904->702|2116->886|2158->906|2211->931|2240->938|2271->941|2300->948|2405->1026|2438->1038|2491->1063|2620->1165|2652->1176|2722->1218|2751->1219|2806->1246|3046->1458|3075->1459|3390->1743|3426->1752|3481->1777|3509->1778|3561->1803|3576->1809|3610->1822|3673->1858|3688->1864|3720->1875
                  LINES: 21->1|26->2|27->3|39->15|39->15|39->15|40->16|44->20|44->20|44->20|45->21|48->24|48->24|48->24|49->25|52->28|52->28|52->28|52->28|52->28|52->28|53->29|53->29|54->30|56->32|56->32|57->33|57->33|58->34|63->39|63->39|71->47|72->48|75->51|76->52|76->52|76->52|76->52|77->53|77->53|77->53
                  -- GENERATED --
              */
          