package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(minBitwiseArray(listOf(2,3,5,7)))
    printIntArray(minBitwiseArray(listOf(11,13,31)))
}

fun minBitwiseArray(nums: List<Int>): IntArray {
    val answer = IntArray(nums.size)
    val amap = (1..nums.max()).map { it.or(it + 1) to it }.fold(mutableMapOf<Int,Int>()) {
        acc, pair ->
        if (pair.first !in acc || (pair.first in acc && acc[pair.first]!! > pair.second)) {
            acc[pair.first] = pair.second
        }
        acc
    }
    for (i in nums.indices) {
        answer[i] = amap[nums[i]] ?: -1
    }
    return answer
}