package leetcode

fun main() {
    println(findPeakElement(intArrayOf(1,2,3,1)))
    println(findPeakElement(intArrayOf(1,2,1,3,5,6,4)))
}

fun findPeakElement(nums: IntArray): Int {
    var low = 0
    var high = nums.lastIndex
    while (low <= high) {
        val mid = (low + high) / 2
        val hasLeft = mid > 0
        val left = if (hasLeft) nums[mid -1] else Int.MIN_VALUE
        val hasRight = mid < nums.lastIndex
        val right = if (hasRight) nums[mid + 1] else Int.MIN_VALUE
        if ((!hasLeft || nums[mid] > left) && (!hasRight || nums[mid] > right)) {
            return mid
        } else if (left > right) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return 0
}