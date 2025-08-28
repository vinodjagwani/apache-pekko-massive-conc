package com.example.pekko

import org.apache.pekko.actor.typed.ActorSystem
import org.apache.pekko.cluster.sharding.typed.scaladsl.ClusterSharding
import org.apache.pekko.http.scaladsl.Http
import org.apache.pekko.http.scaladsl.server.Directives.*

import scala.concurrent.ExecutionContextExecutor
import scala.util.{Failure, Success}

object HttpServer {

  def start(system: ActorSystem[_]): Unit = {
    implicit val sys: ActorSystem[_] = system
    implicit val ec: ExecutionContextExecutor = system.executionContext

    val sharding = ClusterSharding(system)

    val route =
      path("ping" / Segment) { deviceId =>
        get {
          val entityRef = sharding.entityRefFor(DeviceEntity.TypeKey, deviceId)
          entityRef ! DeviceEntity.Ping
          complete(s"Ping sent to device [$deviceId]")
        }
      }

    val httpPort = sys.settings.config.getInt("http.port")

    val bindingFuture = Http().newServerAt("0.0.0.0", httpPort).bind(route)

    bindingFuture.onComplete {
      case Success(binding) =>
        system.log.info(s"🚀 REST API online at http://localhost:$httpPort/ping/{deviceId}")
      case Failure(ex) =>
        system.log.error("Failed to bind HTTP endpoint", ex)
        system.terminate()
    }
  }
}
