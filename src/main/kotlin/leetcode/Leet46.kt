package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution45().permute(intArrayOf(1,2,3)))
    println(Solution45().permute(intArrayOf(0,1)))
    println(Solution45().permute(intArrayOf(1)))
    println(measureTime { Solution45().permute(intArrayOf(1,2,3,4,5,6,7))})
}

class Solution45 {
    fun permute(nums: IntArray): List<List<Int>> {
        return permute(nums.toSet())
    }

    fun permute(nums: Set<Int>): List<List<Int>> {
        return if (nums.size == 1) {
            listOf(listOf(nums.first()))
        } else {
            nums.flatMap { num -> permute(nums - setOf(num)).map { it + listOf(num) } }
        }
    }
}