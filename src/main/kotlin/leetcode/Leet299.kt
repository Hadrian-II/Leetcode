package leetcode

import kotlin.math.min

fun main() {
    println(getHint("1807", "7810"))
    println(getHint("1123", "0111"))
}

fun getHint(secret: String, guess: String): String {
    var bulls = 0
    val secretDist = IntArray(10)
    val guessDist = IntArray(10)
    for (i in secret.indices) {
        val sc = secret[i] - '0'
        val gc = guess[i] - '0'
        if (sc == gc) {
            bulls++
        } else {
            secretDist[sc]++
            guessDist[gc]++
        }
    }
    var cows = 0
    for (i in 0..9) {
        cows += min(secretDist[i], guessDist[i])
    }
    return "${bulls}A${cows}B"
}