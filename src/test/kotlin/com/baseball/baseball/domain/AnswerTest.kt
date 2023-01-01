package com.baseball.baseball.domain

import Answer
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test


class AnswerTest {
    val createAnswer = Answer()

    @Test
    fun `정답을 랜덤으로 생성한다`() {
        val createAnswer2 = Answer().value.toInt()
        val value = createAnswer.value.toInt()

        println(createAnswer2)
        println(value)
        assertThat(value).isLessThan(999)
        assertThat(value).isGreaterThan(1)
        assertThat(createAnswer2).isLessThan(999)
        assertThat(createAnswer2).isGreaterThan(1)
    }

    @Test
    fun `정답에 스트라이크를 계산한다`() {
        assertThat(createAnswer.countStrike("123")).isEqualTo(3)
        assertThat(createAnswer.countStrike("213")).isEqualTo(1)
        assertThat(createAnswer.countStrike("124")).isEqualTo(2)
    }

    @Test
    fun `정답에 볼을 계산한다`() {
        assertThat(createAnswer.countBall("321")).isEqualTo(2)
        assertThat(createAnswer.countBall("214")).isEqualTo(2)
        assertThat(createAnswer.countBall("356")).isEqualTo(1)
    }



}

