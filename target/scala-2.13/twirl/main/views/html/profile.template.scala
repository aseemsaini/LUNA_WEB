
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
        <p>Message: <span id="message-"""),_display_(/*19.40*/message/*19.47*/.messageId),format.raw/*19.57*/("""">"""),_display_(/*19.60*/message/*19.67*/.text),format.raw/*19.72*/("""</span></p>
        <form method="post" action=""""),_display_(/*20.38*/routes/*20.44*/.tweet.editTweet),format.raw/*20.60*/("""">
            """),_display_(/*21.14*/helper/*21.20*/.CSRF.formField),format.raw/*21.35*/("""
            """),format.raw/*22.13*/("""<input type="hidden" name="editTweetId" value=""""),_display_(/*22.61*/message/*22.68*/.messageId),format.raw/*22.78*/("""">
            <input type="text" name="editTweetText" value=""""),_display_(/*23.61*/message/*23.68*/.text),format.raw/*23.73*/("""" style="display:none;">
            <button type="button" onclick="toggleEditField("""),_display_(/*24.61*/message/*24.68*/.messageId),format.raw/*24.78*/(""")">Edit</button>
            <button type="submit" style="display:none;">Save</button>
        </form>
        <form method="post" action=""""),_display_(/*27.38*/routes/*27.44*/.tweet.deleteTweet),format.raw/*27.62*/("""">
            """),_display_(/*28.14*/helper/*28.20*/.CSRF.formField),format.raw/*28.35*/("""
            """),format.raw/*29.13*/("""<input type="hidden" name="deleteTweet" value=""""),_display_(/*29.61*/message/*29.68*/.text),format.raw/*29.73*/("""">
            <button type="submit">Delete</button>
        </form>
    </li>
    """)))}),format.raw/*33.6*/("""

    """),format.raw/*35.5*/("""<script>
        function toggleEditField(messageId) """),format.raw/*36.45*/("""{"""),format.raw/*36.46*/("""
            """),format.raw/*37.13*/("""var messageTextElement = document.getElementById('message-' + messageId);
            var inputField = document.querySelector('input[name="editTweetText"]');
            var saveButton = document.querySelector('button[type="submit"]');
            var cancelButton = document.querySelector('button[type="button"]');
            var currentMessageText = messageTextElement.textContent;

            if (inputField.style.display === "none") """),format.raw/*43.54*/("""{"""),format.raw/*43.55*/("""
                """),format.raw/*44.17*/("""inputField.value = currentMessageText;
                inputField.style.display = "inline-block";
                saveButton.style.display = "inline-block";
                cancelButton.textContent = "Cancel";
                messageTextElement.style.display = "none";
            """),format.raw/*49.13*/("""}"""),format.raw/*49.14*/(""" """),format.raw/*49.15*/("""else """),format.raw/*49.20*/("""{"""),format.raw/*49.21*/("""
                """),format.raw/*50.17*/("""inputField.style.display = "none";
                saveButton.style.display = "none";
                cancelButton.textContent = "Edit";
                messageTextElement.style.display = "inline";
            """),format.raw/*54.13*/("""}"""),format.raw/*54.14*/("""
        """),format.raw/*55.9*/("""}"""),format.raw/*55.10*/("""
    """),format.raw/*56.5*/("""</script>
</ul>


<div>
    <a href=""""),_display_(/*61.15*/routes/*61.21*/.tweet.logout),format.raw/*61.34*/("""" id="logout">Logout</a>
</div>

<div>
    <a href=""""),_display_(/*65.15*/routes/*65.21*/.tweet.home),format.raw/*65.32*/("""" id="home">Home</a>
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
                  HASH: c292852d388c74d60f908073103056b82102b64f
                  MATRIX: 807->1|1043->144|1070->145|1169->219|1208->243|1246->244|1273->245|1302->249|1328->255|1363->261|1392->263|1438->283|1478->307|1517->308|1545->309|1575->313|1602->319|1638->325|1667->327|1703->337|1741->359|1781->361|1813->366|1884->410|1900->417|1931->427|1961->430|1977->437|2003->442|2079->491|2094->497|2131->513|2174->529|2189->535|2225->550|2266->563|2341->611|2357->618|2388->628|2478->691|2494->698|2520->703|2632->788|2648->795|2679->805|2846->945|2861->951|2900->969|2943->985|2958->991|2994->1006|3035->1019|3110->1067|3126->1074|3152->1079|3266->1163|3299->1169|3380->1222|3409->1223|3450->1236|3917->1675|3946->1676|3991->1693|4300->1974|4329->1975|4358->1976|4391->1981|4420->1982|4465->1999|4703->2209|4732->2210|4768->2219|4797->2220|4829->2225|4894->2263|4909->2269|4943->2282|5023->2335|5038->2341|5070->2352
                  LINES: 21->1|26->2|27->3|31->7|31->7|31->7|32->8|32->8|32->8|33->9|35->11|36->12|36->12|36->12|37->13|37->13|37->13|38->14|40->16|41->17|41->17|41->17|42->18|43->19|43->19|43->19|43->19|43->19|43->19|44->20|44->20|44->20|45->21|45->21|45->21|46->22|46->22|46->22|46->22|47->23|47->23|47->23|48->24|48->24|48->24|51->27|51->27|51->27|52->28|52->28|52->28|53->29|53->29|53->29|53->29|57->33|59->35|60->36|60->36|61->37|67->43|67->43|68->44|73->49|73->49|73->49|73->49|73->49|74->50|78->54|78->54|79->55|79->55|80->56|85->61|85->61|85->61|89->65|89->65|89->65
                  -- GENERATED --
              */
          