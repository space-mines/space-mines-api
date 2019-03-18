package com.twcrone.spacemines.api

import com.twcrone.spacemines.data.GameService
import com.twcrone.spacemines.data.LevelRepository
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
class GameController(private val service: GameService) {

    @CrossOrigin
    @GetMapping("/games")
    fun listGameIds(): ResponseEntity<List<Long>> {
        println("List game IDs...")
        val list = service.listIds()
        println("Found ${list.size} ids")
        return ResponseEntity(list, HttpStatus.OK)
    }

    @CrossOrigin
    @GetMapping("/game/{id}")
    fun getGame(@PathVariable id: Long): ResponseEntity<GameRep> {
        println("Finding data...")
        val entity = service.get(id)
        println("Found data with ID=${entity.id}")
        return ResponseEntity(GameRep.fromEntity(entity), HttpStatus.OK)
    }

    @CrossOrigin
    @PatchMapping("/game/{id}/pod/{podId}")
    fun revealPod(@PathVariable id: Long, @PathVariable podId: Long): ResponseEntity<GameRep> {
        println("Revealing pod...")
        val entity = service.reveal(id, podId)
        println("Revealed pod...")
        return ResponseEntity(GameRep.fromEntity(entity), HttpStatus.OK)
    }

    @CrossOrigin
    @PutMapping("/game/{id}/pod/{podId}")
    fun markPod(@PathVariable id: Long, @PathVariable podId: Long): ResponseEntity<GameRep> {
        println("Marking pod...")
        val entity = service.mark(id, podId)
        println("Marked pod...")
        return ResponseEntity(GameRep.fromEntity(entity), HttpStatus.OK)
    }

}