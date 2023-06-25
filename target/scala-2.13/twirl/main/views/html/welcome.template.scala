
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

object welcome extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template2[String,String,play.twirl.api.HtmlFormat.Appendable] {

  /**/
  def apply/*1.2*/(message: String, style: String = "scala"):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*1.44*/(""" 

"""),_display_(/*3.2*/defining(play.core.PlayVersion.current)/*3.41*/ { version =>_display_(Seq[Any](format.raw/*3.54*/("""

"""),format.raw/*5.1*/("""<section id="top">
  <div class="wrapper">
    <h1><a href="https://playframework.com/documentation/"""),_display_(/*7.59*/version),format.raw/*7.66*/("""/Home">"""),_display_(/*7.74*/message),format.raw/*7.81*/("""</a></h1>
  </div>
</section>

<div id="content" class="wrapper doc">
<article>

  <h1>Welcome to Play</h1>

  <p>
    Congratulations, you’ve just created a new Play application. This page will help you with the next few steps.
  </p>

  <blockquote>
    <p>
      You’re using Play """),_display_(/*22.26*/version),format.raw/*22.33*/("""
    """),format.raw/*23.5*/("""</p>
  </blockquote>


    <pre><code># Home page
GET     /               controllers.HomeController.index</code></pre>

    <p>
      Play has invoked the <code>controllers.HomeController.index</code> method to obtain the <code>Action</code> to execute:
    </p>

    <pre><code>def index = Action """),format.raw/*34.35*/("""{"""),format.raw/*34.36*/("""
  """),format.raw/*35.3*/("""Ok(views.html.index("Your new application is ready."))
"""),format.raw/*36.1*/("""}"""),format.raw/*36.2*/("""</code></pre>

    <p>
      An action is a function that handles the incoming HTTP request, and returns the HTTP result to send back to the web client.
      Here we send a <code>200 OK</code> response, using a template to fill its content.
    </p>

    <p>
      The template is defined in the <code>app/views/index.scala.html</code> file and compiled as a Scala function.
    </p>

    <pre><code>@(message: String)(implicit assetsFinder: AssetsFinder)

@main("Welcome to Play") """),format.raw/*49.27*/("""{"""),format.raw/*49.28*/("""

    """),format.raw/*51.5*/("""@welcome(message, style = "scala")

"""),format.raw/*53.1*/("""}"""),format.raw/*53.2*/("""</code></pre>

    <p>
      The first line of the template defines the function signature. Here it just takes a single <code>String</code> parameter.
      This template then calls another function defined in <code>app/views/main.scala.html</code>, which displays the HTML
      layout, and another function that displays this welcome message. You can freely add any HTML fragment mixed with Scala
      code in this file.
    </p>

    <p>You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*62.86*/version),format.raw/*62.93*/("""/ScalaTemplates">Twirl</a>, the template language used by Play, and how Play handles <a href="https://www.playframework.com/documentation/"""),_display_(/*62.232*/version),format.raw/*62.239*/("""/ScalaActions">actions</a>.</p>

    <h2>Async Controller</h2>

    Now that you've seen how Play renders a page, take a look at <code>AsyncController.scala</code>, which shows how to do asynchronous programming when handling a request.  The code is almost exactly the same as <code>HomeController.scala</code>, but instead of returning <code>Result</code>, the action returns <code>Future[String]</code> to Play.  When the execution completes, Play can use a thread to render the result without blocking the thread in the mean time.


    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*70.87*/version),format.raw/*70.94*/("""/ScalaAsync">asynchronous actions</a> in the documentation.
    </p>

    <h2>Count Controller</h2>

    <p>
        Both the HomeController and AsyncController are very simple, and typically controllers present the results of the interaction of several services.  As an example, see the <code>CountController</code>, which shows how to inject a component into a controller and use the component when handling requests.  The count controller increments every time you refresh the page, so keep refreshing to see the numbers go up.
    </p>


    <p>
        You can read more about <a href="https://www.playframework.com/documentation/"""),_display_(/*81.87*/version),format.raw/*81.94*/("""/ScalaDependencyInjection">dependency injection</a> in the documentation.
    </p>

    <h2>Need more info on the console?</h2>

  <p>
    For more information on the various commands you can run on Play, i.e. running tests and packaging applications for production, see <a href="https://playframework.com/documentation/"""),_display_(/*87.187*/version),format.raw/*87.194*/("""/PlayConsole">Using the Play console</a>.
  </p>

  <h2>Need to set up an IDE?</h2>

  <p>
      You can start hacking your application right now using any text editor. Any changes will be automatically reloaded at each page refresh,
      including modifications made to Scala source files.
  </p>

  <p>
      If you want to set-up your application in <strong>IntelliJ IDEA</strong> or any other Java IDE, check the
      <a href="https://www.playframework.com/documentation/"""),_display_(/*99.61*/version),format.raw/*99.68*/("""/IDE">Setting up your preferred IDE</a> page.
  </p>

  <h2>Need more documentation?</h2>

  <p>
    Play documentation is available at <a href="https://www.playframework.com/documentation/"""),_display_(/*105.94*/version),format.raw/*105.101*/("""">https://www.playframework.com/documentation</a>.
  </p>

  <p>
    Play comes with lots of example templates showcasing various bits of Play functionality at <a href="https://www.playframework.com/download#examples">https://www.playframework.com/download#examples</a>.
  </p>

  <h2>Need more help?</h2>

  <p>
    Play questions are asked and answered on Stackoverflow using the "playframework" tag: <a href="https://stackoverflow.com/questions/tagged/playframework">https://stackoverflow.com/questions/tagged/playframework</a>
  </p>

  <p>
    The <a href="https://github.com/playframework/playframework/discussions">Play Forum</a> is where Play users come to seek help,
    announce projects, and discuss issues and new features.
  </p>

  <p>
    Discord is a real time chat channel, like IRC. The <a href="https://discord.gg/g5s2vtZ4Fa">playframework</a>  channel is used by Play users to discuss the ins and outs of writing great Play applications.
  </p>

</article>



</div>
""")))}),format.raw/*132.2*/("""
"""))
      }
    }
  }

  def render(message:String,style:String): play.twirl.api.HtmlFormat.Appendable = apply(message,style)

  def f:((String,String) => play.twirl.api.HtmlFormat.Appendable) = (message,style) => apply(message,style)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/welcome.scala.html
                  HASH: a2a06926bdbafb2d75aafbcb4b438c20bb0d107c
                  MATRIX: 738->1|875->43|904->47|951->86|1001->99|1029->101|1156->202|1183->209|1217->217|1244->224|1556->509|1584->516|1616->521|1943->820|1972->821|2002->824|2084->879|2112->880|2623->1365|2652->1366|2685->1372|2748->1409|2776->1410|3322->1929|3350->1936|3517->2075|3546->2082|4203->2712|4231->2719|4894->3355|4922->3362|5271->3683|5300->3690|5805->4168|5833->4175|6051->4365|6081->4372|7100->5360
                  LINES: 21->1|26->1|28->3|28->3|28->3|30->5|32->7|32->7|32->7|32->7|47->22|47->22|48->23|59->34|59->34|60->35|61->36|61->36|74->49|74->49|76->51|78->53|78->53|87->62|87->62|87->62|87->62|95->70|95->70|106->81|106->81|112->87|112->87|124->99|124->99|130->105|130->105|157->132
                  -- GENERATED --
              */
          