package com.twcrone.spacemines.game

import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GameController(private val service: GameService,
                     private val mineFieldRepository: MineFieldRepository) {

    @GetMapping("/game/{id}")
    fun getGame(@PathVariable id: Long): ResponseEntity<GameRep> {
        println("Finding game...")
        val entity = service.get(id)
        println("Found game with ID=${entity.id}")
        return ResponseEntity(GameRep.fromEntity(entity), HttpStatus.OK)
    }

    @PostMapping("/game",
            consumes = arrayOf(MediaType.APPLICATION_JSON_VALUE),
            produces = arrayOf(MediaType.APPLICATION_JSON_VALUE))
    fun createGame(): ResponseEntity<GameRep> {
        val mineField = mineFieldRepository.findOne(1)
        val saved = service.create(mineField)
        return ResponseEntity(GameRep.fromEntity(saved), HttpStatus.OK)
    }

}