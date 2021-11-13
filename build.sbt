
ThisBuild / scalaVersion := "2.13.7"
ThisBuild / fork := true
ThisBuild / scalacOptions ++= Seq("-Ymacro-annotations", "-Wconf:any:wv")
ThisBuild / javaOptions += "-XX:MaxMetaspaceSize=1024m"

Global / cancelable := true
Global / onChangedBuildSource := ReloadOnSourceChanges

lazy val app = project
  .in(file("sudoku"))
  .settings(
    name := "sudoku",
    version := "0.0.1",
    excludeDependencies += "org.typelevel" %% "simulacrum-scalafix-annotations",
    Compile / console / scalacOptions ~= (_.filterNot(_ == "-Xfatal-warnings")),
    Test / console / scalacOptions ~= (_.filterNot(_ == "-Xfatal-warnings"))
  )
  .enablePlugins(JavaAppPackaging)

addCommandAlias("fmt", "all scalafmtSbt scalafmt test:scalafmt")
addCommandAlias("fmtCheck", "all scalafmtSbtCheck scalafmtCheck test:scalafmtCheck")
