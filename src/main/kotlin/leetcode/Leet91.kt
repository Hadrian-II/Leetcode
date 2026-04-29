package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution91().numDecodings("11106"))
    println(Solution91().numDecodings("226"))
    println(Solution91().numDecodings("06"))
    println(measureTime {
        println(Solution91().numDecodings("111111111111111111111111111111111111111111111"))
    })
    println(Solution91().numDecodings("230"))
    println(Solution91().numDecodings("10"))
    println(Solution91().numDecodings("2839"))
    println(Solution91().numDecodings("2101"))
    println(Solution91().numDecodings("1201234"))
}

class Solution91 {
    val memo = HashMap<String, Int>()
    val oneToSix = listOf('1','2','3','4','5','6')
    val zeroToSix = listOf('0', '1','2','3','4','5','6')

    fun numDecodings(s: String): Int {
        return memo.getOrPut(s) {
            if (s.isEmpty() || s.first() == '0') {
                0
            } else if (s.length == 1) {
                1
            } else if (s.length == 2) {
                if (s[0] == '1') {
                    if (s[1] != '0') 2 else 1
                } else if(s[0] == '2') {
                    if (s[1] in oneToSix) 2 else 1
                } else if (s[1] != '0'){
                    1
                } else {
                    0
                }
            } else {
                var sum = numDecodings(s.substring(1))
                if (s.first() == '1' || (s.first() == '2' && s[1] in zeroToSix)) {
                    sum += numDecodings(s.substring(2))
                }
                sum
            }
        }
    }
}