package Models

object CodeGen extends App {
  slick.codegen.SourceCodeGenerator.run(
    "slick.jdbc.PostgresProfile",
    "org.postgresql.Driver",
    "jdbc:postgresql://dumbo.db.elephantsql.com:5432/ghgphoyr?user=ghgphoyr&password=CknCoUheNM4XWeEtLX2qSXH8k60x-G94",
    "/Users/aseemsaini/Desktop/ACM/acm_app/app/",
    "Models", None, None, true, false
  )
}
