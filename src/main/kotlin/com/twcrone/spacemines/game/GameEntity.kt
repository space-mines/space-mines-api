package com.twcrone.spacemines.game

import javax.persistence.*

@Entity(name = "game")
class GameEntity(@ManyToOne(fetch = FetchType.LAZY, optional = false)
                 @JoinColumn(name = "mine_field_id")
                 val mineField: MineFieldEntity? = null){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(mappedBy = "game")
    val minePods: MutableSet<MinePodEntity> = HashSet()

}