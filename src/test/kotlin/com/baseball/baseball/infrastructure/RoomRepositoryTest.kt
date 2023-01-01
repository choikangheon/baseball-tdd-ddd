package com.baseball.baseball.infrastructure

import com.baseball.baseball.domain.Room
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class RoomRepositoryTest {

    @Test
    fun `현재 생성된 룸의 개수를 갖고온다`() {
        //given
        val repository = RoomRepository()
        //when
        var initCnt = repository.count()
        repository.save(Room(1))
        val afterSave = repository.count()
        //then
        assertThat(initCnt).isEqualTo(0)
        assertThat(afterSave).isEqualTo(1)
    }

    @Test
    fun `룸 생성시 게임을 생성한다`() {
        //given
        val repository = RoomRepository()
        //when
        val room = Room(repository.count() + 1)
        //then
        assertThat(room.game).isNotNull
        assertThat(room.game.getAnswer()).isNotNull()

    }


}