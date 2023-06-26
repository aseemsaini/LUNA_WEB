
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

<h3>Last 10 Messages:</h3>
<ul>
    """),_display_(/*15.6*/for(message <- messages) yield /*15.30*/ {_display_(Seq[Any](format.raw/*15.32*/("""
    """),format.raw/*16.5*/("""<li>
        <p>Message: """),_display_(/*17.22*/message/*17.29*/.text),format.raw/*17.34*/("""</p>
        <p>User: """),_display_(/*18.19*/users/*18.24*/.find(_.id == message.userId).map(_.username).getOrElse("")),format.raw/*18.83*/("""</p>
    </li>
    """)))}),format.raw/*20.6*/("""
"""),format.raw/*21.1*/("""</ul>

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
                  HASH: de034927dfc370a5133099395a1a63ea49cd7d18
                  MATRIX: 808->1|1035->135|1062->136|1323->371|1363->395|1403->397|1435->402|1488->428|1504->435|1530->440|1580->463|1594->468|1674->527|1724->547|1752->548
                  LINES: 21->1|26->2|27->3|39->15|39->15|39->15|40->16|41->17|41->17|41->17|42->18|42->18|42->18|44->20|45->21
                  -- GENERATED --
              */
          