
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
        <h2 class="topic">See what the world is Tweeting</h2>
        <ul>
            """),_display_(/*33.14*/for(message <- messages) yield /*33.38*/ {_display_(Seq[Any](format.raw/*33.40*/("""
            """),format.raw/*34.13*/("""<li>
                <div class="tweet-container">
                    <p class="user-message">
                        <span class="user">"""),_display_(/*37.45*/users/*37.50*/.find(user => user.id == message.userId).map(_.username).getOrElse("")),format.raw/*37.120*/("""</span>
                        <span class="message">"""),_display_(/*38.48*/message/*38.55*/.text),format.raw/*38.60*/("""</span>
                    <form class="like-form" method="get" action=""""),_display_(/*39.67*/routes/*39.73*/.tweet.likeTweet),format.raw/*39.89*/("""">
                        """),_display_(/*40.26*/helper/*40.32*/.CSRF.formField),format.raw/*40.47*/("""
                        """),format.raw/*41.25*/("""<input type="hidden" name="tweetId" value=""""),_display_(/*41.69*/message/*41.76*/.messageId),format.raw/*41.86*/("""">
                        <button class="like-button" type="like"></button>
                        <span class="likes">"""),_display_(/*43.46*/likes(messages.indexOf(message))),format.raw/*43.78*/("""</span>

                        <span class="time">
                          <script>
                            var timestamp = new Date(""""),_display_(/*47.56*/time(messages.indexOf(message))),format.raw/*47.87*/("""");
                            var options = """),format.raw/*48.43*/("""{"""),format.raw/*48.44*/("""
                              """),format.raw/*49.31*/("""day: "2-digit",
                              month: "long",
                              year: "2-digit",
                              hour: "2-digit",
                              minute: "2-digit",
                            """),format.raw/*54.29*/("""}"""),format.raw/*54.30*/(""";
                            var formattedTime = timestamp.toLocaleString("en-UK", options);
                            document.write(formattedTime);
                          </script>
                        </span>
                    </form>

                    <form class="retweet-form" method="post" action=""""),_display_(/*61.71*/routes/*61.77*/.tweet.reTweet),format.raw/*61.91*/("""">
                        """),_display_(/*62.26*/helper/*62.32*/.CSRF.formField),format.raw/*62.47*/("""
                        """),format.raw/*63.25*/("""<input type="hidden" name="reTweetId" value=""""),_display_(/*63.71*/message/*63.78*/.messageId),format.raw/*63.88*/("""">
                        <button class="retweet-button" type="submit">Retweet</button>
                    </form>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*69.14*/("""
        """),format.raw/*70.9*/("""</ul>
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
                  HASH: 09bdb48fc26105d56509045d07f5607e642005c1
                  MATRIX: 841->1|1115->182|1142->183|1557->571|1572->577|1608->592|1651->608|1666->614|1702->629|1743->642|2085->957|2125->981|2165->983|2206->996|2373->1136|2387->1141|2479->1211|2561->1266|2577->1273|2603->1278|2704->1352|2719->1358|2756->1374|2811->1402|2826->1408|2862->1423|2915->1448|2986->1492|3002->1499|3033->1509|3182->1631|3235->1663|3405->1806|3457->1837|3531->1883|3560->1884|3619->1915|3879->2147|3908->2148|4255->2468|4270->2474|4305->2488|4360->2516|4375->2522|4411->2537|4464->2562|4537->2608|4553->2615|4584->2625|4811->2821|4847->2830|4970->2926|4985->2932|5026->2952|5303->3202|5318->3208|5359->3228|5750->3592|5765->3598|5804->3616|5870->3655|5885->3661|5919->3674
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|63->39|63->39|63->39|64->40|64->40|64->40|65->41|65->41|65->41|65->41|67->43|67->43|71->47|71->47|72->48|72->48|73->49|78->54|78->54|85->61|85->61|85->61|86->62|86->62|86->62|87->63|87->63|87->63|87->63|93->69|94->70|99->75|99->75|99->75|106->82|106->82|106->82|120->96|120->96|120->96|121->97|121->97|121->97
                  -- GENERATED --
              */
          