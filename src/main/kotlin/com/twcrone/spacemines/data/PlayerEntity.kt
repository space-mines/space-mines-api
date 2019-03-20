package com.twcrone.spacemines.data

import javax.persistence.CascadeType
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.OneToOne

@Entity(name = "player")
class PlayerEntity(
  @Id
  val id: Long,
  val username: String,
  val email: String,

  @OneToOne(cascade = arrayOf(CascadeType.ALL))
  @JoinColumn(name = "game_id")
  var game: GameEntity? = null
)