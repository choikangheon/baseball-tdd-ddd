package com.baseball.baseball.application

import com.baseball.baseball.domain.Room
import com.baseball.baseball.infrastructure.RoomRepository
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

internal class BaseballServiceTest {


    @Test
    fun `야구게임 서비스 테스트`() {
        //given
        val service = BaseballService()
        val repository = RoomRepository()
        //when
        val roomId = service.createRoom()
        service.play(roomId,"123")
    }
}