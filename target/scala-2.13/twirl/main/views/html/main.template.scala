
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

object main extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[String,Html,AssetsFinder,play.twirl.api.HtmlFormat.Appendable] {

  /*
 * This template is called from the `index` template. This template
 * handles the rendering of the page header and body tags. It takes
 * three arguments, a `String` for the title of the page and an `Html`
 * object to insert into the body of the page and an `AssetFinder`
 * to define to reverse route static assets.
 */
  def apply/*8.2*/(title: String)(content: Html)(implicit assetsFinder: AssetsFinder):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*9.1*/("""
"""),format.raw/*10.1*/("""<!DOCTYPE html>
<html lang="en">
    <head>
        <title>"""),_display_(/*13.17*/title),format.raw/*13.22*/("""</title>

        <link rel="shortcut icon" type="image/png" href=""""),_display_(/*15.59*/assetsFinder/*15.71*/.path("images/favicon.png")),format.raw/*15.98*/("""">
        <script src=""""),_display_(/*16.23*/assetsFinder/*16.35*/.path("javascripts/hello.js")),format.raw/*16.64*/("""" type="text/javascript"></script>
    </head>
    <body>
        """),format.raw/*20.32*/("""
        """),_display_(/*21.10*/content),format.raw/*21.17*/("""
    """),format.raw/*22.5*/("""</body>
</html>
"""))
      }
    }
  }

  def render(title:String,content:Html,assetsFinder:AssetsFinder): play.twirl.api.HtmlFormat.Appendable = apply(title)(content)(assetsFinder)

  def f:((String) => (Html) => (AssetsFinder) => play.twirl.api.HtmlFormat.Appendable) = (title) => (content) => (assetsFinder) => apply(title)(content)(assetsFinder)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/main.scala.html
                  HASH: c07b97b603e4d0ea09365c588b4ea3821c31c3ea
                  MATRIX: 1067->327|1228->395|1256->396|1343->456|1369->461|1464->529|1485->541|1533->568|1585->593|1606->605|1656->634|1750->790|1787->800|1815->807|1847->812
                  LINES: 27->8|32->9|33->10|36->13|36->13|38->15|38->15|38->15|39->16|39->16|39->16|42->20|43->21|43->21|44->22
                  -- GENERATED --
              */
          