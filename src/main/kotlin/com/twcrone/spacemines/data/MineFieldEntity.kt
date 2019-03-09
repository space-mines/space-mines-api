package com.twcrone.spacemines.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "mine_field")
class MineFieldEntity(@Id val id: Long = 0, val size: Int = 3) {
    @OneToMany(mappedBy = "mineField")
    val sectors: MutableSet<Sector> = mutableSetOf()
}

@Entity(name = "sector")
class Sector(@Id val id: Long, val x: Int, val y: Int, val z: Int,
             val radiation: Int = 0, val mine: Boolean = false) {
    @ManyToOne
    lateinit var mineField: MineFieldEntity
}