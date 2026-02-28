package leetcode

fun main() {
    println(SolutionQ4().search(intArrayOf(4,5,6,7,0,1,2), 0)) // 4
    println(SolutionQ4().search(intArrayOf(4,5,6,7,0,1,2), 3)) // -1
    println(SolutionQ4().search(intArrayOf(1), 0))             // -1
    println(SolutionQ4().search(intArrayOf(1,3), 0))           // -1
    println(SolutionQ4().search(intArrayOf(3,1), 1))           // 1
    println(SolutionQ4().search(intArrayOf(1,3,5), 0))         // -1
    println(SolutionQ4().search(intArrayOf(8,9,2,3,4), 9))     // 1
}

class SolutionQ4() {
    fun search(nums: IntArray, target: Int): Int {
        if (nums.size == 1) {
            return if (nums[0] == target) 0 else -1
        }

        var offset = 0
        var left = 0
        var right = nums.size - 1
        while (left <= right) {
            offset = (left + right) / 2
            if (nums[(offset + 1) % nums.size] < nums[offset]) {
                offset++
                break
            } else if (nums[offset + 1] > nums[0]) {
                left = offset + 1
            } else {
                right = offset - 1
            }
        }

        left = 0
        right = nums.size - 1
        while (left <= right) {
            val mid = (left + right) / 2
            val offsetmid = (mid + offset) % nums.size
            if (nums[offsetmid] == target) {
                return offsetmid
            } else if (nums[offsetmid] > target) {
                right = mid - 1
            } else {
                left = mid + 1
            }
        }
        return -1
    }
}