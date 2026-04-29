package leetcode

import helpers.printIntArray

fun main() {
    val i1 = intArrayOf(1,2,3,0,0,0)
    merge(i1, 3, intArrayOf(2,5,6),3)
    printIntArray(i1)

    merge(intArrayOf(1), 1, intArrayOf(), 0)
}

fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int) {
    var ptr1 = 0
    var ptr2 = 0
    var writePtr = 0
    val n1 = nums1.copyOf()

    while (ptr1  < m || ptr2 < n) {
        val v1 = if(ptr1 < m) {
            n1[ptr1]
        } else {
            Int.MAX_VALUE
        }

        val v2 = if(ptr2 < nums2.size) {
            nums2[ptr2]
        } else {
            Int.MAX_VALUE
        }

        nums1[writePtr++] = if (v1 < v2) {
             n1[ptr1++]
        } else {
            nums2[ptr2++]
        }
    }
}