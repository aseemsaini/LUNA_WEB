package Models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.MySQLProfile",
    "com.mysql.cj.jdbc.Driver",
    "jdbc:mysql://localhost/luna?user=aseem&password=aseem123",
    "/Users/aseemsaini/Desktop/ACM/acm_app/app/",
    "Models", None, None, true, false
  )
}
