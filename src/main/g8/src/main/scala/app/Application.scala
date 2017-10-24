package app

import akka.actor.ActorSystem
import akka.http.scaladsl.server.HttpApp
import akka.stream.{ActorMaterializer, Materializer}
import monix.execution.Scheduler

object Application extends HttpApp with App with Components {
  override implicit def system: ActorSystem = ActorSystem("app")
  override implicit def m: Materializer = ActorMaterializer()
  override implicit def s: Scheduler = Scheduler.Implicits.global

  override protected def routes = httpRoutes.route

  startServer("0.0.0.0", Configuration.http.port)
}
