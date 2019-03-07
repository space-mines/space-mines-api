package com.example.game

import org.springframework.data.repository.CrudRepository

interface GameRepository : CrudRepository<GameEntity, Long>