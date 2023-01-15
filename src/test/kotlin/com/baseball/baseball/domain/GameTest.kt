package com.baseball.baseball.domain

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class GameTest {
    val game = Game()

    @Test
    fun `게임 시작 테스트`() {
        val play1 = game.play("123");
        val play2 = game.play("453");

        assertThat(play1.strike).isEqualTo(3)
        assertThat(play1.ball).isEqualTo(0)
        assertThat(play1.out).isEqualTo(0)
        assertThat(play2.strike).isEqualTo(1)
        assertThat(play2.ball).isEqualTo(0)
        assertThat(play2.out).isEqualTo(2)

    }
}