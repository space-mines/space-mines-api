package com.example.game

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class GameController(private val repository: GameRepository) {

    @GetMapping("/game/{id}")
    fun getGame(@PathVariable id: Long): ResponseEntity<GameRep> {
        println("Finding game...")
        val entity = repository.findOne(id)
        println("Found game with ID=${entity.id}")
        return ResponseEntity(GameRep.fromEntity(entity), HttpStatus.OK)
    }

}