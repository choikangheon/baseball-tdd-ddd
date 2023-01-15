import java.security.SecureRandom

class Answer {
    val value: String

    init {
        val secureRandom = SecureRandom()
        value = String.format("%03d", secureRandom.nextInt(999))
    }

    fun countStrike(reqAnswer: String): Int {
        var strike = 0
        for (i in 0..2) {
            if (reqAnswer[i].equals(value[i])) {
                strike++
            }
        }

        return strike
    }

    fun countBall(reqAnswer: String): Int {
        var ball = 0
        if (value[0] == reqAnswer[1]) ball++
        if (value[0] == reqAnswer[2]) ball++
        if (value[1] == reqAnswer[0]) ball++
        if (value[1] == reqAnswer[2]) ball++
        if (value[2] == reqAnswer[0]) ball++
        if (value[2] == reqAnswer[1]) ball++
        return ball
    }
}
