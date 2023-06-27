
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
    """),format.raw/*16.5*/("""<input type="text" name="newTweet"></input>
    <input type="submit"></input>
</form>

<h3>Last 10 Messages:</h3>
<ul>
    """),_display_(/*22.6*/for(message <- messages) yield /*22.30*/ {_display_(Seq[Any](format.raw/*22.32*/("""
    """),format.raw/*23.5*/("""<li>
        <p>Message: """),_display_(/*24.22*/message/*24.29*/.text),format.raw/*24.34*/("""</p>
        <p>User: """),_display_(/*25.19*/users/*25.24*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*25.83*/("""</p>
    </li>
    """)))}),format.raw/*27.6*/("""
"""),format.raw/*28.1*/("""</ul>

<div>
    <a href=""""),_display_(/*31.15*/routes/*31.21*/.tweet.logout),format.raw/*31.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*35.15*/routes/*35.21*/.tweet.showProfile),format.raw/*35.39*/("""" id="profile">Profile</a>
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
                  HASH: d1432790925e90f346b2f456ebf5c28895526a8e
                  MATRIX: 808->1|1035->135|1062->136|1317->364|1332->370|1368->385|1402->393|1417->399|1453->414|1485->419|1635->543|1675->567|1715->569|1747->574|1800->600|1816->607|1842->612|1892->635|1906->640|1986->699|2036->719|2064->720|2118->747|2133->753|2167->766|2247->819|2262->825|2301->843
                  LINES: 21->1|26->2|27->3|38->14|38->14|38->14|39->15|39->15|39->15|40->16|46->22|46->22|46->22|47->23|48->24|48->24|48->24|49->25|49->25|49->25|51->27|52->28|55->31|55->31|55->31|59->35|59->35|59->35
                  -- GENERATED --
              */
          