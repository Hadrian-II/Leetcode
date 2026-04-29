package leetcode

import helpers.TreeNode
import kotlin.time.measureTime

fun main() {
    var tree = Solution95().generateTrees(3)
    tree = Solution95().generateTrees(1)
    println(measureTime {
        tree = Solution95().generateTrees(8)
    })
}

class Solution95 {
    fun generateTrees(n: Int): List<TreeNode?> {
        return generateTrees((1..n).toList())
    }

    fun generateTrees(nums: List<Int>): List<TreeNode?> {
        if (nums.size == 1) {
            return listOf(TreeNode(nums.first()))
        } else {
            val result = mutableListOf<TreeNode>()

            for (i in nums.indices) {
                val lefts = if (i > 0) {
                   generateTrees(nums.subList(0, i))
                } else {
                    listOf(null)
                }

                val rights = if (i < nums.lastIndex) {
                    generateTrees(nums.subList(i + 1, nums.size))
                } else {
                    listOf(null)
                }

                for (left in lefts) {
                    for (right in rights) {
                        val node = TreeNode(nums[i])
                        node.left = left
                        node.right = right
                        result.add(node)
                    }
                }

            }

            return result
        }
    }
}