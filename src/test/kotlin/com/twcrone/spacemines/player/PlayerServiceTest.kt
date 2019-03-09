package com.twcrone.spacemines.player

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class PlayerServiceTest {

    @Autowired
    private lateinit var service: PlayerService

    @Test
    fun testGetPlayer() {
        val player = service.get(1)

        assert(player.id == 1L)
    }

}