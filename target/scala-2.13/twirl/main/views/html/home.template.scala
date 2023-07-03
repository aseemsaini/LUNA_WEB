
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
                        var timestamp = new Date(""""),_display_(/*47.52*/time(index)),format.raw/*47.63*/("""");
                        var options = """),format.raw/*48.39*/("""{"""),format.raw/*48.40*/("""
                          """),format.raw/*49.27*/("""day: "2-digit",
                          month: "long",
                          year: "2-digit",
                          hour: "2-digit",
                          minute: "2-digit",
                        """),format.raw/*54.25*/("""}"""),format.raw/*54.26*/(""";
                        var formattedTime = timestamp.toLocaleString("en-US", options);
                        document.write(formattedTime);
                      </script>
                    </span>

                </form>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*64.14*/("""
        """),format.raw/*65.9*/("""</ul>
    </section>

    <section class="search-section">
        <form method="get" action=""""),_display_(/*69.37*/routes/*69.43*/.tweet.searchProfile),format.raw/*69.63*/("""">
            <div class="search-profile">
                <input type="text" name="search" placeholder="Search for User">
                <button type="submit">Search</button>
            </div>
        </form>

        <form method="get" action=""""),_display_(/*76.37*/routes/*76.43*/.tweet.searchMessage),format.raw/*76.63*/("""">
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

<a class="profile-visit" href=""""),_display_(/*90.33*/routes/*90.39*/.tweet.showProfile),format.raw/*90.57*/("""">Profile</a>
<a class="logout" href=""""),_display_(/*91.26*/routes/*91.32*/.tweet.logout),format.raw/*91.45*/("""">Logout</a>

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
                  HASH: c5399986ef869f5af473ad17bb2a6ad80766ad23
                  MATRIX: 841->1|1115->182|1142->183|1557->571|1572->577|1608->592|1651->608|1666->614|1702->629|1743->642|2087->959|2149->1005|2189->1007|2230->1020|2397->1160|2411->1165|2492->1224|2574->1279|2590->1286|2616->1291|2718->1366|2733->1372|2770->1388|2825->1416|2840->1422|2876->1437|2929->1462|3000->1506|3016->1513|3047->1523|3196->1645|3229->1657|3386->1787|3418->1798|3488->1840|3517->1841|3572->1868|3812->2080|3841->2081|4181->2390|4217->2399|4339->2494|4354->2500|4395->2520|4672->2770|4687->2776|4728->2796|5119->3160|5134->3166|5173->3184|5239->3223|5254->3229|5288->3242
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|64->40|64->40|64->40|65->41|65->41|65->41|66->42|66->42|66->42|66->42|68->44|68->44|71->47|71->47|72->48|72->48|73->49|78->54|78->54|88->64|89->65|93->69|93->69|93->69|100->76|100->76|100->76|114->90|114->90|114->90|115->91|115->91|115->91
                  -- GENERATED --
              */
          