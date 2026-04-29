package leetcode

fun main() {
    println(Solution81().search(intArrayOf(2,5,6,0,0,1,2), 0))
    println(Solution81().search(intArrayOf(2,5,6,7,8,9,0,0,1,2), 0))
    println(Solution81().search(intArrayOf(2,5,6,0,0,1,2), 3))
    println(Solution81().search(intArrayOf(1,0,1,1,1), 0))
    println(Solution81().search(intArrayOf(2,2,2,3,2,2,2), 3))
    println(Solution81().search(intArrayOf(3,1,1), 3))
    println(Solution81().search(intArrayOf(4,5,6,7,0,1,2), 0))
}

class Solution81 {
    fun search(nums: IntArray, target: Int): Boolean {
        var high = nums.lastIndex
        var low = 0
        var pivot = 0
        val danger = nums.first() == nums.last()
        while (low <= high) {
            pivot = (high + low) / 2
            if ((pivot != 0 && nums[pivot - 1] > nums[pivot])) {
                break
            } else if (danger && nums[pivot] == nums.first()) {
                return nums.any { it == target }
            } else if (nums[pivot] > nums.last()) {
                low = pivot + 1
            } else {
                high = pivot - 1
            }
        }

        low = 0
        high = nums.lastIndex

        while (low <= high) {
            val mid = (high + low) / 2
            val pivoted = (mid  + pivot) % nums.size
            if (nums[pivoted] == target) {
                return true
            } else if (nums[pivoted] < target) {
                low = mid + 1
            } else {
                high = mid - 1
            }
        }

        return false
    }
}