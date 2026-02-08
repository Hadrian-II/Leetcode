package leetcode

import kotlin.math.ceil

fun main() {
    println(repeatedStringMatch("abcd", "cdabcdab"))
    println(repeatedStringMatch("a", "aa"))
    println(repeatedStringMatch("abc", "cabcabca"))
}

fun repeatedStringMatch(a: String, b: String): Int {
    val divided = ceil(b.length / a.length.toDouble()).toInt()
    return if (a.repeat(divided).contains(b)) {
        divided
    } else if (a.repeat(divided + 1).contains(b)) {
        divided + 1
    } else {
        -1
    }
}