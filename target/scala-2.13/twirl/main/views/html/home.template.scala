
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

<form method="post" action=""""),_display_(/*13.30*/routes/*13.36*/.tweet.addTweet),format.raw/*13.51*/("""">
    """),_display_(/*14.6*/helper/*14.12*/.CSRF.formField),format.raw/*14.27*/("""
    """),format.raw/*15.5*/("""<input type="text" name="newTweet"></input>
    <input type="submit"></input>
</form>

<h3>Last 10 Messages:</h3>
<ul>
    """),_display_(/*21.6*/for(message <- messages) yield /*21.30*/ {_display_(Seq[Any](format.raw/*21.32*/("""
    """),format.raw/*22.5*/("""<li>
        <p>Message: """),_display_(/*23.22*/message/*23.29*/.text),format.raw/*23.34*/("""</p>
        <p>User: """),_display_(/*24.19*/users/*24.24*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*24.83*/("""</p>
    </li>
    """)))}),format.raw/*26.6*/("""
"""),format.raw/*27.1*/("""</ul>

<div>
    <a href=""""),_display_(/*30.15*/routes/*30.21*/.tweet.logout),format.raw/*30.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*34.15*/routes/*34.21*/.tweet.showProfile),format.raw/*34.39*/("""" id="profile">Profile</a>
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
                  HASH: 8151c75e3b5b238101767b64ba7a6863901b4520
                  MATRIX: 808->1|1035->135|1062->136|1316->363|1331->369|1367->384|1401->392|1416->398|1452->413|1484->418|1634->542|1674->566|1714->568|1746->573|1799->599|1815->606|1841->611|1891->634|1905->639|1985->698|2035->718|2063->719|2117->746|2132->752|2166->765|2246->818|2261->824|2300->842
                  LINES: 21->1|26->2|27->3|37->13|37->13|37->13|38->14|38->14|38->14|39->15|45->21|45->21|45->21|46->22|47->23|47->23|47->23|48->24|48->24|48->24|50->26|51->27|54->30|54->30|54->30|58->34|58->34|58->34
                  -- GENERATED --
              */
          