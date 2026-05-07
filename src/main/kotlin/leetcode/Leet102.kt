package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    Solution102().levelOrder(createNode(listOf(3,9,20,null,null,15,7))).forEach { println(it) }
    println("---------")
    Solution102().levelOrder(createNode(listOf(1))).forEach { println(it) }
}

class Solution102 {
    val result = mutableMapOf<Int, MutableList<Int>>()

    fun levelOrder(root: TreeNode?): List<List<Int>> {
        writeValue(root, 0)

        return result.values.toList()
    }

    fun writeValue(node: TreeNode?, level: Int) {
        if (node != null) {
            if (level !in result) {
                result[level] = mutableListOf(node.`val`)
            } else {
                result[level]!!.add(node.`val`)
            }
            node.left?.let { writeValue(it, level + 1)}
            node.right?.let { writeValue(it, level + 1) }
        }
    }
}