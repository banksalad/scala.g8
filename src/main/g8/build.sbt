import Dependencies._

lazy val root = (project in file(".")).settings(
  inThisBuild(
    List(
      organization := "$organization$",
      scalaVersion := "$scala_version$"
    )
  ),
  name := "$name;format="start"$",
  version := "0.0.1",
  scalacOptions ++= Seq(
    "-unchecked",
    "-feature",
    "-deprecation",
    "-language:postfixOps",
    "-language:implicitConversions"
  ),
  libraryDependencies ++= Seq(
    testDependencies
  ).flatten,
  scalafmtOnCompile := true,
  autoCompilerPlugins := true,
  assemblyJarName in assembly := "$name;format="normalize"$.jar",
  assemblyOutputPath := new File("/app/target/$name$")
)
