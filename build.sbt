lazy val root = (project in file("."))
  .enablePlugins(PlayScala)
  .settings(
    name := """play-scala-starter-example""",
    version := "1.0-SNAPSHOT",
    scalaVersion := "2.13.10",
    libraryDependencies ++= Seq(
      guice,jdbc,
      "com.h2database" % "h2" % "1.4.200",
      "com.typesafe.play" %% "play-slick" % "5.0.0",
      "com.typesafe.slick" %% "slick-codegen" % "3.3.3",
      "com.typesafe.slick" %% "slick" % "3.3.3",
      "mysql" % "mysql-connector-java" % "8.0.26",
      "org.mindrot" % "jbcrypt" % "0.4",
      "org.scalatestplus.play" %% "scalatestplus-play" % "5.0.0" % Test
    ),
    scalacOptions ++= Seq(
      "-feature",
      "-deprecation",
      "-Xfatal-warnings"
    )
  )
