package com.baseball.baseball.domain

import Answer

class Game(var answer: Answer = Answer()) {

    /*
    * 부생성자를 통해서  init 삭제해야함
    * */
    var success: Boolean
    var chance: Int

    init {
        this.success = false
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

        if (countStrike == 3) {
            updateSuccess(true)
        }

        return GameResult(countStrike, countBall, 3 - countStrike - countBall)
    }

    private fun decreaseChance() {
        this.chance--
    }

    private fun updateSuccess(flag: Boolean) {
        this.success = flag
    }

}

data class GameResult(val strike: Int, val ball: Int, val out: Int)
data class GameHistory(val answer: String, val gameResult: GameResult)
enum class GameChance(i: Int) {
    MAX_CHANCE(10)
}