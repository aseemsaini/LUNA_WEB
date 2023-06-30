
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

object home extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template4[Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(messages: Seq[Models.Tables.MessagesRow], users: Seq[Models.Tables.UsersRow])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
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
        <h2>See what the world is Tweeting</h2>
        <ul>
            """),_display_(/*33.14*/for(message <- messages) yield /*33.38*/ {_display_(Seq[Any](format.raw/*33.40*/("""
            """),format.raw/*34.13*/("""<li>
                <div class="tweet-container">
                    <p class="user-message">
                        <span class="user">"""),_display_(/*37.45*/users/*37.50*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*37.109*/("""</span>
                        <span class="message">"""),_display_(/*38.48*/message/*38.55*/.text),format.raw/*38.60*/("""</span>
                    </p>
                </div>
            </li>
            """)))}),format.raw/*42.14*/("""
        """),format.raw/*43.9*/("""</ul>
    </section>

    <section class="search-section">
        <form method="get" action=""""),_display_(/*47.37*/routes/*47.43*/.tweet.searchProfile),format.raw/*47.63*/("""">
            <div class="search-profile">
                <input type="text" name="search" placeholder="Search for User">
                <button type="submit">Search</button>
            </div>
        </form>

        <form method="get" action=""""),_display_(/*54.37*/routes/*54.43*/.tweet.searchMessage),format.raw/*54.63*/("""">
            <div class="search-message">
                <input type="text" name="messageSearch" placeholder="Search for Message">
                <button type="submit">Search</button>
            </div>
        </form>
    </section>

    <section class="company-section">
        <!-- Display company images/messages or other content here -->
    </section>
</div>

<footer class="footer">
    <p>&copy; 2023 Luna. All rights reserved.</p>
</footer>

<a class="profile-visit" href=""""),_display_(/*71.33*/routes/*71.39*/.tweet.showProfile),format.raw/*71.57*/("""">Profile</a>
<a class="logout" href=""""),_display_(/*72.26*/routes/*72.32*/.tweet.logout),format.raw/*72.45*/("""">Logout</a>

</body>
</html>
"""))
      }
    }
  }

  def render(messages:Seq[Models.Tables.MessagesRow],users:Seq[Models.Tables.UsersRow],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(messages,users)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[Models.Tables.UsersRow]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (messages,users) => (request,flash) => apply(messages,users)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/home.scala.html
                  HASH: ea5248cf9314bc016e5fba14316104a00145d00a
                  MATRIX: 808->1|1035->135|1062->136|1477->524|1492->530|1528->545|1571->561|1586->567|1622->582|1663->595|1991->896|2031->920|2071->922|2112->935|2279->1075|2293->1080|2374->1139|2456->1194|2472->1201|2498->1206|2616->1293|2652->1302|2774->1397|2789->1403|2830->1423|3107->1673|3122->1679|3163->1699|3678->2187|3693->2193|3732->2211|3798->2250|3813->2256|3847->2269
                  LINES: 21->1|26->2|27->3|45->21|45->21|45->21|46->22|46->22|46->22|47->23|57->33|57->33|57->33|58->34|61->37|61->37|61->37|62->38|62->38|62->38|66->42|67->43|71->47|71->47|71->47|78->54|78->54|78->54|95->71|95->71|95->71|96->72|96->72|96->72
                  -- GENERATED --
              */
          