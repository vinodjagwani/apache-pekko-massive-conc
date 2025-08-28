//package com.example.pekko
//
//import org.apache.pekko.actor.typed.ActorSystem
//import com.typesafe.config.ConfigFactory
//
//object SingleNodeMain {
//  def main(args: Array[String]): Unit = {
//    val config = ConfigFactory.load()
//    val system = ActorSystem[Nothing](Guardian(), "IoTSystem", config)
//    HttpServer.start(system)
//  }
//}
