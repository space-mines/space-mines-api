package com.twcrone.spacemines.api

import com.twcrone.spacemines.data.GameService
import com.twcrone.spacemines.data.MineFieldRepository
import org.springframework.http.HttpStatus
import org.springframework.http.MediaType
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GameController(private val service: GameService,
                     private val mineFieldRepository: MineFieldRepository) {

    @GetMapping("/games")
    fun listGameIds(): ResponseEntity<List<Long>> {
        println("List game IDs...")
        val list = service.listIds()
        println("Found ${list.size} ids")
        return ResponseEntity(list, HttpStatus.OK)
    }

    @GetMapping("/game/{id}")
    fun getGame(@PathVariable id: Long): ResponseEntity<GameRep> {
        println("Finding data...")
        val entity = service.get(id)
        println("Found data with ID=${entity.id}")
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