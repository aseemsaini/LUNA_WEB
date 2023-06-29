
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
    <title>Login</title>
    <link rel="stylesheet" href="/assets/stylesheets/index.css">
</head>
<body>
<h2>Welcome To Luna</h2>


<form method="post" action=""""),_display_(/*14.30*/routes/*14.36*/.tweet.addTweet),format.raw/*14.51*/("""">
    """),_display_(/*15.6*/helper/*15.12*/.CSRF.formField),format.raw/*15.27*/("""
    """),format.raw/*16.5*/("""<div>
        <input type="text" name="newTweet">
        <button type="submit">Post Tweet</button>
    </div>
</form>


<h3>Last 10 Messages:</h3>
<ul>
    """),_display_(/*25.6*/for(message <- messages) yield /*25.30*/ {_display_(Seq[Any](format.raw/*25.32*/("""
    """),format.raw/*26.5*/("""<li>
        <p>Message: """),_display_(/*27.22*/message/*27.29*/.text),format.raw/*27.34*/("""</p>
        <p>User: """),_display_(/*28.19*/users/*28.24*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*28.83*/("""</p>
    </li>
    """)))}),format.raw/*30.6*/("""
"""),format.raw/*31.1*/("""</ul>

<form method="get" action=""""),_display_(/*33.29*/routes/*33.35*/.tweet.searchProfile),format.raw/*33.55*/("""">
    <div id ="uSearch">
        <label>
            <input type="text" name="search">
            <button type="submit">Search for User</button>
        </label>
    </div>
</form>

<form method="get" action=""""),_display_(/*42.29*/routes/*42.35*/.tweet.searchMessage),format.raw/*42.55*/("""">
    <div id ="mSearch">
        <label>
            <input type="text" name="messageSearch">
            <button type="submit">Search for Message</button>
        </label>
    </div>
</form>



<div>
    <a href=""""),_display_(/*54.15*/routes/*54.21*/.tweet.logout),format.raw/*54.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*58.15*/routes/*58.21*/.tweet.showProfile),format.raw/*58.39*/("""" id="profile">Profile</a>
</div>


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
                  HASH: 1e0fe6963d5b1f53b0a7a95165a51379f14fafb7
                  MATRIX: 808->1|1035->135|1062->136|1317->364|1332->370|1368->385|1402->393|1417->399|1453->414|1485->419|1669->577|1709->601|1749->603|1781->608|1834->634|1850->641|1876->646|1926->669|1940->674|2020->733|2070->753|2098->754|2160->789|2175->795|2216->815|2456->1028|2471->1034|2512->1054|2756->1271|2771->1277|2805->1290|2885->1343|2900->1349|2939->1367
                  LINES: 21->1|26->2|27->3|38->14|38->14|38->14|39->15|39->15|39->15|40->16|49->25|49->25|49->25|50->26|51->27|51->27|51->27|52->28|52->28|52->28|54->30|55->31|57->33|57->33|57->33|66->42|66->42|66->42|78->54|78->54|78->54|82->58|82->58|82->58
                  -- GENERATED --
              */
          