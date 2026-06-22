package leetcode

fun main() {
    println(Solution229().majorityElement(intArrayOf(3,2,3)))
    println(Solution229().majorityElement(intArrayOf(1)))
    println(Solution229().majorityElement(intArrayOf(1,2)))
}

class Solution229 {
    fun majorityElement(nums: IntArray): List<Int> {
        val map = mutableMapOf<Int, Int>()

        for (num in nums) {
            map[num] = (map[num] ?: 0) + 1
        }

        val threshold =  nums.size / 3
        return map.filter { it.value > threshold }.map { it.key }
    }
}