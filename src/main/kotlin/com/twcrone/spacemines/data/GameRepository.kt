package com.twcrone.spacemines.data

import org.springframework.data.repository.CrudRepository

interface GameRepository : CrudRepository<GameEntity, Long>