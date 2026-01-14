package leetcode

fun main() {
    println(singleNumber(intArrayOf(2,2,1)))
    println(singleNumber(intArrayOf(4,1,2,1,2)))
    println(singleNumber(intArrayOf(1)))
}

fun singleNumber(nums: IntArray): Int {
    var result = 0
    // 0 0 -> 0
    // 0 1 -> 1
    // 1 0 -> 1
    // 1 1 -> 0
    for (num in nums) {
        result = result.xor(num)
    }
    return result
}