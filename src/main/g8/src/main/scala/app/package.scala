import com.typesafe.config.{Config, ConfigFactory}

package object app {

  final case class HttpConfiguration(port: Int)
  object HttpConfiguration {
    def apply(config: Config): HttpConfiguration = HttpConfiguration(config.getInt("port"))
  }

  object Configuration {
    private lazy val app = ConfigFactory.load().getConfig("app")

    lazy val isDebug: Boolean = app.getBoolean("debug")
    lazy val isProd: Boolean = !isDebug

    lazy val http: HttpConfiguration = HttpConfiguration(app.getConfig("http"))
  }
}
