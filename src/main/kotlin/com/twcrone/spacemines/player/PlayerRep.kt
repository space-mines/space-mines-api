package com.twcrone.spacemines.player

data class PlayerRep(
    val id: Long,
    val username: String,
    val email: String
) {
    companion object {
        fun fromEntity(entity: PlayerEntity) =
                PlayerRep(id = entity.id, username = entity.username, email = entity.email)
    }
}