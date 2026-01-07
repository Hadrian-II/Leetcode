package leetcode

import kotlin.math.min

fun main() {
    println(gcdOfStrings("ABCABC", "ABC"))  // ABC
    println(gcdOfStrings("ABABAB", "ABAB")) // AB
    println(gcdOfStrings("LEET", "CODE"))   // ""
}

fun gcdOfStrings(str1: String, str2: String): String {
    val maxPossible = min(str1.length, str2.length)
    for (len in (1..maxPossible).reversed()) {
        if (str1.length % len == 0 && str2.length % len == 0) {
            val possibleDivider = str1.take(len)
            if (checkDivides(possibleDivider, str1) && checkDivides(possibleDivider, str2)) {
                return possibleDivider
            }
        }
    }
    return ""
}

fun checkDivides(possibleDivider: String, toCheck: String): Boolean {
    for (i in 0..<(toCheck.length / possibleDivider.length)) {
        val start = i * possibleDivider.length
        if (toCheck.substring(start, start + possibleDivider.length) != possibleDivider) {
            return false
        }
    }
    return true
}