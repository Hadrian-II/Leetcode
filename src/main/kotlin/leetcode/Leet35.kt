package leetcode

fun main() {
    println(searchInsert(intArrayOf(1,3,5,6), 5))
    println(searchInsert(intArrayOf(1,3,5,6), 2))
    println(searchInsert(intArrayOf(1,3,5,6), 7))
    println(searchInsert(intArrayOf(1,3,5,6), 0))
}

fun searchInsert(nums: IntArray, target: Int): Int {
    var low = 0
    var result = 0
    var high = nums.lastIndex

    while (low <= high) {
        result = (low + high) / 2
        if (nums[result] == target) {
            return result
        } else if (nums[result] > target) {
            high = result - 1
        } else {
            low = result + 1
        }
    }

    return if(nums[result] > target) result else result + 1
}