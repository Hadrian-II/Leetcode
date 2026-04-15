package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(xorAfterQueries(intArrayOf(1,1,1), readArrayOfArrays("[[0,2,1,4]]")))
    println(xorAfterQueries(intArrayOf(2,3,1,5,4), readArrayOfArrays("[[1,4,2,3],[0,2,1,2]]")))
    println(xorAfterQueries(intArrayOf(780), readArrayOfArrays("[[0,0,1,13],[0,0,1,17],[0,0,1,9],[0,0,1,18],[0,0,1,16],[0,0,1,6],[0,0,1,4],[0,0,1,11],[0,0,1,7],[0,0,1,18],[0,0,1,8],[0,0,1,15],[0,0,1,12]]")))
}

fun xorAfterQueries(nums: IntArray, queries: Array<IntArray>): Int {
    val divisor = 1000000007
    for (query in queries) {
        for (i in query[0]..query[1] step query[2]) {
            nums[i] = (nums[i].toLong() * query[3] % divisor).toInt()
        }
    }

    return nums.reduce { acc, i -> acc.xor(i) }
}