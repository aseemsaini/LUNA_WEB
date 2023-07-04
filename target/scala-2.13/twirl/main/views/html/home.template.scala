
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

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template6[Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow],Seq[Int],Seq[java.sql.Timestamp],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: Seq[Models.Tables.MessagesRow], users: Seq[Models.Tables.UsersRow], likes:Seq[Int], time: Seq[java.sql.Timestamp])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Luna | Home</title>
    <link rel="stylesheet" href="/assets/stylesheets/home.css">
</head>
<body>
<header>
    <h1>Welcome To Luna</h1>
</header>

<div class="logo">
    <img src="/assets/images/luna_logo.png">
</div>

<div class="container">
    <div class="tweet-form">
        <form method="post" action=""""),_display_(/*21.38*/routes/*21.44*/.tweet.addTweet),format.raw/*21.59*/("""">
            """),_display_(/*22.14*/helper/*22.20*/.CSRF.formField),format.raw/*22.35*/("""
            """),format.raw/*23.13*/("""<div>
                <input type="text" name="newTweet" placeholder="What's on your mind?">
                <button type="submit">Post Tweet</button>
            </div>
        </form>
    </div>

    <section class="tweets">
        <h2 class = "topic">See what the world is Tweeting</h2>
        <ul>
            """),_display_(/*33.14*/for((message, index) <- messages.zipWithIndex) yield /*33.60*/ {_display_(Seq[Any](format.raw/*33.62*/("""
            """),format.raw/*34.13*/("""<li>
                <div class="tweet-container">
                    <p class="user-message">
                        <span class="user">"""),_display_(/*37.45*/users/*37.50*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*37.109*/("""</span>
                        <span class="message">"""),_display_(/*38.48*/message/*38.55*/.text),format.raw/*38.60*/("""</span>

                    <form class="like-form" method="get" action=""""),_display_(/*40.67*/routes/*40.73*/.tweet.likeTweet),format.raw/*40.89*/("""">
                        """),_display_(/*41.26*/helper/*41.32*/.CSRF.formField),format.raw/*41.47*/("""
                        """),format.raw/*42.25*/("""<input type="hidden" name="tweetId" value=""""),_display_(/*42.69*/message/*42.76*/.messageId),format.raw/*42.86*/("""">
                        <button class="like-button" type="like"></button>
                        <span class="likes">"""),_display_(/*44.46*/likes(index)),format.raw/*44.58*/("""</span>

                    <span class="time">
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
                </form>

                    <form class="retweet-form" method="post" action=""""),_display_(/*62.71*/routes/*62.77*/.tweet.reTweet),format.raw/*62.91*/("""">
                        """),_display_(/*63.26*/helper/*63.32*/.CSRF.formField),format.raw/*63.47*/("""
                        """),format.raw/*64.25*/("""<input type="hidden" name="reTweetId" value=""""),_display_(/*64.71*/message/*64.78*/.messageId),format.raw/*64.88*/("""">
                        <button class="retweet-button" type="submit">Retweet</button>
                    </form>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*70.14*/("""
        """),format.raw/*71.9*/("""</ul>
    </section>

    <section class="search-section">
        <form method="get" action=""""),_display_(/*75.37*/routes/*75.43*/.tweet.searchProfile),format.raw/*75.63*/("""">
            <div class="search-profile">
                <input type="text" name="search" placeholder="Search for User">
                <button type="submit">Search</button>
            </div>
        </form>

        <form method="get" action=""""),_display_(/*82.37*/routes/*82.43*/.tweet.searchMessage),format.raw/*82.63*/("""">
            <div class="search-message">
                <input type="text" name="messageSearch" placeholder="Search for Message">
                <button type="submit">Search</button>
            </div>
        </form>
    </section>

</div>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>

<a class="profile-visit" href=""""),_display_(/*96.33*/routes/*96.39*/.tweet.showProfile),format.raw/*96.57*/("""">Profile</a>
<a class="logout" href=""""),_display_(/*97.26*/routes/*97.32*/.tweet.logout),format.raw/*97.45*/("""">Logout</a>

</body>
</html>
"""))
      }
    }
  }

  def render(messages:Seq[Models.Tables.MessagesRow],users:Seq[Models.Tables.UsersRow],likes:Seq[Int],time:Seq[java.sql.Timestamp],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(messages,users,likes,time)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow],Seq[Int],Seq[java.sql.Timestamp]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (messages,users,likes,time) => (request,flash) => apply(messages,users,likes,time)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/home.scala.html
                  HASH: b83a21aa6ae14282ab027ef7f34d5e58936a3cf6
                  MATRIX: 841->1|1115->182|1142->183|1557->571|1572->577|1608->592|1651->608|1666->614|1702->629|1743->642|2087->959|2149->1005|2189->1007|2230->1020|2397->1160|2411->1165|2492->1224|2574->1279|2590->1286|2616->1291|2718->1366|2733->1372|2770->1388|2825->1416|2840->1422|2876->1437|2929->1462|3000->1506|3016->1513|3047->1523|3196->1645|3229->1657|3387->1788|3419->1799|3489->1841|3518->1842|3573->1869|3813->2081|3842->2082|4169->2382|4184->2388|4219->2402|4274->2430|4289->2436|4325->2451|4378->2476|4451->2522|4467->2529|4498->2539|4725->2735|4761->2744|4883->2839|4898->2845|4939->2865|5216->3115|5231->3121|5272->3141|5663->3505|5678->3511|5717->3529|5783->3568|5798->3574|5832->3587
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|64->40|64->40|64->40|65->41|65->41|65->41|66->42|66->42|66->42|66->42|68->44|68->44|72->48|72->48|73->49|73->49|74->50|79->55|79->55|86->62|86->62|86->62|87->63|87->63|87->63|88->64|88->64|88->64|88->64|94->70|95->71|99->75|99->75|99->75|106->82|106->82|106->82|120->96|120->96|120->96|121->97|121->97|121->97
                  -- GENERATED --
              */
          