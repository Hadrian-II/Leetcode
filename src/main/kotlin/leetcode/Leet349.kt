package leetcode

fun intersection(nums1: IntArray, nums2: IntArray): IntArray {
    return nums1.intersect(nums2.toSet()).toIntArray()
}