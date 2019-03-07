package com.twcrone.spacemines.game

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne

@Entity(name = "mine_pod")
class MinePodEntity(@Id val id: Long, val x: Int, val y: Int, val z: Int, val radiation: Int, val flagged: Boolean) {
    @ManyToOne
    lateinit var game: GameEntity
}