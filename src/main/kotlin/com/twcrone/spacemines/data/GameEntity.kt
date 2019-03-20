package com.twcrone.spacemines.data

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.persistence.OneToMany

@Entity(name = "game")
class GameEntity(
  @ManyToOne(fetch = FetchType.LAZY, optional = false)
  @JoinColumn(name = "level_id")
  var level: Level? = null
) {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(mappedBy = "game", orphanRemoval = true)
    @Cascade(CascadeType.ALL)
    val pods: MutableSet<PodEntity> = HashSet()

    fun allMinesFlagged(): Boolean {
        val flagged = pods.filter { it.flagged }
        val mines = level?.listSectorsWithMines()

        if (flagged.size != mines?.size) { return false }

        return mines.all { mine ->
            flagged.any { it.x == mine.x && it.y == mine.y && it.z == mine.z }
        }
    }
}