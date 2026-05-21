package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(hasPathSum(createNode(listOf(5,4,8,11,null,13,4,7,2,null,null,null,1)), 22))
    println(hasPathSum(createNode(listOf(1,2,3)), 5))
}

fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
    if (root == null) {
        return false
    }

    return findPathSum(root, 0, targetSum)
}

fun findPathSum(node: TreeNode, currentSum: Int, targetSum: Int): Boolean {
    val newSum = node.`val` + currentSum
    if (node.left == null && node.right == null) {
        return newSum == targetSum
    }

    return node.left?.let { findPathSum(it, newSum, targetSum)} ?: false ||
           node.right?.let { findPathSum(it, newSum, targetSum)} ?: false
}