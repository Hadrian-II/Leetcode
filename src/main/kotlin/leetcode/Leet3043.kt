package leetcode

import java.util.Stack
import kotlin.math.max

fun main() {
    println(Solution3043().longestCommonPrefix(intArrayOf(1,10,100), intArrayOf(1000)))
    println(Solution3043().longestCommonPrefix(intArrayOf(1,2,3), intArrayOf(4,4,4)))
}

class Solution3043 {
    class ShittyTrie() {
        val numMap = Array<ShittyTrie?>(10) { null }

        fun addNumber(digits: Stack<Int>) {
            val biggest = digits.pop()
            if (numMap[biggest] == null) {
                numMap[biggest] = ShittyTrie()
            }
            if (digits.isNotEmpty()) {
                numMap[biggest]!!.addNumber(digits)
            }
        }

        fun prefixLength(digits: Stack<Int>): Int {
            val biggest = digits.pop()
            return if (numMap[biggest] != null) {
                if (digits.isEmpty()) {
                    1
                } else {
                    1 + numMap[biggest]!!.prefixLength(digits)
                }
            } else {
                0
            }
        }
    }

    fun longestCommonPrefix(arr1: IntArray, arr2: IntArray): Int {
        val trie = ShittyTrie()
        for (number in arr1) {
            trie.addNumber(numberToDigitStack(number))
        }
        var maxPrefixLength = 0

        for (number in arr2) {
            maxPrefixLength = max(maxPrefixLength, trie.prefixLength(numberToDigitStack(number)))
        }

        return maxPrefixLength
    }

    fun numberToDigitStack(number: Int): Stack<Int> {
        var n = number
        val digits = Stack<Int>()

        while (n > 0) {
            digits.add(n % 10)
            n /= 10
        }

        return digits
    }
}