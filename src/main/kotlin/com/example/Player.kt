package com.example

import java.time.Instant
import javax.persistence.Entity
import javax.persistence.Id

@Entity
data class Player(
        @Id
        val id: Long,
        val username: String,
        val password: String,
        val email: String,
        val createdOn: Instant,
        val lastLogin: Instant
)
