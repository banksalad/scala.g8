import sbt._

object Dependencies {
  private lazy val scalaTestVersion = "$scala_test_version$"

  lazy val testDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest"
  ).map(_ % scalaTestVersion)
}
