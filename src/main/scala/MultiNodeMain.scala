package com.example.pekko

import org.apache.pekko.actor.typed.ActorSystem

object MultiNodeMain {

  def main(args: Array[String]): Unit = {
    val system = ActorSystem[Nothing](Guardian(), "IoTSystem")

    // Start HTTP server
    HttpServer.start(system)

    // Keep JVM alive until ActorSystem terminates
    scala.concurrent.Await.result(system.whenTerminated, scala.concurrent.duration.Duration.Inf)
  }
}

