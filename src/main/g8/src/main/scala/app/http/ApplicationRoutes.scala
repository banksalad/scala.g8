package app.http

import akka.http.scaladsl.server.Route
import akka.http.scaladsl.server.Directives._

class ApplicationRoutes extends HttpRoute {
  override def route: Route = pathEndOrSingleSlash {
    complete("app")
  }
}
