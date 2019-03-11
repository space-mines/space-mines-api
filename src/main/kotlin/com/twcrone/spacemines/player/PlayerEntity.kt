package com.twcrone.spacemines.player

import com.twcrone.spacemines.data.GameEntity
import javax.persistence.*

@Entity(name = "player")
class PlayerEntity(
        @Id
        val id: Long,
        val username: String,
        val email: String,

        @OneToOne(mappedBy = "player", cascade = arrayOf(CascadeType.ALL),
                fetch = FetchType.LAZY, optional = true)
        var game: GameEntity? = null
)