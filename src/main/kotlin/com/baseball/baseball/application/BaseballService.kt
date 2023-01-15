package com.baseball.baseball.application

import com.baseball.baseball.domain.*
import com.baseball.baseball.infrastructure.RoomRepository
import org.springframework.stereotype.Service

@Service
class BaseballService {
    val repository = RoomRepository()


    fun createRoom(): Long {
        val room = Room(repository.count() + 1)
        return repository.save(room)
    }

    //data class GameResult(val strike: Int, val ball: Int, val out: Int)
    fun play(roomId: Long, reqAnswer: String): ResponseDTO {
        val room = repository.findByRoomId(roomId)
        val game = room.game
        val gameResult = game.play(reqAnswer)
        room.addHistoryOfGame(reqAnswer, gameResult)

        return ResponseDTO(
                reqAnswer == game.getAnswer(),
                game.chance,
                gameResult.strike,
                gameResult.ball,
                gameResult.out
        )
    }

    fun getHistory(roomId: Long): MutableList<GameHistory> {
        val room = repository.findByRoomId(roomId)
        return room.showHistoryOfGame()
    }

    fun getResult(roomId: Long): GameResultDTO {
        val room = repository.findByRoomId(roomId)
        val game = room.game
        return GameResultDTO(
                game.success,
                game.chance,
                10 - game.chance
        )
    }

}