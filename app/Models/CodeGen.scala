package Models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.MySQLProfile",
    "oracle.jdbc.OracleDriver",
    "jdbc:mysql://localhost/tasklist?user=aseem&password=aseem123",
    "/Users/aseemsaini/Documents/GitHub/Scala_Play/app/",
    "Models", None, None, true, false
  )
}