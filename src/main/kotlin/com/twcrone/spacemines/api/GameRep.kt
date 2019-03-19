package com.twcrone.spacemines.api

import com.twcrone.spacemines.data.GameEntity

data class GameRep(val id: Long,
                   val level: Long) {

    val pods: MutableSet<PodRep> = HashSet()

    companion object {
        fun fromEntity(entity: GameEntity): GameRep {
            val game = GameRep(id = entity.id, level = entity.level!!.id)
            entity.pods.forEach{ minePod ->
                game.pods.add(PodRep(
                        id = minePod.id,
                        x = minePod.x,
                        y = minePod.y,
                        z = minePod.z,
                        radiation = minePod.radiation,
                        flagged = minePod.flagged))
            }
            return game
        }
    }
}

data class PodRep(val id: Long, val x: Int, val y: Int, val z: Int,
                  val radiation: Int = -1, val flagged: Boolean)