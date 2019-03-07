package com.twcrone.spacemines.game

data class GameRep(val id: Long) {
    val minePods: MutableSet<MinePodRep> = HashSet()

    companion object {
        fun fromEntity(entity: GameEntity): GameRep {
            val game = GameRep(id = entity.id)
            entity.minePods.forEach{ minePod ->
                game.minePods.add(MinePodRep(
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

data class MinePodRep(val id: Long, val x: Int, val y: Int, val z: Int, val radiation: Int, val flagged: Boolean)