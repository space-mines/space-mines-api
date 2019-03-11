package com.twcrone.spacemines.data

import com.twcrone.spacemines.player.PlayerEntity
import org.hibernate.annotations.Cascade
import org.hibernate.annotations.CascadeType
import javax.persistence.*

@Entity(name = "game")
class GameEntity(
        @OneToOne(fetch = FetchType.LAZY)
        @JoinColumn(name = "id")
        @MapsId
        val player: PlayerEntity,

        @ManyToOne(fetch = FetchType.LAZY, optional = false)
        @JoinColumn(name = "mine_field_id")
        val mineField: MineFieldEntity? = null){
    @Id
    val id: Long = player.id

    @OneToMany(mappedBy = "game")
    @Cascade(CascadeType.ALL)
    val pods: MutableSet<PodEntity> = HashSet()

}