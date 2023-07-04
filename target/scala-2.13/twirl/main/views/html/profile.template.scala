
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template8[String,Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],Seq[Int],Seq[java.sql.Timestamp],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(username: String, tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers:Seq[String], likes:Seq[Int], time: Seq[java.sql.Timestamp])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
    <h2>"""),_display_(/*13.10*/username),format.raw/*13.18*/("""</h2>
</header>

<div class="logo">
    <img src="/assets/images/luna_logo.png">
</div>

<div class="followers-section">
    <h3 class="followers-header">Followers</h3>
    """),_display_(/*22.6*/for(people <- followers) yield /*22.30*/{_display_(Seq[Any](format.raw/*22.31*/("""
    """),format.raw/*23.5*/("""<div class="followers-item">
        <p>"""),_display_(/*24.13*/people),format.raw/*24.19*/("""</p>
    </div>
    """)))}),format.raw/*26.6*/("""
"""),format.raw/*27.1*/("""</div>

<div class="following-section">
    <h3 class="following-header">Following</h3>
    """),_display_(/*31.6*/for(people <- following) yield /*31.30*/{_display_(Seq[Any](format.raw/*31.31*/("""
    """),format.raw/*32.5*/("""<div class="following-item">
        <p>"""),_display_(/*33.13*/people),format.raw/*33.19*/("""</p>
    </div>
    """)))}),format.raw/*35.6*/("""
"""),format.raw/*36.1*/("""</div>

<div class="tweets-container">
    <div class="container">
        <ul class="tweet-list">
            """),_display_(/*41.14*/for(((message, like), index) <- tweets.zip(likes).zipWithIndex) yield /*41.77*/ {_display_(Seq[Any](format.raw/*41.79*/("""
            """),format.raw/*42.13*/("""<li class="tweet-item">
                <div class="message-container">
                    <p class="message-text">Message: <span id="message-"""),_display_(/*44.73*/message/*44.80*/.messageId),format.raw/*44.90*/("""">"""),_display_(/*44.93*/message/*44.100*/.text),format.raw/*44.105*/("""</span></p>
                    <p class="likes"><span class="heart"></span> """),_display_(/*45.67*/like),format.raw/*45.71*/("""
                        """),format.raw/*46.25*/("""<span class="time">
                      <script>
                        var timestamp = new Date(""""),_display_(/*48.52*/time(index)),format.raw/*48.63*/("""");
                        var options = """),format.raw/*49.39*/("""{"""),format.raw/*49.40*/("""
                          """),format.raw/*50.27*/("""day: "2-digit",
                          month: "long",
                          year: "2-digit",
                          hour: "2-digit",
                          minute: "2-digit",
                        """),format.raw/*55.25*/("""}"""),format.raw/*55.26*/(""";
                        var formattedTime = timestamp.toLocaleString("en-UK", options);
                        document.write(formattedTime);
                      </script>
                    </span>
                    </p>


                </div>
                <form class="tweet-form" method="post" action=""""),_display_(/*64.65*/routes/*64.71*/.tweet.editTweet),format.raw/*64.87*/("""">
                    """),_display_(/*65.22*/helper/*65.28*/.CSRF.formField),format.raw/*65.43*/("""
                    """),format.raw/*66.21*/("""<input type="hidden" name="editTweetId" value=""""),_display_(/*66.69*/message/*66.76*/.messageId),format.raw/*66.86*/("""">
                    <input class="edit-tweet-input" type="text" name="editTweetText" value=""""),_display_(/*67.94*/message/*67.101*/.text),format.raw/*67.106*/("""" style="display:none;">
                    <div class="button-container">
                        <button class="edit-button" type="button" onclick="toggleEditField("""),_display_(/*69.93*/message/*69.100*/.messageId),format.raw/*69.110*/(""")">Edit</button>
                        <button class="save-button" type="submit" style="display:none;">Save</button>
                    </div>
                </form>
                <form class="delete-tweet-form" method="post" action=""""),_display_(/*73.72*/routes/*73.78*/.tweet.deleteTweet),format.raw/*73.96*/("""">
                    """),_display_(/*74.22*/helper/*74.28*/.CSRF.formField),format.raw/*74.43*/("""
                    """),format.raw/*75.21*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*75.69*/message/*75.76*/.text),format.raw/*75.81*/("""">
                    <button class="delete-button" type="submit">Delete</button>
                </form>
            </li>
            """)))}),format.raw/*79.14*/("""
        """),format.raw/*80.9*/("""</ul>
    </div>
</div>

<a class="home" href=""""),_display_(/*84.24*/routes/*84.30*/.tweet.home),format.raw/*84.41*/("""">Home</a>
<a class="logout" href=""""),_display_(/*85.26*/routes/*85.32*/.tweet.logout),format.raw/*85.45*/("""">Logout</a>


<script>
      function toggleEditField(messageId) """),format.raw/*89.43*/("""{"""),format.raw/*89.44*/("""
      """),format.raw/*90.7*/("""var messageTextElement = document.getElementById('message-' + messageId);
      var inputField = document.querySelector('input[name="editTweetText"][value="' + messageTextElement.textContent + '"]');
      var saveButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.save-button');
      var cancelButton = document.querySelector('input[name="editTweetId"][value="' + messageId + '"]').parentNode.querySelector('.edit-button');

      if (inputField.style.display === "none") """),format.raw/*95.48*/("""{"""),format.raw/*95.49*/("""
        """),format.raw/*96.9*/("""inputField.style.display = "inline-block";
        saveButton.style.display = "inline-block";
        cancelButton.textContent = "Cancel";
        messageTextElement.style.display = "none";
      """),format.raw/*100.7*/("""}"""),format.raw/*100.8*/(""" """),format.raw/*100.9*/("""else """),format.raw/*100.14*/("""{"""),format.raw/*100.15*/("""
        """),format.raw/*101.9*/("""inputField.style.display = "none";
        saveButton.style.display = "none";
        cancelButton.textContent = "Edit";
        messageTextElement.style.display = "inline";
      """),format.raw/*105.7*/("""}"""),format.raw/*105.8*/("""
    """),format.raw/*106.5*/("""}"""),format.raw/*106.6*/("""

"""),format.raw/*108.1*/("""</script>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>

</body>
</html>
"""))
      }
    }
  }

  def render(username:String,tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],likes:Seq[Int],time:Seq[java.sql.Timestamp],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(username,tweets,following,followers,likes,time)(request,flash)

  def f:((String,Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],Seq[Int],Seq[java.sql.Timestamp]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (username,tweets,following,followers,likes,time) => (request,flash) => apply(username,tweets,following,followers,likes,time)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: aa4deb728c8dc4ce5c899a44b12b23f3cf9c76de
                  MATRIX: 847->1|1148->209|1175->210|1468->476|1497->484|1697->658|1737->682|1776->683|1808->688|1876->729|1903->735|1954->756|1982->757|2101->850|2141->874|2180->875|2212->880|2280->921|2307->927|2358->948|2386->949|2525->1061|2604->1124|2644->1126|2685->1139|2856->1283|2872->1290|2903->1300|2933->1303|2950->1310|2977->1315|3082->1393|3107->1397|3160->1422|3289->1524|3321->1535|3391->1577|3420->1578|3475->1605|3715->1817|3744->1818|4090->2137|4105->2143|4142->2159|4193->2183|4208->2189|4244->2204|4293->2225|4368->2273|4384->2280|4415->2290|4538->2386|4555->2393|4582->2398|4777->2566|4794->2573|4826->2583|5094->2824|5109->2830|5148->2848|5199->2872|5214->2878|5250->2893|5299->2914|5374->2962|5390->2969|5416->2974|5585->3112|5621->3121|5696->3169|5711->3175|5743->3186|5806->3222|5821->3228|5855->3241|5949->3307|5978->3308|6012->3315|6578->3853|6607->3854|6643->3863|6867->4059|6896->4060|6925->4061|6959->4066|6989->4067|7026->4076|7234->4256|7263->4257|7296->4262|7325->4263|7355->4265
                  LINES: 21->1|26->2|27->3|37->13|37->13|46->22|46->22|46->22|47->23|48->24|48->24|50->26|51->27|55->31|55->31|55->31|56->32|57->33|57->33|59->35|60->36|65->41|65->41|65->41|66->42|68->44|68->44|68->44|68->44|68->44|68->44|69->45|69->45|70->46|72->48|72->48|73->49|73->49|74->50|79->55|79->55|88->64|88->64|88->64|89->65|89->65|89->65|90->66|90->66|90->66|90->66|91->67|91->67|91->67|93->69|93->69|93->69|97->73|97->73|97->73|98->74|98->74|98->74|99->75|99->75|99->75|99->75|103->79|104->80|108->84|108->84|108->84|109->85|109->85|109->85|113->89|113->89|114->90|119->95|119->95|120->96|124->100|124->100|124->100|124->100|124->100|125->101|129->105|129->105|130->106|130->106|132->108
                  -- GENERATED --
              */
          