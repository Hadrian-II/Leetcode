package leetcode

fun main() {
    println(Solution377().combinationSum4(intArrayOf(1,2,3), 4))
    println(Solution377().combinationSum4(intArrayOf(9), 3))
}

class Solution377 {
    lateinit var nums: List<Int>
    val memo = mutableMapOf<Int, Int>()

    fun combinationSum4(nums: IntArray, target: Int): Int {
        this.nums = nums.sorted()

        return combinations(target)
    }

    fun combinations(target: Int): Int {
        return memo.getOrPut(target) {
            var sum = 0
            for (num in nums) {
                if (num > target) {
                    break
                } else if (num == target) {
                    sum++
                } else {
                    sum += combinations(target - num)
                }
            }
            sum
        }
    }
}