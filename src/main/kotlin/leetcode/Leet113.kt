package leetcode

import helpers.TreeNode
import helpers.createNode
import java.util.Stack

fun main() {
    Solution113().pathSum(createNode(listOf(5,4,8,11,null,13,4,7,2,null,null,5,1)), 22).forEach { println(it)}
    Solution113().pathSum(createNode(listOf(1,2,3)), 5).forEach { println(it)}
    Solution113().pathSum(createNode(listOf(1,2)), 0).forEach { println(it)}
}

class Solution113 {
    val results = mutableListOf<List<Int>>()

    fun pathSum(root: TreeNode?, targetSum: Int): List<List<Int>> {
        if (root != null) {
            findPathSum(root, 0, targetSum, Stack())
        }

        return results
    }

    fun findPathSum(node: TreeNode, currentSum: Int, targetSum: Int, previousValues: Stack<Int>) {
        val newSum = currentSum + node.`val`

        if (node.left == null && node.right == null && newSum == targetSum) {
            results.add(previousValues + listOf(node.`val`))
        } else {
            if (node.left != null) {
                if (node.right != null) {
                    val copyOfPrevious: Stack<Int> = previousValues.clone() as Stack<Int>
                    copyOfPrevious.add(node.`val`)
                    findPathSum(node.right!!, newSum, targetSum, copyOfPrevious)
                }

                previousValues.add(node.`val`)
                findPathSum(node.left!!, newSum, targetSum, previousValues)
            } else if (node.right != null) {
                previousValues.add(node.`val`)
                findPathSum(node.right!!, newSum, targetSum, previousValues)
            }
        }
    }
}