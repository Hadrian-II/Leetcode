package leetcode

fun main() {
    println(maxTotalValue(intArrayOf(1,3,2),2))
    println(maxTotalValue(intArrayOf(4,2,5,1),3))
}

fun maxTotalValue(nums: IntArray, k: Int): Long {
    return (nums.max() - nums.min()) * k.toLong()
}