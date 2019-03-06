package com.example.player

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

@Entity(name = "player")
data class PlayerEntity(
        @Id
        val id: Long,
        val username: String,
        val password: String,
        val email: String,
        val createdOn: Instant,
        val lastLogin: Instant? = null
)
