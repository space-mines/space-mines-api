package com.twcrone.spacemines.data

import javax.persistence.*

@Entity(name = "player")
class PlayerEntity(
        @Id
        val id: Long,
        val username: String,
        val email: String,

        @OneToOne(cascade = arrayOf(CascadeType.ALL))
        @JoinColumn(name="game_id")
        var game: GameEntity? = null
)