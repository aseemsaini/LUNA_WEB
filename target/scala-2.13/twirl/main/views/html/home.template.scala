
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

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow],Seq[Int],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: Seq[Models.Tables.MessagesRow], users: Seq[Models.Tables.UsersRow], likes:Seq[Int])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
                        <span class="likes">"""),_display_(/*39.46*/likes(index)),format.raw/*39.58*/("""</span>
                    <form class="like-form" method="get" action=""""),_display_(/*40.67*/routes/*40.73*/.tweet.likeTweet),format.raw/*40.89*/("""">
                        """),_display_(/*41.26*/helper/*41.32*/.CSRF.formField),format.raw/*41.47*/("""
                        """),format.raw/*42.25*/("""<input type="hidden" name="tweetId" value=""""),_display_(/*42.69*/message/*42.76*/.messageId),format.raw/*42.86*/("""">
                        <button class="like-button" type="like">Like</button>
                    </form>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*48.14*/("""
        """),format.raw/*49.9*/("""</ul>
    </section>

    <section class="search-section">
        <form method="get" action=""""),_display_(/*53.37*/routes/*53.43*/.tweet.searchProfile),format.raw/*53.63*/("""">
            <div class="search-profile">
                <input type="text" name="search" placeholder="Search for User">
                <button type="submit">Search</button>
            </div>
        </form>

        <form method="get" action=""""),_display_(/*60.37*/routes/*60.43*/.tweet.searchMessage),format.raw/*60.63*/("""">
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

<a class="profile-visit" href=""""),_display_(/*74.33*/routes/*74.39*/.tweet.showProfile),format.raw/*74.57*/("""">Profile</a>
<a class="logout" href=""""),_display_(/*75.26*/routes/*75.32*/.tweet.logout),format.raw/*75.45*/("""">Logout</a>

</body>
</html>
"""))
      }
    }
  }

  def render(messages:Seq[Models.Tables.MessagesRow],users:Seq[Models.Tables.UsersRow],likes:Seq[Int],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(messages,users,likes)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow],Seq[Int]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (messages,users,likes) => (request,flash) => apply(messages,users,likes)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/home.scala.html
                  HASH: 05213e93166b8edfd96e014a7a4340ab37558716
                  MATRIX: 817->1|1060->151|1087->152|1502->540|1517->546|1553->561|1596->577|1611->583|1647->598|1688->611|2032->928|2094->974|2134->976|2175->989|2342->1129|2356->1134|2437->1193|2519->1248|2535->1255|2561->1260|2641->1313|2674->1325|2775->1399|2790->1405|2827->1421|2882->1449|2897->1455|2933->1470|2986->1495|3057->1539|3073->1546|3104->1556|3323->1744|3359->1753|3481->1848|3496->1854|3537->1874|3814->2124|3829->2130|3870->2150|4261->2514|4276->2520|4315->2538|4381->2577|4396->2583|4430->2596
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|63->39|63->39|64->40|64->40|64->40|65->41|65->41|65->41|66->42|66->42|66->42|66->42|72->48|73->49|77->53|77->53|77->53|84->60|84->60|84->60|98->74|98->74|98->74|99->75|99->75|99->75
                  -- GENERATED --
              */
          