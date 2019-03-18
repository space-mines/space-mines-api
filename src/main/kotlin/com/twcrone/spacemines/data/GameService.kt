package com.twcrone.spacemines.data

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
open class GameService(
        private val playerRepository: PlayerRepository,
        private val gameRepository: GameRepository,
        private val levelRepository: LevelRepository
){
    @Transactional
    open fun findOrCreateGameFor(playerId: Long): PlayerEntity {
        val player = playerRepository.findOne(playerId)
        if(player.game == null) {
            val firstLevel = levelRepository.findOne(1)
            player.game = build(firstLevel)
            playerRepository.save(player)
        }
        return player
    }

    private fun build(
            level: Level): GameEntity {
        val game = GameEntity(level)
        repeat(level.size) { x ->
            repeat(level.size) { y ->
                repeat(level.size) { z ->
                    game.pods.add(PodEntity(game = game,x = x, y = y, z = z))
                }
            }
        }
        return game
    }

    @Transactional
    open fun get(id: Long): GameEntity {
        val game = gameRepository.findOne(id)
        game.pods
        return game
    }

    @Transactional
    open fun mark(id:Long, podId: Long): GameEntity {
        val game = gameRepository.findOne(id)
        val pod = game.pods.find { it.id == podId }
        if(pod!!.radiation > -1) {
            return game
        }
        pod.flagged = !pod.flagged
        return this.gameRepository.save(game)
    }

    @Transactional
    open fun reveal(id:Long, podId: Long): GameEntity {
        val game = gameRepository.findOne(id)
        val pod = game.pods.find { it.id == podId }
        if(pod!!.flagged) {
            return game
        }
        val sector = game.level?.sectors?.find {
            it.x == pod!!.x && it.y == pod.y && it.z == pod.z
        }
        if(sector!!.hasMine) {
            game.pods.forEach {
                it.flagged = false
                it.radiation = -1
            }
        }
        else {
            if(pod?.flagged == false) {
                pod.radiation = sector.radiation
                revealEmptySectors(pod, game)
            }
        }
        return this.gameRepository.save(game)
    }

    private fun close(i1: Int, i2: Int): Boolean {
        return i2 < i1 + 2 && i2 > i1 - 2
    }

    private fun findSectorFor(pod: PodEntity, mineField: Level) = mineField.sectors.find {
        it.x == pod.x && it.y == pod.y && it.z == pod.z
    }

    private fun revealEmptySectors(pod: PodEntity, game: GameEntity) {
        if(pod.radiation != 0) { return }
        val pods = game.pods
        pods.forEach {
            if(it.radiation == -1) {
                if(close(it.x, pod.x) && close(it.y, pod.y) && close(it.z, pod.z)) {
                    val sector = findSectorFor(it, game.level!!)
                    if(!pod.flagged) {
                        it.radiation = sector!!.radiation
                        revealEmptySectors(it, game)
                    }
                }
            }
        }
    }


    @Transactional
    open fun listIds(): List<Long> {
        val games = gameRepository.findAll()
        return games.map { it.id }
    }
}