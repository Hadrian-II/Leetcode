package leetcode

fun main() {
    println(fourSumCount(intArrayOf(1,2), intArrayOf(-2,-1), intArrayOf(-1,2), intArrayOf(0,2)))
    println(fourSumCount(intArrayOf(0), intArrayOf(0), intArrayOf(0), intArrayOf(0)))
}

fun fourSumCount(nums1: IntArray, nums2: IntArray, nums3: IntArray, nums4: IntArray): Int {
    val result = mutableMapOf<Int, Int>()
    for (num in nums1) {
        for (num2 in nums2) {
            val s = num + num2
            result[s] = (result[s] ?: 0) + 1
        }
    }

    var paths = 0

    for (num in nums3) {
        for (num2 in nums4) {
            val other = result[-(num + num2)]
            if (other != null) {
                paths += other
            }
        }
    }

    return paths
}