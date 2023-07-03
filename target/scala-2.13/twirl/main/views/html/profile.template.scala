
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],Seq[Int],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers:Seq[String], likes:Seq[Int])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Luna | Profile</title>
    <link rel="stylesheet" href="/assets/stylesheets/profile.css">
</head>
<body>
<header class="header-style">
    <h1>Hello, Welcome to your profile</h1>
</header>

<div class="logo">
    <img src="/assets/images/luna_logo.png">
</div>

<div class="followers-section">
    <h3 class="followers-header">Followers</h3>
    """),_display_(/*21.6*/for(people <- followers) yield /*21.30*/{_display_(Seq[Any](format.raw/*21.31*/("""
    """),format.raw/*22.5*/("""<div class="followers-item">
        <p>"""),_display_(/*23.13*/people),format.raw/*23.19*/("""</p>
    </div>
    """)))}),format.raw/*25.6*/("""
"""),format.raw/*26.1*/("""</div>

<div class="following-section">
    <h3 class="following-header">Following</h3>
    """),_display_(/*30.6*/for(people <- following) yield /*30.30*/{_display_(Seq[Any](format.raw/*30.31*/("""
    """),format.raw/*31.5*/("""<div class="following-item">
        <p>"""),_display_(/*32.13*/people),format.raw/*32.19*/("""</p>
    </div>
    """)))}),format.raw/*34.6*/("""
"""),format.raw/*35.1*/("""</div>

<div class="tweets-container">
    <div class="container">
        <ul class="tweet-list">
            """),_display_(/*40.14*/for(((message, like), index) <- tweets.zip(likes).zipWithIndex) yield /*40.77*/ {_display_(Seq[Any](format.raw/*40.79*/("""
            """),format.raw/*41.13*/("""<li class="tweet-item">
                <div class="message-container">
                    <p class="message-text">Message: <span id="message-"""),_display_(/*43.73*/message/*43.80*/.messageId),format.raw/*43.90*/("""">"""),_display_(/*43.93*/message/*43.100*/.text),format.raw/*43.105*/("""</span></p>
                    <p class="likes"><span class="heart"></span> """),_display_(/*44.67*/like),format.raw/*44.71*/("""</p>

                </div>
                <form class="tweet-form" method="post" action=""""),_display_(/*47.65*/routes/*47.71*/.tweet.editTweet),format.raw/*47.87*/("""">
                    """),_display_(/*48.22*/helper/*48.28*/.CSRF.formField),format.raw/*48.43*/("""
                    """),format.raw/*49.21*/("""<input type="hidden" name="editTweetId" value=""""),_display_(/*49.69*/message/*49.76*/.messageId),format.raw/*49.86*/("""">
                    <input class="edit-tweet-input" type="text" name="editTweetText" value=""""),_display_(/*50.94*/message/*50.101*/.text),format.raw/*50.106*/("""" style="display:none;">
                    <div class="button-container">
                        <button class="edit-button" type="button" onclick="toggleEditField("""),_display_(/*52.93*/message/*52.100*/.messageId),format.raw/*52.110*/(""")">Edit</button>
                        <button class="save-button" type="submit" style="display:none;">Save</button>
                    </div>
                </form>
                <form class="delete-tweet-form" method="post" action=""""),_display_(/*56.72*/routes/*56.78*/.tweet.deleteTweet),format.raw/*56.96*/("""">
                    """),_display_(/*57.22*/helper/*57.28*/.CSRF.formField),format.raw/*57.43*/("""
                    """),format.raw/*58.21*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*58.69*/message/*58.76*/.text),format.raw/*58.81*/("""">
                    <button class="delete-button" type="submit">Delete</button>
                </form>
            </li>
            """)))}),format.raw/*62.14*/("""
        """),format.raw/*63.9*/("""</ul>
    </div>
</div>

<a class="logout" href=""""),_display_(/*67.26*/routes/*67.32*/.tweet.logout),format.raw/*67.45*/("""">Logout</a>
<a class="home" href=""""),_display_(/*68.24*/routes/*68.30*/.tweet.home),format.raw/*68.41*/("""">Home</a>

<script>
      function toggleEditField(messageId) """),format.raw/*71.43*/("""{"""),format.raw/*71.44*/("""
      """),format.raw/*72.7*/("""var messageTextElement = document.getElementById('message-' + messageId);
      var inputField = document.querySelector('input[name="editTweetText"][value="' + messageTextElement.textContent + '"]');
      var saveButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.save-button');
      var cancelButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.edit-button');

      if (inputField.style.display === "none") """),format.raw/*77.48*/("""{"""),format.raw/*77.49*/("""
        """),format.raw/*78.9*/("""inputField.style.display = "inline-block";
        saveButton.style.display = "inline-block";
        cancelButton.textContent = "Cancel";
        messageTextElement.style.display = "none";
      """),format.raw/*82.7*/("""}"""),format.raw/*82.8*/(""" """),format.raw/*82.9*/("""else """),format.raw/*82.14*/("""{"""),format.raw/*82.15*/("""
        """),format.raw/*83.9*/("""inputField.style.display = "none";
        saveButton.style.display = "none";
        cancelButton.textContent = "Edit";
        messageTextElement.style.display = "inline";
      """),format.raw/*87.7*/("""}"""),format.raw/*87.8*/("""
    """),format.raw/*88.5*/("""}"""),format.raw/*88.6*/("""

"""),format.raw/*90.1*/("""</script>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>

</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],likes:Seq[Int],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,followers,likes)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],Seq[Int]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,followers,likes) => (request,flash) => apply(tweets,following,followers,likes)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 1fc6b6ebef432ade508116f62eac6fb66a53eb05
                  MATRIX: 816->1|1068->160|1095->161|1546->586|1586->610|1625->611|1657->616|1725->657|1752->663|1803->684|1831->685|1950->778|1990->802|2029->803|2061->808|2129->849|2156->855|2207->876|2235->877|2374->989|2453->1052|2493->1054|2534->1067|2705->1211|2721->1218|2752->1228|2782->1231|2799->1238|2826->1243|2931->1321|2956->1325|3076->1418|3091->1424|3128->1440|3179->1464|3194->1470|3230->1485|3279->1506|3354->1554|3370->1561|3401->1571|3524->1667|3541->1674|3568->1679|3763->1847|3780->1854|3812->1864|4080->2105|4095->2111|4134->2129|4185->2153|4200->2159|4236->2174|4285->2195|4360->2243|4376->2250|4402->2255|4571->2393|4607->2402|4684->2452|4699->2458|4733->2471|4796->2507|4811->2513|4843->2524|4934->2587|4963->2588|4997->2595|5563->3133|5592->3134|5628->3143|5851->3339|5879->3340|5907->3341|5940->3346|5969->3347|6005->3356|6212->3536|6240->3537|6272->3542|6300->3543|6329->3545
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|47->23|47->23|49->25|50->26|54->30|54->30|54->30|55->31|56->32|56->32|58->34|59->35|64->40|64->40|64->40|65->41|67->43|67->43|67->43|67->43|67->43|67->43|68->44|68->44|71->47|71->47|71->47|72->48|72->48|72->48|73->49|73->49|73->49|73->49|74->50|74->50|74->50|76->52|76->52|76->52|80->56|80->56|80->56|81->57|81->57|81->57|82->58|82->58|82->58|82->58|86->62|87->63|91->67|91->67|91->67|92->68|92->68|92->68|95->71|95->71|96->72|101->77|101->77|102->78|106->82|106->82|106->82|106->82|106->82|107->83|111->87|111->87|112->88|112->88|114->90
                  -- GENERATED --
              */
          