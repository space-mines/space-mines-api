package com.twcrone.spacemines.player

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(private val repository: PlayerRepository) {

    @GetMapping("/player")
    fun first(): ResponseEntity<PlayerRep> {
        println("Finding first...")
        val entity = repository.findAll().first()
        println("Found player with ID=${entity.id}")
        val rep = PlayerRep.fromEntity(entity)
        println("Returning response ${rep}")
        return ResponseEntity(rep, HttpStatus.OK)
    }

}