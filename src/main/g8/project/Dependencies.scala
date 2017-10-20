import sbt._

object Dependencies {
  private lazy val monixVersion = "$monix_version$"

  private lazy val akkaHttpVersion = "$akka_http_version$"

  private lazy val scalaTestVersion = "$scala_test_version$"

  lazy val coreDependencies: Seq[ModuleID] = Seq(
    "io.monix" %% "monix-execution",
    "io.monix" %% "monix-eval"
  ).map(_ % monixVersion)

  lazy val httpDependencies: Seq[ModuleID] = Seq(
    "com.typesafe.akka" %% "akka-http"
  ).map(_ % akkaHttpVersion)

  lazy val testDependencies: Seq[ModuleID] = Seq(
    "org.scalatest" %% "scalatest"
  ).map(_ % scalaTestVersion) ++ Seq(
    "com.typesafe.akka" %% "akka-http-testkit"
  ).map(_ % akkaHttpVersion % Test)
}
