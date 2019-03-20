package com.twcrone.spacemines.data

import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "pod")
class PodEntity(
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "game_id")
  val game: GameEntity? = null,

  val x: Int,
  val y: Int,
  val z: Int,
  var radiation: Int = -1,
  var flagged: Boolean = false
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}