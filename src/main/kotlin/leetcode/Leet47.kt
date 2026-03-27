package leetcode

import kotlin.time.measureTime

fun main() {
    println(Solution47().permuteUnique(intArrayOf(1,1,2)))
    println(Solution47().permuteUnique(intArrayOf(1,2,3)))
    println(measureTime { Solution47().permuteUnique(intArrayOf(1,2,3,4,5,6,7,8,9,10)) })
    println(measureTime { Solution47().permuteUnique(intArrayOf(1,1,1,1,1,2,2,2,2,2)) })
}

class Solution47 {
    fun permuteUnique(nums: IntArray): List<List<Int>> {
        return permuteUnique(nums.toList().groupingBy { it }.eachCount())
    }

    fun permuteUnique(nums: Map<Int, Int>): List<List<Int>> {
        if (nums.keys.size == 1) {
            val nr = nums.keys.first()
            return listOf(List(nums[nr]!!) { nr })
        } else {
            val result = mutableListOf<List<Int>>()

            for (key in nums.keys) {
                val newNums = nums.toMutableMap()
                if (newNums[key] == 1) {
                    newNums.remove(key)
                } else {
                    newNums[key] = newNums[key]!! - 1
                }
                result.addAll(permuteUnique(newNums).map { it + listOf(key) })
            }

            return result
        }
    }
}