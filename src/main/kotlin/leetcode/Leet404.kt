package leetcode

import helpers.TreeNode
import helpers.createNode
import helpers.treeFactory

fun main() {
    println(sumOfLeftLeaves(createNode(listOf(3,9,20,null,null,15,7))))
    println(sumOfLeftLeaves(createNode(listOf(1))))
    println(sumOfLeftLeaves(createNode(listOf(1,2,3,4,5))))
}

fun sumOfLeftLeaves(root: TreeNode?): Int {
    return leftSum(root!!, false)
}

fun leftSum(node: TreeNode, isLeft: Boolean): Int {
    return if (isLeft && node.left == null && node.right == null)  {
        node.`val`
    } else {
        (node.left?.let { leftSum(it, true) } ?: 0) + (node.right?.let { leftSum(it, false) } ?: 0)
    }
}

