package leetcode

import kotlin.math.abs

fun main() {
    println(checkValidString("()"))
    println(checkValidString("(*)"))
    println(checkValidString("(*)"))
    println(checkValidString("("))
    println(checkValidString("(((((*(()((((*((**(((()()*)()()()*((((**)())*)*)))))))(())(()))())((*()()(((()((()*(())*(()**)()(())"))
}

fun checkValidString(s: String): Boolean {
    var maxOpen = 0
    var minOpen = 0

    for (c in s) {
        when (c) {
            '(' -> {
                maxOpen++
                minOpen++
            }
            '*' -> {
                maxOpen++
                if (minOpen > 0) {
                    minOpen--
                }
            }
            ')' -> {
                if (maxOpen < 1) {
                    return false
                }
                maxOpen--
                if (minOpen > 0) {
                    minOpen--
                }
            }
        }
    }
    return minOpen <= 0 && maxOpen >= 0
}