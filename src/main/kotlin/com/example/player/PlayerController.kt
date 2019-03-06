package com.example.player

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class PlayerController(private val repository: PlayerRepository) {

    @GetMapping("/players")
    fun list(): ResponseEntity<List<Player>> {
        val players = repository.findAll().toList()
        return ResponseEntity(players, HttpStatus.OK)
    }

}