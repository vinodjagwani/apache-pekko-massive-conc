package com.example.pekko

import org.apache.pekko.actor.typed.Behavior
import org.apache.pekko.actor.typed.scaladsl.Behaviors
import org.apache.pekko.cluster.sharding.typed.scaladsl.{ClusterSharding, Entity}

object Guardian {
  def apply(): Behavior[Nothing] = Behaviors.setup[Nothing] { context =>
    val sharding = ClusterSharding(context.system)

    sharding.init(
      Entity(DeviceEntity.TypeKey) { entityCtx =>
        DeviceEntity(entityCtx.entityId) // Correct type signature
      }
    )

    context.log.info("Guardian started, ready to accept REST requests")
    Behaviors.empty
  }
}
