package leetcode

fun main() {
    println(minOperations(intArrayOf(3,9,7), 5))
    println(minOperations(intArrayOf(4,1,3), 4))
    println(minOperations(intArrayOf(3,2), 6))
}

fun minOperations(nums: IntArray, k: Int): Int {
    return nums.sum() % k
}