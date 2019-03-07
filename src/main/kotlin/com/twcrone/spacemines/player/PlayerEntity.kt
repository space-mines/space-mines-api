package com.twcrone.spacemines.player

import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "player")
class PlayerEntity(
        @Id
        val id: Long,
        val username: String,
        val email: String
)