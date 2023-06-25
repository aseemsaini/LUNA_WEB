
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

object login2 extends _root_.play.twirl.api.BaseScalaTemplate[play.twirl.api.HtmlFormat.Appendable,_root_.play.twirl.api.Format[play.twirl.api.HtmlFormat.Appendable]](play.twirl.api.HtmlFormat) with _root_.play.twirl.api.Template3[Form[LoginData2],MessagesRequestHeader,Flash,play.twirl.api.HtmlFormat.Appendable] {

  /* Login Template File */
  def apply/*2.2*/(loginForm: Form[LoginData2])(implicit request: MessagesRequestHeader, flash: Flash):play.twirl.api.HtmlFormat.Appendable = {
    _display_ {
      {


Seq[Any](format.raw/*3.1*/("""
"""),format.raw/*4.1*/("""<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        body """),format.raw/*10.14*/("""{"""),format.raw/*10.15*/("""
            """),format.raw/*11.13*/("""background-color: #f2f2f2;
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        """),format.raw/*15.9*/("""}"""),format.raw/*15.10*/("""

        """),format.raw/*17.9*/(""".container """),format.raw/*17.20*/("""{"""),format.raw/*17.21*/("""
            """),format.raw/*18.13*/("""display: flex;
            align-items: center;
            justify-content: center;
            height: 100vh;
        """),format.raw/*22.9*/("""}"""),format.raw/*22.10*/("""

        """),format.raw/*24.9*/(""".login-form """),format.raw/*24.21*/("""{"""),format.raw/*24.22*/("""
            """),format.raw/*25.13*/("""background-color: #fff;
            border-radius: 6px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
            padding: 40px;
            width: 400px;
        """),format.raw/*30.9*/("""}"""),format.raw/*30.10*/("""

        """),format.raw/*32.9*/(""".login-form h3 """),format.raw/*32.24*/("""{"""),format.raw/*32.25*/("""
            """),format.raw/*33.13*/("""font-size: 24px;
            margin-bottom: 20px;
            text-align: center;
            color: #007bff;
        """),format.raw/*37.9*/("""}"""),format.raw/*37.10*/("""

        """),format.raw/*39.9*/(""".form-group """),format.raw/*39.21*/("""{"""),format.raw/*39.22*/("""
            """),format.raw/*40.13*/("""margin-bottom: 20px;
        """),format.raw/*41.9*/("""}"""),format.raw/*41.10*/("""

        """),format.raw/*43.9*/(""".form-group label """),format.raw/*43.27*/("""{"""),format.raw/*43.28*/("""
            """),format.raw/*44.13*/("""display: block;
            font-size: 14px;
            font-weight: bold;
            margin-bottom: 5px;
            color: #007bff;
        """),format.raw/*49.9*/("""}"""),format.raw/*49.10*/("""

        """),format.raw/*51.9*/(""".form-group input """),format.raw/*51.27*/("""{"""),format.raw/*51.28*/("""
            """),format.raw/*52.13*/("""border: 1px solid #ccc;
            border-radius: 4px;
            font-size: 16px; /* Adjusted text size for username */
            padding: 10px;
            width: 100%;
            color: #333;
        """),format.raw/*58.9*/("""}"""),format.raw/*58.10*/("""

        """),format.raw/*60.9*/(""".form-actions """),format.raw/*60.23*/("""{"""),format.raw/*60.24*/("""
            """),format.raw/*61.13*/("""text-align: center;
        """),format.raw/*62.9*/("""}"""),format.raw/*62.10*/("""

        """),format.raw/*64.9*/(""".form-actions button """),format.raw/*64.30*/("""{"""),format.raw/*64.31*/("""
            """),format.raw/*65.13*/("""background-color: #007bff;
            border: none;
            border-radius: 4px;
            color: #fff;
            cursor: pointer;
            font-size: 14px;
            padding: 10px 20px;
        """),format.raw/*72.9*/("""}"""),format.raw/*72.10*/("""

        """),format.raw/*74.9*/(""".form-actions button:hover """),format.raw/*74.36*/("""{"""),format.raw/*74.37*/("""
            """),format.raw/*75.13*/("""background-color: #0056b3;
        """),format.raw/*76.9*/("""}"""),format.raw/*76.10*/("""

        """),format.raw/*78.9*/("""/* Custom styles for visual appeal */
        .login-form """),format.raw/*79.21*/("""{"""),format.raw/*79.22*/("""
            """),format.raw/*80.13*/("""background-image: url('https://example.com/login-background.jpg');
            background-size: cover;
            background-position: center;
            color: #fff;
        """),format.raw/*84.9*/("""}"""),format.raw/*84.10*/("""

        """),format.raw/*86.9*/(""".form-group input,
        .form-group label """),format.raw/*87.27*/("""{"""),format.raw/*87.28*/("""
            """),format.raw/*88.13*/("""color: #fff;
        """),format.raw/*89.9*/("""}"""),format.raw/*89.10*/("""

        """),format.raw/*91.9*/(""".form-actions button """),format.raw/*91.30*/("""{"""),format.raw/*91.31*/("""
            """),format.raw/*92.13*/("""background-color: #fff;
            color: #007bff;
            border: 1px solid #007bff;
        """),format.raw/*95.9*/("""}"""),format.raw/*95.10*/("""

        """),format.raw/*97.9*/(""".form-actions button:hover """),format.raw/*97.36*/("""{"""),format.raw/*97.37*/("""
            """),format.raw/*98.13*/("""background-color: #007bff;
            color: #fff;
        """),format.raw/*100.9*/("""}"""),format.raw/*100.10*/("""
    """),format.raw/*101.5*/("""</style>
</head>
<body>
<div class="container">
    <div class="login-form">
        """),_display_(/*106.10*/helper/*106.16*/.form(action = routes.TaskList5.createUserForm)/*106.63*/ {_display_(Seq[Any](format.raw/*106.65*/("""
        """),_display_(/*107.10*/helper/*107.16*/.CSRF.formField),format.raw/*107.31*/("""
        """),format.raw/*108.9*/("""<h3>Create User with Play Form</h3>
        <div class="form-group">
            <label for=""""),_display_(/*110.26*/Symbol("username")),format.raw/*110.44*/("""">Username</label>
            """),_display_(/*111.14*/helper/*111.20*/.inputText(loginForm("Username"), Symbol("id") -> "username", Symbol("class") -> "form-control")),format.raw/*111.116*/("""
        """),format.raw/*112.9*/("""</div>
        <div class="form-group">
            <label for=""""),_display_(/*114.26*/Symbol("password")),format.raw/*114.44*/("""">Password</label>
            """),_display_(/*115.14*/helper/*115.20*/.inputPassword(loginForm("Password"), Symbol("id") -> "password", Symbol("class") -> "form-control")),format.raw/*115.120*/("""
        """),format.raw/*116.9*/("""</div>
        <div class="form-actions">
            <button type="submit">Login</button>
        </div>
        """)))}),format.raw/*120.10*/("""
    """),format.raw/*121.5*/("""</div>
</div>
</body>
</html>
"""))
      }
    }
  }

  def render(loginForm:Form[LoginData2],request:MessagesRequestHeader,flash:Flash): play.twirl.api.HtmlFormat.Appendable = apply(loginForm)(request,flash)

  def f:((Form[LoginData2]) => (MessagesRequestHeader,Flash) => play.twirl.api.HtmlFormat.Appendable) = (loginForm) => (request,flash) => apply(loginForm)(request,flash)

  def ref: this.type = this

}


              /*
                  -- GENERATED --
                  SOURCE: app/views/login2.scala.html
                  HASH: d21955bc2f4f4e3095cdeabd4131902ae2be9f94
                  MATRIX: 789->27|967->112|994->113|1139->230|1168->231|1209->244|1362->370|1391->371|1428->381|1467->392|1496->393|1537->406|1684->526|1713->527|1750->537|1790->549|1819->550|1860->563|2057->733|2086->734|2123->744|2166->759|2195->760|2236->773|2381->891|2410->892|2447->902|2487->914|2516->915|2557->928|2613->957|2642->958|2679->968|2725->986|2754->987|2795->1000|2966->1144|2995->1145|3032->1155|3078->1173|3107->1174|3148->1187|3383->1395|3412->1396|3449->1406|3491->1420|3520->1421|3561->1434|3616->1462|3645->1463|3682->1473|3731->1494|3760->1495|3801->1508|4036->1716|4065->1717|4102->1727|4157->1754|4186->1755|4227->1768|4289->1803|4318->1804|4355->1814|4441->1872|4470->1873|4511->1886|4715->2063|4744->2064|4781->2074|4854->2119|4883->2120|4924->2133|4972->2154|5001->2155|5038->2165|5087->2186|5116->2187|5157->2200|5283->2299|5312->2300|5349->2310|5404->2337|5433->2338|5474->2351|5562->2411|5592->2412|5625->2417|5739->2503|5755->2509|5812->2556|5853->2558|5891->2568|5907->2574|5944->2589|5981->2598|6103->2692|6143->2710|6203->2742|6219->2748|6338->2844|6375->2853|6468->2918|6508->2936|6568->2968|6584->2974|6707->3074|6744->3083|6891->3198|6924->3203
                  LINES: 21->2|26->3|27->4|33->10|33->10|34->11|38->15|38->15|40->17|40->17|40->17|41->18|45->22|45->22|47->24|47->24|47->24|48->25|53->30|53->30|55->32|55->32|55->32|56->33|60->37|60->37|62->39|62->39|62->39|63->40|64->41|64->41|66->43|66->43|66->43|67->44|72->49|72->49|74->51|74->51|74->51|75->52|81->58|81->58|83->60|83->60|83->60|84->61|85->62|85->62|87->64|87->64|87->64|88->65|95->72|95->72|97->74|97->74|97->74|98->75|99->76|99->76|101->78|102->79|102->79|103->80|107->84|107->84|109->86|110->87|110->87|111->88|112->89|112->89|114->91|114->91|114->91|115->92|118->95|118->95|120->97|120->97|120->97|121->98|123->100|123->100|124->101|129->106|129->106|129->106|129->106|130->107|130->107|130->107|131->108|133->110|133->110|134->111|134->111|134->111|135->112|137->114|137->114|138->115|138->115|138->115|139->116|143->120|144->121
                  -- GENERATED --
              */
          