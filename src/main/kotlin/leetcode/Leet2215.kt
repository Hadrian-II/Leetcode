package leetcode

fun main() {
    println(findDifference(intArrayOf(1,2,3), intArrayOf(2,4,6)))
    println(findDifference(intArrayOf(1,2,3,3), intArrayOf(1,1,2,2)))
}

fun findDifference(nums1: IntArray, nums2: IntArray): List<List<Int>> {
    val numsOf1 = nums1.toSet()
    val numsOf2 = nums2.toSet()
    return listOf((numsOf1 - numsOf2).toList(), (numsOf2 - numsOf1).toList())
}