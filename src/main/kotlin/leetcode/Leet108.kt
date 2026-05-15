package leetcode

import helpers.TreeNode

fun main() {
    val t1 = Solution108().sortedArrayToBST(intArrayOf(-10,-3,0,5,9))
    val t2 = Solution108().sortedArrayToBST(intArrayOf(1,3))
    val blah = 7
}

class Solution108 {
    fun sortedArrayToBST(nums: IntArray): TreeNode? {
        return createTree(0, nums.lastIndex, nums)
    }

    fun createTree(start: Int, end: Int, nums: IntArray): TreeNode {
        val mid = (start + end) / 2
        val node = TreeNode(nums[mid])

        if (mid > start) {
            node.left = createTree(start, mid - 1, nums)
        }
        if (mid < end) {
            node.right = createTree(mid + 1, end, nums)
        }

        return node
    }
}