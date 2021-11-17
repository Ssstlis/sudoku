ThisBuild / scalaVersion := "2.13.7"

ThisBuild / githubWorkflowTargetTags ++= Seq("v*")

ThisBuild / githubWorkflowPublishTargetBranches := Seq(
  RefPredicate.Equals(Ref.Branch("master")),
  RefPredicate.StartsWith(Ref.Tag("v"))
)

ThisBuild / githubWorkflowJavaVersions          := Seq("adopt@1.8", "adopt@1.11")

ThisBuild / githubWorkflowBuildPreamble += WorkflowStep.Sbt(
  List("fmtCheck"),
  name = Some("Check formatting")
)

ThisBuild / versionScheme := Some("semver-spec")

ThisBuild / licenses += ("Apache-2.0", url("http://www.apache.org/licenses/LICENSE-2.0"))

ThisBuild / developers       := List(
  Developer("Ssstlis", "Ivan Aristov", "apostrof@1995@gmail.com", url("https://github.com/ssstlis"))
)

ThisBuild / organization     := "io.github.ssstlis"
ThisBuild / organizationName := "ssstlis"

ThisBuild / homepage := Some(url("https://github.com/ssstlis/sudoku"))

ThisBuild / description := "Sudoku resolve and verify tool"

ThisBuild / scmInfo                   := Some(
  ScmInfo(
    url("https://github.com/ssstlis/sudoku"),
    "git@github.com:ssstlis/sudoku"
  )
)

ThisBuild / githubWorkflowEnv += "CI" -> "true"
