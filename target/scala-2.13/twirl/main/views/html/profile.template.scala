
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
"""),_display_(/*7.2*/for(people <- following) yield /*7.26*/{_display_(Seq[Any](format.raw/*7.27*/("""
"""),format.raw/*8.1*/("""<p>"""),_display_(/*8.5*/people),format.raw/*8.11*/("""</p>
""")))}),format.raw/*9.2*/("""

"""),format.raw/*11.1*/("""<h3>Followers</h3>
"""),_display_(/*12.2*/for(people <- followers) yield /*12.26*/{_display_(Seq[Any](format.raw/*12.27*/("""
"""),format.raw/*13.1*/("""<p>"""),_display_(/*13.5*/people),format.raw/*13.11*/("""</p>
""")))}),format.raw/*14.2*/("""

"""),format.raw/*16.1*/("""<ul>
    """),_display_(/*17.6*/for(message <- tweets) yield /*17.28*/ {_display_(Seq[Any](format.raw/*17.30*/("""
    """),format.raw/*18.5*/("""<li>
        <p>Message: """),_display_(/*19.22*/message/*19.29*/.text),format.raw/*19.34*/("""</p>
        <form method="post" action=""""),_display_(/*20.38*/routes/*20.44*/.tweet.editTweet),format.raw/*20.60*/("""">
            """),_display_(/*21.14*/helper/*21.20*/.CSRF.formField),format.raw/*21.35*/("""
            """),format.raw/*22.13*/("""<input type="hidden" name="editTweetId" value=""""),_display_(/*22.61*/message/*22.68*/.messageId),format.raw/*22.78*/("""">
            <input type="text" name="editTweetText" value="" style="display:none;">
            <button type="button" onclick="toggleEditField(this)">Edit</button>
            <button type="submit" style="display:none;">Save</button>
        </form>
        <form method="post" action=""""),_display_(/*27.38*/routes/*27.44*/.tweet.deleteTweet),format.raw/*27.62*/("""">
            """),_display_(/*28.14*/helper/*28.20*/.CSRF.formField),format.raw/*28.35*/("""
            """),format.raw/*29.13*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*29.61*/message/*29.68*/.text),format.raw/*29.73*/("""">
            <button type="submit">Delete</button>
        </form>
        <script>
          function toggleEditField(button) """),format.raw/*33.44*/("""{"""),format.raw/*33.45*/("""
            """),format.raw/*34.13*/("""var inputField = button.parentNode.querySelector('input[name="editTweetText"]');
            var saveButton = button.parentNode.querySelector('button[type="submit"]');
            if (inputField.style.display === "none") """),format.raw/*36.54*/("""{"""),format.raw/*36.55*/("""
              """),format.raw/*37.15*/("""inputField.value = """"),_display_(/*37.36*/message/*37.43*/.text),format.raw/*37.48*/("""";
              inputField.style.display = "inline-block";
              saveButton.style.display = "inline-block";
              button.textContent = "Cancel";
            """),format.raw/*41.13*/("""}"""),format.raw/*41.14*/(""" """),format.raw/*41.15*/("""else """),format.raw/*41.20*/("""{"""),format.raw/*41.21*/("""
              """),format.raw/*42.15*/("""inputField.style.display = "none";
              saveButton.style.display = "none";
              button.textContent = "Edit";
            """),format.raw/*45.13*/("""}"""),format.raw/*45.14*/("""
          """),format.raw/*46.11*/("""}"""),format.raw/*46.12*/("""
        """),format.raw/*47.9*/("""</script>

    </li>
    """)))}),format.raw/*50.6*/("""
"""),format.raw/*51.1*/("""</ul>


<div>
    <a href=""""),_display_(/*55.15*/routes/*55.21*/.tweet.logout),format.raw/*55.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*59.15*/routes/*59.21*/.tweet.home),format.raw/*59.32*/("""" id="home">Home</a>
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
                  HASH: 5dcf7962198b7be361cdab933d1de72e7be71d25
                  MATRIX: 807->1|1043->144|1070->145|1169->219|1208->243|1246->244|1273->245|1302->249|1328->255|1363->261|1392->263|1438->283|1478->307|1517->308|1545->309|1575->313|1602->319|1638->325|1667->327|1703->337|1741->359|1781->361|1813->366|1866->392|1882->399|1908->404|1977->446|1992->452|2029->468|2072->484|2087->490|2123->505|2164->518|2239->566|2255->573|2286->583|2603->873|2618->879|2657->897|2700->913|2715->919|2751->934|2792->947|2867->995|2883->1002|2909->1007|3066->1136|3095->1137|3136->1150|3385->1371|3414->1372|3457->1387|3505->1408|3521->1415|3547->1420|3749->1594|3778->1595|3807->1596|3840->1601|3869->1602|3912->1617|4079->1756|4108->1757|4147->1768|4176->1769|4212->1778|4268->1804|4296->1805|4351->1833|4366->1839|4400->1852|4480->1905|4495->1911|4527->1922
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|32->8|32->8|33->9|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|40->16|41->17|41->17|41->17|42->18|43->19|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|46->22|51->27|51->27|51->27|52->28|52->28|52->28|53->29|53->29|53->29|53->29|57->33|57->33|58->34|60->36|60->36|61->37|61->37|61->37|61->37|65->41|65->41|65->41|65->41|65->41|66->42|69->45|69->45|70->46|70->46|71->47|74->50|75->51|79->55|79->55|79->55|83->59|83->59|83->59
                  -- GENERATED --
              */
          