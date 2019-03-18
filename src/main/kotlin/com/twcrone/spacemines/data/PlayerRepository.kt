package com.twcrone.spacemines.data

import org.springframework.data.repository.CrudRepository

interface PlayerRepository : CrudRepository<PlayerEntity, Long>