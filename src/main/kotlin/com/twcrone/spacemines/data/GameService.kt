package com.twcrone.spacemines.data

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
                    game.pods.add(PodEntity(game = game,x = x, y = y, z = z))
                }
            }
        }
        return repository.save(game)
    }

    @Transactional
    open fun get(id: Long): GameEntity {
        val game = repository.findOne(id)
        game.pods
        return game
    }

    @Transactional
    open fun listIds(): List<Long> {
        val games = repository.findAll()
        return games.map { it.id }
    }
}