package leetcode

fun main() {
    println(majorityElement(intArrayOf(3,2,3)))
    println(majorityElement(intArrayOf(2,2,1,1,1,2,2)))
}

fun majorityElement(nums: IntArray): Int {
    val nMap = HashMap<Int, Int>()

    for (num in nums) {
        nMap[num] = (nMap[num] ?: 0) + 1
    }

    val mid = nums.size / 2
    for (entry in nMap.entries) {
        if (entry.value > mid) {
            return entry.key
        }
    }
    return -1
}