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
    open fun mark(id:Long, podId: Long): GameEntity {
        val game = repository.findOne(id)
        val pod = game.pods.find { it.id == podId }
        if(pod!!.radiation > -1) {
            return game
        }
        pod.flagged = !pod.flagged
        return repository.save(game)
    }

    @Transactional
    open fun reveal(id:Long, podId: Long): GameEntity {
        val game = repository.findOne(id)
        val pod = game.pods.find { it.id == podId }
        val sector = game.mineField?.sectors?.find {
            it.x == pod!!.x && it.y == pod.y && it.z == pod.z
        }
        if(sector!!.mine) {
            game.pods.forEach {
                it.flagged = false
                it.radiation = -1
            }
        }
        else {
            pod!!.radiation = sector.radiation
            revealEmptySectors(pod, game)
        }
        return repository.save(game)
    }

    private fun close(i1: Int, i2: Int): Boolean {
        return i2 < i1 + 2 && i2 > i1 - 2
    }

    private fun findSectorFor(pod: PodEntity, mineField: MineFieldEntity) = mineField.sectors.find {
        it.x == pod.x && it.y == pod.y && it.z == pod.z
    }

    private fun revealEmptySectors(pod: PodEntity, game: GameEntity) {
        if(pod.radiation != 0) { return }
        val pods = game.pods
        pods.forEach {
            if(it.radiation == -1) {
                if(close(it.x, pod.x) && close(it.y, pod.y) && close(it.z, pod.z)) {
                    val sector = findSectorFor(it, game.mineField!!)
                    it.radiation = sector!!.radiation
                    revealEmptySectors(it, game)
                }
            }
        }
    }


    @Transactional
    open fun listIds(): List<Long> {
        val games = repository.findAll()
        return games.map { it.id }
    }
}