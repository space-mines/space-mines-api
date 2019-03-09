package com.twcrone.spacemines.game

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "mine_field")
class MineFieldEntity(@Id val id: Long = 0, val size: Int = 3) {
    @OneToMany(mappedBy = "mineField")
    val mines: MutableSet<MineEntity> = mutableSetOf()
}

@Entity(name = "mine")
class MineEntity(@Id val id: Long, val x: Int, val y: Int, val z: Int) {
    @ManyToOne
    lateinit var mineField: MineFieldEntity
}