package com.twcrone.spacemines.game

import org.springframework.data.repository.CrudRepository

interface GameRepository : CrudRepository<GameEntity, Long>