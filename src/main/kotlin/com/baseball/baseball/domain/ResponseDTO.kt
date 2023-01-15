package com.baseball.baseball.domain

data class ResponseDTO(val correct: Boolean, val remainingCount: Int, val strike: Int, val ball: Int, val out: Int)

