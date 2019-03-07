package com.twcrone.spacemines.game

import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity(name = "game")
class GameEntity(@Id val id: Long) {
    @OneToMany(mappedBy = "game")
    val minePods: MutableSet<MinePodEntity> = HashSet()
}