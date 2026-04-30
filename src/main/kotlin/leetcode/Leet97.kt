package leetcode

import java.util.Stack
import kotlin.time.measureTime

fun main() {
//    println(Solution97().isInterleave("aabcc", "dbbca", "aadbbcbcac"))
//    println(Solution97().isInterleave("aabcc", "dbbca", "aadbbbaccc"))
//    println(Solution97().isInterleave("", "", ""))
    println(measureTime {
    println(Solution97().isInterleave(
        "abababababababababababababababababababababababababababababababababababababababababababababababababbb",
        "babababababababababababababababababababababababababababababababababababababababababababababababaaaba",
        "abababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababababbb"))})
}

class Solution97 {
    fun isInterleave(s1: String, s2: String, s3: String): Boolean {
        if (s1.length + s2.length != s3.length) {
            return false
        }
        if (s1.isEmpty()) {
            return s2 == s3
        }
        if (s2.isEmpty()) {
            return s1 == s3
        }
        if (s3.isEmpty()) {
            return true
        }

        var p1 = 0
        var p2 = 0
        var p3 = 0
        val splitStack = Stack<Triple<Int,Int,Int>>()

        while (p3 < s3.length) {
            if (p1 < s1.length && s1[p1] == s3[p3]) {
                if (p2 < s2.length && s2[p2] == s3[p3]) {
                    splitStack.push(Triple(p1, p2, p3))
                }
                p1++
                p3++
            } else if (p2 < s2.length && s2[p2] == s3[p3]) {
                p2++
                p3++
            } else if (splitStack.isNotEmpty()) {
                val reset = splitStack.pop()
                p1 = reset.first
                p2 = reset.second
                p3 = reset.third
                p2++
                p3++
            } else {
                return false
            }
        }

        return true
    }
}