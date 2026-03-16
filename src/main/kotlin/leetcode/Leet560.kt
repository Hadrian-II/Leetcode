package leetcode

fun main() {
    println(subarraySum(intArrayOf(1,1,1), 2))
    println(subarraySum(intArrayOf(1,2,3), 3))
    println(subarraySum(intArrayOf(1), 0))
    println(subarraySum(intArrayOf(-1,-1,1), 0))
}

fun subarraySum(nums: IntArray, k: Int): Int {
    val smap = mutableMapOf<Int, Int>()
    var sum = 0
    var result = 0
    for (num in nums) {
        sum += num
        if (sum == k) {
            result++
        }
        result += smap[sum - k] ?: 0
        smap[sum] = (smap[sum] ?: 0) + 1
    }
    return result
}