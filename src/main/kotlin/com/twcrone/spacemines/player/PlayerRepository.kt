package com.twcrone.spacemines.player

import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<PlayerEntity, Long>