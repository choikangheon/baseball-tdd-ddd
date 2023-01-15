package com.baseball.baseball.domain

class Room(var roomId: Long, var game: Game = Game()) {


    private val historyOfGame = mutableListOf<GameHistory>()

    fun addHistoryOfGame(reqAnswer: String, gameResult: GameResult) {
        historyOfGame.add(GameHistory(reqAnswer, gameResult))
    }

    fun showHistoryOfGame(): MutableList<GameHistory> {
        return historyOfGame
    }
}




