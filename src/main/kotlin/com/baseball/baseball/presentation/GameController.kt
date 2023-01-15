package com.baseball.baseball.presentation

import com.baseball.baseball.application.BaseballService
import com.baseball.baseball.domain.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/game")
class GameController(val service: BaseballService) {

    @PostMapping("/start")
    fun startGame(): Long {
        return service.createRoom()
    }

    @PostMapping("/{roomId}/answer")
    fun playGame(@PathVariable roomId:Long, @RequestBody playGameDTO :PlayGameDTO): ResponseDTO {
    return service.play(roomId,playGameDTO.answer)
    }

    @PostMapping("/{roomId}/history")
    fun playGame(@PathVariable roomId:Long): MutableList<GameHistory> {
     return service.getHistory(roomId)
    }

    @GetMapping("/{roomId}")
    fun getGameResult(@PathVariable roomId:Long): GameResultDTO {
    return service.getResult(roomId)
    }
}