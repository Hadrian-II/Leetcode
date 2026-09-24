package leetcode

fun main() {
    println(smallestIndex(intArrayOf(1,3,2)))
    println(smallestIndex(intArrayOf(1,10,11)))
    println(smallestIndex(intArrayOf(1,2,3)))
}

fun smallestIndex(nums: IntArray): Int {
    for (i in nums.indices) {
        var num = nums[i]
        var result = 0
        while (num > 9) {
            result += num % 10
            num /= 10
        }
        result += num
        if (result == i) {
            return i
        }
    }
    return -1
}