package com.twcrone.spacemines.game

import javax.persistence.*

@Entity(name = "game")
class GameEntity(
        @Id @GeneratedValue(strategy = GenerationType.AUTO)
        var id: Long = 0
) {
    @OneToMany(mappedBy = "game")
    val minePods: MutableSet<MinePodEntity> = HashSet()

    @ManyToOne
    lateinit var mineField: MineFieldEntity
}