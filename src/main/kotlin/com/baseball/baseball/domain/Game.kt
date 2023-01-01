package com.baseball.baseball.domain

import Answer

class Game(var answer: Answer = Answer()) {

    /*
    * 부생성자를 통해서  init 삭제해야함
    * */
    var chance: Int
    init {
        this.answer = answer
        this.chance = 10
    }

    fun getAnswer(): String {
        return this.answer.value
    }

    fun play(reqAnswer: String): GameResult {
        decreaseChance()
        val countStrike = answer.countStrike(reqAnswer)
        val countBall = answer.countBall(reqAnswer)
        return GameResult(countStrike, countBall, 3 - countStrike - countBall)
    }

    fun decreaseChance(){
        this.chance--
    }

}

data class GameResult(val strike: Int, val ball: Int, val out: Int)
data class GameHistory(val answer: String, val gameResult: GameResult)
enum class GameChance(i: Int) {
    MAX_CHANCE(10)
}