package leetcode

import helpers.TreeNode
import kotlin.time.measureTime

fun main() {
    println(Solution96().numTrees(3))
    println(Solution96().numTrees(1))
    println(measureTime {
        println(Solution96().numTrees(3000))
    })
}

class Solution96 {
    val memo = HashMap<Int, Int>()

    fun numTrees(n: Int): Int {
        return memo.getOrPut(n) {
            if (n <= 1) {
                1
            } else {
                var result = 0

                for (i in 0..<n) {
                    result += numTrees(i) * numTrees(n - 1 - i)
                }

                result
            }
        }
    }
}