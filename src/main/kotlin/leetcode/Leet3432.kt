package leetcode

fun main() {
    println(countPartitions(intArrayOf(10,10,3,7,6)))
    println(countPartitions(intArrayOf(1,2,2)))
    println(countPartitions(intArrayOf(2,4,6,8)))
}

fun countPartitions(nums: IntArray): Int {
    return if (nums.sum() % 2 == 0) nums.size - 1 else 0
}