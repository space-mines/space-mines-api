package com.twcrone.spacemines.game

import javax.persistence.*

@Entity(name = "mine_pod")
class MinePodEntity(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "game_id")
        val game: GameEntity? = null,

        val x: Int,
        val y: Int,
        val z: Int,
        val radiation: Int = 0,
        val flagged: Boolean = false
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}