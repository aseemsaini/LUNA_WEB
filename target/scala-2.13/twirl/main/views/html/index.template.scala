
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

object index extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*7.4*/("""

"""),_display_(/*9.2*/main("Welcome to LUNA")/*9.25*/ {_display_(Seq[Any](format.raw/*9.27*/("""

    """),_display_(/*11.6*/welcome(message, style = "scala")),format.raw/*11.39*/("""

""")))}),format.raw/*13.2*/("""

"""),format.raw/*15.1*/("""<p>
    <button type="button" onclick="window.location.href='"""),_display_(/*16.59*/routes/*16.65*/.tweet.login),format.raw/*16.77*/("""'">Login</button>
</p>
"""))
      }
    }
  }

  def render(message:String,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(message)(assetsFinder)

  def f:((String) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (message) => (assetsFinder) => apply(message)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/index.scala.html
                  HASH: 789d7690f9f74436012f50e37739df47bce69306
                  MATRIX: 742->1|890->56|917->251|945->254|976->277|1015->279|1048->286|1102->319|1135->322|1164->324|1253->386|1268->392|1301->404
                  LINES: 21->1|26->2|27->7|29->9|29->9|29->9|31->11|31->11|33->13|35->15|36->16|36->16|36->16
                  -- GENERATED --
              */
          