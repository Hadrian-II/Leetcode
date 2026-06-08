package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(preorderTraversal(createNode(listOf(1,null,2,3))))
    println(preorderTraversal(createNode(listOf(1,2,3,4,5,null,8,null,null,6,7,9))))
}

fun preorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun traverse(node: TreeNode) {
        result.add(node.`val`)
        node.left?.let { traverse(it) }
        node.right?.let { traverse(it) }
    }
    root?.let { traverse(it) }

    return result
}