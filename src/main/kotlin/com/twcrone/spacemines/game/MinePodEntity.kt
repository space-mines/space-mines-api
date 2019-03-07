package com.twcrone.spacemines.game

import javax.persistence.*

@Entity(name = "mine_pod")
class MinePodEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0,
        val x: Int,
        val y: Int,
        val z: Int,
        val radiation: Int = 0,
        val flagged: Boolean = false
) {
    @ManyToOne
    lateinit var game: GameEntity
}