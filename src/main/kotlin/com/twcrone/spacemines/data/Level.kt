package com.twcrone.spacemines.data

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "level")
class Level(@Id val id: Long = 0, val size: Int = 3) {
    @OneToMany(mappedBy = "level")
    val sectors: MutableSet<Sector> = mutableSetOf()

    fun listSectorsWithMines(): List<Sector> {
        return sectors.filter { it.hasMine }
    }
}

@Entity(name = "sector")
class Sector(@Id val id: Long, val x: Int, val y: Int, val z: Int,
             val radiation: Int = 0, val hasMine: Boolean = false) {
    @ManyToOne
    lateinit var level: Level
}