package com.twcrone.spacemines.data

import javax.persistence.*

@Entity(name = "pod")
class PodEntity(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "game_id")
        val game: GameEntity? = null,

        val x: Int,
        val y: Int,
        val z: Int,
        val radiation: Int = -1,
        val flagged: Boolean = false
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0
}