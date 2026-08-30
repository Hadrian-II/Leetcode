package leetcode

fun main() {
    println(minimumDeletions(intArrayOf(2,10,7,5,4,1,8,6)))
    println(minimumDeletions(intArrayOf(0,-4,19,1,8,-2,-3,5)))
    println(minimumDeletions(intArrayOf(101)))
}

fun minimumDeletions(nums: IntArray): Int {
    if (nums.size < 3) {
        return nums.size
    }
    var min = Int.MAX_VALUE
    var loc1 = 0
    var max = Int.MIN_VALUE
    var loc2 = 0
    for (i in nums.indices) {
        val num = nums[i]
        if (num > max) {
            max = num
            loc2 = i
        }
        if (num < min) {
            min = num
            loc1 = i
        }
    }
    if (loc1 > loc2) {
        val buf = loc2
        loc2 = loc1
        loc1 = buf
    }

    val start = loc1 + 1
    val mid = loc2 - loc1
    val end = nums.size - loc2
    return if (start < mid) {
        if (mid < end) {
            start + mid
        } else {
            start + end
        }
    } else {
        if (start < end) {
            start + mid
        } else {
            mid + end
        }
    }
}