package com.twcrone.spacemines.data

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity(name = "game")
class GameEntity(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "level_id")
        var level: Level? = null){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(mappedBy = "game")
    @Cascade(CascadeType.ALL)
    var pods: MutableSet<PodEntity> = HashSet()

    fun allMinesFlagged(): Boolean {
        val flagged = pods.filter { it.flagged }
        val mines = level?.listSectorsWithMines()

        if(flagged.size != mines?.size) { return false }

        return mines.all { mine ->
            flagged.any { it.x == mine.x && it.y == mine.y && it.z == mine.z }
        }
    }
}