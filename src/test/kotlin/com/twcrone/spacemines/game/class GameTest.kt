package com.twcrone.spacemines.game

import org.junit.Test

class GameTest {

    @Test
    fun `create a game from mine field`() {
        val mineFieldEntity = MineFieldEntity()
        val game = GameEntity(mineFieldEntity)
    }
}