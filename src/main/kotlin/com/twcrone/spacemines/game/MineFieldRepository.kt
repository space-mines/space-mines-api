package com.twcrone.spacemines.game

import org.springframework.data.repository.CrudRepository

interface MineFieldRepository : CrudRepository<MineFieldEntity, Long>