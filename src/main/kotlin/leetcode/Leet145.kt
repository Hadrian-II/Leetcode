package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(postorderTraversal(createNode(listOf(1,null,2,3))))
    println(postorderTraversal(createNode(listOf(1,2,3,4,5,null,8,null,null,6,7,9))))
}

fun postorderTraversal(root: TreeNode?): List<Int> {
    val result = mutableListOf<Int>()

    fun traverse(node: TreeNode) {
        node.left?.let { traverse(it) }
        node.right?.let { traverse(it) }

        result.add(node.`val`)
    }
    root?.let { traverse(it) }

    return result
}