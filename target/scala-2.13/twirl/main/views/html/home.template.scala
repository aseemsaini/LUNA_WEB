
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
                            var timestamp = new Date(""""),_display_(/*48.56*/time(index)),format.raw/*48.67*/("""");
                            var options = """),format.raw/*49.43*/("""{"""),format.raw/*49.44*/("""
                              """),format.raw/*50.31*/("""day: "2-digit",
                              month: "long",
                              year: "2-digit",
                              hour: "2-digit",
                              minute: "2-digit",
                            """),format.raw/*55.29*/("""}"""),format.raw/*55.30*/(""";
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
                  HASH: 02ed402bd7cdec2cf934c83ad143aa301edc6c1c
                  MATRIX: 841->1|1115->182|1142->183|1557->571|1572->577|1608->592|1651->608|1666->614|1702->629|1743->642|2085->957|2147->1003|2187->1005|2228->1018|2395->1158|2409->1163|2490->1222|2572->1277|2588->1284|2614->1289|2716->1364|2731->1370|2768->1386|2823->1414|2838->1420|2874->1435|2927->1460|2998->1504|3014->1511|3045->1521|3194->1643|3227->1655|3397->1798|3429->1809|3503->1855|3532->1856|3591->1887|3851->2119|3880->2120|4227->2440|4242->2446|4277->2460|4332->2488|4347->2494|4383->2509|4436->2534|4509->2580|4525->2587|4556->2597|4783->2793|4819->2802|4941->2897|4956->2903|4997->2923|5274->3173|5289->3179|5330->3199|5721->3563|5736->3569|5775->3587|5841->3626|5856->3632|5890->3645
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|64->40|64->40|64->40|65->41|65->41|65->41|66->42|66->42|66->42|66->42|68->44|68->44|72->48|72->48|73->49|73->49|74->50|79->55|79->55|86->62|86->62|86->62|87->63|87->63|87->63|88->64|88->64|88->64|88->64|94->70|95->71|99->75|99->75|99->75|106->82|106->82|106->82|120->96|120->96|120->96|121->97|121->97|121->97
                  -- GENERATED --
              */
          