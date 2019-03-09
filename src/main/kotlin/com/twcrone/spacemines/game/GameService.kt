package com.twcrone.spacemines.game

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class GameService(private val repository: GameRepository) {

    @Transactional
    open fun create(mineField: MineFieldEntity): GameEntity {
        val game = GameEntity(mineField)
        repeat(mineField.size) { x ->
            repeat(mineField.size) { y ->
                repeat(mineField.size) { z ->
                    game.minePods.add(MinePodEntity(game = game,x = x, y = y, z = z))
                }
            }
        }
        return repository.save(game)
    }

    @Transactional
    open fun get(id: Long): GameEntity {
        val game = repository.findOne(id)
        game.minePods
        return repository.save(game)
    }
}