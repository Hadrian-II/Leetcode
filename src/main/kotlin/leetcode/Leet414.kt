package leetcode

import java.util.PriorityQueue

fun main() {
    println(thirdMax(intArrayOf(3,2,1)))
    println(thirdMax(intArrayOf(1,2)))
    println(thirdMax(intArrayOf(2,2,3,1)))
    println(thirdMax(intArrayOf(1,2,-2147483648)))
}

fun thirdMax(nums: IntArray): Int {
    var first: Int? = null
    var second: Int? = null
    var third: Int? = null

    for (num in nums) {
        if (num == first || num == second || num == third) {
            continue
        } else if (first == null || num > first) {
            third = second
            second = first
            first = num
        } else if (second == null || num > second) {
            third = second
            second = num
        } else if (third == null || num > third) {
            third = num
        }
    }

    return third ?: first!!
}