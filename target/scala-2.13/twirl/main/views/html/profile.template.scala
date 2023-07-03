
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers:Seq[String])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
            """),_display_(/*40.14*/for(message <- tweets) yield /*40.36*/ {_display_(Seq[Any](format.raw/*40.38*/("""
            """),format.raw/*41.13*/("""<li class="tweet-item">
                <div class="message-container">
                    <p class="message-text">Message: <span id="message-"""),_display_(/*43.73*/message/*43.80*/.messageId),format.raw/*43.90*/("""">"""),_display_(/*43.93*/message/*43.100*/.text),format.raw/*43.105*/("""</span></p>
                </div>
                <form class="tweet-form" method="post" action=""""),_display_(/*45.65*/routes/*45.71*/.tweet.editTweet),format.raw/*45.87*/("""">
                    """),_display_(/*46.22*/helper/*46.28*/.CSRF.formField),format.raw/*46.43*/("""
                    """),format.raw/*47.21*/("""<input type="hidden" name="editTweetId" value=""""),_display_(/*47.69*/message/*47.76*/.messageId),format.raw/*47.86*/("""">
                    <input class="edit-tweet-input" type="text" name="editTweetText" value=""""),_display_(/*48.94*/message/*48.101*/.text),format.raw/*48.106*/("""" style="display:none;">
                    <div class="button-container">
                        <button class="edit-button" type="button" onclick="toggleEditField("""),_display_(/*50.93*/message/*50.100*/.messageId),format.raw/*50.110*/(""")">Edit</button>
                        <button class="save-button" type="submit" style="display:none;">Save</button>
                    </div>
                </form>
                <form class="delete-tweet-form" method="post" action=""""),_display_(/*54.72*/routes/*54.78*/.tweet.deleteTweet),format.raw/*54.96*/("""">
                    """),_display_(/*55.22*/helper/*55.28*/.CSRF.formField),format.raw/*55.43*/("""
                    """),format.raw/*56.21*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*56.69*/message/*56.76*/.text),format.raw/*56.81*/("""">
                    <button class="delete-button" type="submit">Delete</button>
                </form>
            </li>
            """)))}),format.raw/*60.14*/("""
        """),format.raw/*61.9*/("""</ul>
    </div>
</div>

<a class="logout" href=""""),_display_(/*65.26*/routes/*65.32*/.tweet.logout),format.raw/*65.45*/("""">Logout</a>
<a class="home" href=""""),_display_(/*66.24*/routes/*66.30*/.tweet.home),format.raw/*66.41*/("""">Home</a>

<script>
      function toggleEditField(messageId) """),format.raw/*69.43*/("""{"""),format.raw/*69.44*/("""
      """),format.raw/*70.7*/("""var messageTextElement = document.getElementById('message-' + messageId);
      var inputField = document.querySelector('input[name="editTweetText"][value="' + messageTextElement.textContent + '"]');
      var saveButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.save-button');
      var cancelButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.edit-button');

      if (inputField.style.display === "none") """),format.raw/*75.48*/("""{"""),format.raw/*75.49*/("""
        """),format.raw/*76.9*/("""inputField.style.display = "inline-block";
        saveButton.style.display = "inline-block";
        cancelButton.textContent = "Cancel";
        messageTextElement.style.display = "none";
      """),format.raw/*80.7*/("""}"""),format.raw/*80.8*/(""" """),format.raw/*80.9*/("""else """),format.raw/*80.14*/("""{"""),format.raw/*80.15*/("""
        """),format.raw/*81.9*/("""inputField.style.display = "none";
        saveButton.style.display = "none";
        cancelButton.textContent = "Edit";
        messageTextElement.style.display = "inline";
      """),format.raw/*85.7*/("""}"""),format.raw/*85.8*/("""
    """),format.raw/*86.5*/("""}"""),format.raw/*86.6*/("""

"""),format.raw/*88.1*/("""</script>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>

</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,followers)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Seq[String]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,followers) => (request,flash) => apply(tweets,following,followers)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: 805340b7ab1a7cdd83be2498efa1666982f4fd34
                  MATRIX: 807->1|1043->144|1070->145|1521->570|1561->594|1600->595|1632->600|1700->641|1727->647|1778->668|1806->669|1925->762|1965->786|2004->787|2036->792|2104->833|2131->839|2182->860|2210->861|2349->973|2387->995|2427->997|2468->1010|2639->1154|2655->1161|2686->1171|2716->1174|2733->1181|2760->1186|2886->1285|2901->1291|2938->1307|2989->1331|3004->1337|3040->1352|3089->1373|3164->1421|3180->1428|3211->1438|3334->1534|3351->1541|3378->1546|3573->1714|3590->1721|3622->1731|3890->1972|3905->1978|3944->1996|3995->2020|4010->2026|4046->2041|4095->2062|4170->2110|4186->2117|4212->2122|4381->2260|4417->2269|4494->2319|4509->2325|4543->2338|4606->2374|4621->2380|4653->2391|4744->2454|4773->2455|4807->2462|5373->3000|5402->3001|5438->3010|5661->3206|5689->3207|5717->3208|5750->3213|5779->3214|5815->3223|6022->3403|6050->3404|6082->3409|6110->3410|6139->3412
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|47->23|47->23|49->25|50->26|54->30|54->30|54->30|55->31|56->32|56->32|58->34|59->35|64->40|64->40|64->40|65->41|67->43|67->43|67->43|67->43|67->43|67->43|69->45|69->45|69->45|70->46|70->46|70->46|71->47|71->47|71->47|71->47|72->48|72->48|72->48|74->50|74->50|74->50|78->54|78->54|78->54|79->55|79->55|79->55|80->56|80->56|80->56|80->56|84->60|85->61|89->65|89->65|89->65|90->66|90->66|90->66|93->69|93->69|94->70|99->75|99->75|100->76|104->80|104->80|104->80|104->80|104->80|105->81|109->85|109->85|110->86|110->86|112->88
                  -- GENERATED --
              */
          