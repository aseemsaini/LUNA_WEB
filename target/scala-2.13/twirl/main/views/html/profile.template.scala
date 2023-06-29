
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

object profile extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template5[Seq[Models.Tables.MessagesRow],Seq[String],Seq[String],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(tweets: Seq[Models.Tables.MessagesRow], following: Seq[String], followers:Seq[String])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*2.1*/("""
"""),format.raw/*3.1*/("""<html>
<body>
<h1>Hello, Welcome to your profile</h1>
<h3>Following</h3>
    """),_display_(/*7.6*/for(people <- following) yield /*7.30*/{_display_(Seq[Any](format.raw/*7.31*/("""
        """),format.raw/*8.9*/("""<p>"""),_display_(/*8.13*/people),format.raw/*8.19*/("""</p>
    """)))}),format.raw/*9.6*/("""

"""),format.raw/*11.1*/("""<h3>Followers</h3>
    """),_display_(/*12.6*/for(people <- followers) yield /*12.30*/{_display_(Seq[Any](format.raw/*12.31*/("""
    """),format.raw/*13.5*/("""<p>"""),_display_(/*13.9*/people),format.raw/*13.15*/("""</p>
    """)))}),format.raw/*14.6*/("""

"""),format.raw/*16.1*/("""<ul>
    """),_display_(/*17.6*/for(message <- tweets) yield /*17.28*/ {_display_(Seq[Any](format.raw/*17.30*/("""
    """),format.raw/*18.5*/("""<li>
        <p>Message: """),_display_(/*19.22*/message/*19.29*/.text),format.raw/*19.34*/("""</p>
        <form method="post" action=""""),_display_(/*20.38*/routes/*20.44*/.tweet.deleteTweet),format.raw/*20.62*/("""">
            """),_display_(/*21.14*/helper/*21.20*/.CSRF.formField),format.raw/*21.35*/("""
            """),format.raw/*22.13*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*22.61*/message/*22.68*/.text),format.raw/*22.73*/("""">
            <button type="submit">Delete</button>
        </form>
    </li>
    """)))}),format.raw/*26.6*/("""
"""),format.raw/*27.1*/("""</ul>
<div>
    <a href=""""),_display_(/*29.15*/routes/*29.21*/.tweet.logout),format.raw/*29.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*33.15*/routes/*33.21*/.tweet.home),format.raw/*33.32*/("""" id="home">Home</a>
</div>
</body>
</html>
"""))
      }
    }
  }

  def render(tweets:Seq[Models.Tables.MessagesRow],following:Seq[String],followers:Seq[String],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(tweets,following,followers)(request,flash)

  def f:((Seq[Models.Tables.MessagesRow],Seq[String],Seq[String]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (tweets,following,followers) => (request,flash) => apply(tweets,following,followers)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/profile.scala.html
                  HASH: c08ef58c6c76120a647ab06348bbaa635c398b3d
                  MATRIX: 807->1|1043->144|1070->145|1173->223|1212->247|1250->248|1285->257|1315->261|1341->267|1380->277|1409->279|1459->303|1499->327|1538->328|1570->333|1600->337|1627->343|1667->353|1696->355|1732->365|1770->387|1810->389|1842->394|1895->420|1911->427|1937->432|2006->474|2021->480|2060->498|2103->514|2118->520|2154->535|2195->548|2270->596|2286->603|2312->608|2426->692|2454->693|2507->719|2522->725|2556->738|2636->791|2651->797|2683->808
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|32->8|32->8|33->9|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|40->16|41->17|41->17|41->17|42->18|43->19|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|46->22|50->26|51->27|53->29|53->29|53->29|57->33|57->33|57->33
                  -- GENERATED --
              */
          