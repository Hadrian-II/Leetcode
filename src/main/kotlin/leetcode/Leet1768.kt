package leetcode

import java.util.LinkedList
import kotlin.math.max

fun main() {
    println(mergeAlternately("abc", "pqr")) // apbqcr
    println(mergeAlternately("ab","pqrs"))  // apbqrs
    println(mergeAlternately("abcd", "pq")) // apbqcd
}

fun mergeAlternately(word1: String, word2: String): String {
    var result = ""
    var w1active = true
    var w2active = true
    for (i in 0..<max(word1.length, word2.length)) {
        if (w1active) {
            if (word1.length > i) {
                result += word1[i]
            } else {
                w1active = false
            }
        }
        if (w2active) {
            if (word2.length > i) {
                result += word2[i]
            } else {
                w2active = false
            }
        }
    }
    return result
}