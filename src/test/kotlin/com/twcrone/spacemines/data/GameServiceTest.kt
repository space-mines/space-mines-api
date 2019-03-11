package com.twcrone.spacemines.data

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

    @Autowired
    private lateinit var mineFieldRepository: MineFieldRepository

    @Test
    fun `get game for player initializes first game`() {
        val game = service.findOrCreateGameFor(1)

        assertThat(game).isNotNull()
//        assertThat(game.mineField).isEqualTo(mineField)
//        assertThat(game.pods.size).isEqualTo(Math.pow(mineField.size.toDouble(), mineField.size.toDouble()).toInt())
//        assertThat(game.id).isGreaterThan(0)
    }

}