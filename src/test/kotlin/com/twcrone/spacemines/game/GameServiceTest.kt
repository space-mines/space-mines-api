package com.twcrone.spacemines.game

import org.assertj.core.api.Assertions.*
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class GameServiceTest {

    @Autowired
    private lateinit var service: GameService

    @Test
    fun testCreate() {
        val mineField = MineFieldEntity()
        val game = service.create(mineField)

        assertThat(game).isNotNull()
        assertThat(game.mineField).isEqualTo(mineField)
        assertThat(game.minePods.size).isEqualTo(Math.pow(mineField.size.toDouble(), mineField.size.toDouble()).toInt())
    }

}