
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

<form method="post" action=""""),_display_(/*33.30*/routes/*33.36*/.tweet.searchProfile),format.raw/*33.56*/("""">
    """),_display_(/*34.6*/helper/*34.12*/.CSRF.formField),format.raw/*34.27*/("""
    """),format.raw/*35.5*/("""<div>
        <label>
            <input type="text" name="search">
            <button type="submit">Search</button>
        </label>
    </div>
</form>


<div>
    <a href=""""),_display_(/*45.15*/routes/*45.21*/.tweet.logout),format.raw/*45.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*49.15*/routes/*49.21*/.tweet.showProfile),format.raw/*49.39*/("""" id="profile">Profile</a>
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
                  HASH: a5a8f6cd6efcf1ea1753913897a8785692589af2
                  MATRIX: 808->1|1035->135|1062->136|1317->364|1332->370|1368->385|1402->393|1417->399|1453->414|1485->419|1669->577|1709->601|1749->603|1781->608|1834->634|1850->641|1876->646|1926->669|1940->674|2020->733|2070->753|2098->754|2161->790|2176->796|2217->816|2251->824|2266->830|2302->845|2334->850|2537->1026|2552->1032|2586->1045|2666->1098|2681->1104|2720->1122
                  LINES: 21->1|26->2|27->3|38->14|38->14|38->14|39->15|39->15|39->15|40->16|49->25|49->25|49->25|50->26|51->27|51->27|51->27|52->28|52->28|52->28|54->30|55->31|57->33|57->33|57->33|58->34|58->34|58->34|59->35|69->45|69->45|69->45|73->49|73->49|73->49
                  -- GENERATED --
              */
          