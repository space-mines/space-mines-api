package com.twcrone.spacemines.minefield

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "mine_field")
class MineFieldEntity(@Id val id: Long) {
    @OneToMany(mappedBy = "mineField")
    val mines: MutableSet<MineEntity> = HashSet()
}

@Entity(name = "mine")
class MineEntity(@Id val id: Long, val x: Int, val y: Int, val z: Int) {
    @ManyToOne
    lateinit var mineField: MineFieldEntity
}