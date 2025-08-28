package com.example.pekko

import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.EntityTypeKey

object DeviceEntity {

  val TypeKey: EntityTypeKey[Command] = EntityTypeKey[Command]("DeviceEntity")

  def apply(deviceId: String): Behavior[Command] = Behaviors.setup { context =>
    context.log.info(s"Device [$deviceId] actor started")
    Behaviors.receiveMessage {
      case Ping =>
        context.log.info(s"Device [$deviceId] received Ping")
        Behaviors.same
    }
  }

  sealed trait Command

  case object Ping extends Command
}
