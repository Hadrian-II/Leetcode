package leetcode

fun main() {
    println(findMin(intArrayOf(3,4,5,1,2)))
    println(findMin(intArrayOf(4,5,6,7,0,1,2)))
    println(findMin(intArrayOf(11,13,15,17)))
    println(findMin(intArrayOf(2, 1)))
}

fun findMin(nums: IntArray): Int {
    var low = 0
    var high = nums.lastIndex
    var mid = 0
    var minmid = 0
    var min = Int.MAX_VALUE

    if (nums.last() > nums.first()) {
        return nums.first()
    }

    while (low <= high) {
        mid = (high + low) / 2
        val midval = nums[mid]
        if (midval < min) {
            minmid = mid
            min = midval
        }
        if (mid == 0 || midval > nums.first()) {
            low = mid + 1
        } else {
            high = mid - 1
        }
    }
    return nums[minmid]
}