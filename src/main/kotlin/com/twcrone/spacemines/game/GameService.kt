package com.twcrone.spacemines.game

import org.springframework.stereotype.Service

@Service
class GameService(val repository: GameRepository) {

    fun create(mineField: MineFieldEntity): GameEntity {
        val game = GameEntity(mineField)
        repeat(mineField.size) { x ->
            repeat(mineField.size) { y ->
                repeat(mineField.size) { z ->
                    game.minePods.add(MinePodEntity(x = x, y = y, z = z))
                }
            }
        }
        return game
    }
}