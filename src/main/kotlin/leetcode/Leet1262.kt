package leetcode

import kotlin.math.min

fun main() {
    println(maxSumDivThree(intArrayOf(3, 6, 5, 1, 8)))
    println(maxSumDivThree(intArrayOf(4)))
    println(maxSumDivThree(intArrayOf(1, 2, 3, 4, 4)))
}


fun maxSumDivThree(nums: IntArray): Int {
    nums.sort()
    val sum = nums.sum()
    val mod = sum % 3;
    if (mod != 0) {
        val plus = ArrayList<Int>()
        val minus = ArrayList<Int>()
        for (num in nums) {
            when (num % 3) {
                1 -> if (plus.size < mod) plus.add(num)
                2 -> if (minus.size < 3 - mod) minus.add(num)
            }
            if (plus.size == mod && minus.size == 3 - mod) {
                break
            }
        }
        val minsum = if (minus.size == 3 - mod) minus.sum() else Int.MAX_VALUE
        val plussum = if (plus.size == mod) plus.sum() else Int.MAX_VALUE
        if (plussum == Int.MAX_VALUE && minsum == Int.MAX_VALUE) {
            return 0
        }
        return sum - min(plussum, minsum)
    }
    return sum
}