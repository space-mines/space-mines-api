package com.twcrone.spacemines.player

import org.springframework.stereotype.Service

@Service
class PlayerService(val repository: PlayerRepository) {

    fun get(id: Long): PlayerEntity {
        return repository.findOne(id)
    }

}