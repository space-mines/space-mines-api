package com.twcrone.spacemines.data

import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity(name = "game")
class GameEntity(
        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "level_id")
        val level: Level? = null){
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    val id: Long = 0

    @OneToMany(mappedBy = "game")
    @Cascade(CascadeType.ALL)
    val pods: MutableSet<PodEntity> = HashSet()

}