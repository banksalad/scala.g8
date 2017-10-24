package app

import akka.actor.ActorSystem
import akka.stream.Materializer
import app.http.{ApplicationRoutes, HttpRoute}
import monix.execution.Scheduler

import scala.concurrent.ExecutionContext

trait Components {
  implicit def system: ActorSystem
  implicit def ec: ExecutionContext = system.dispatcher
  implicit def m: Materializer
  implicit def s: Scheduler

  lazy val httpRoutes: HttpRoute = new ApplicationRoutes
}
