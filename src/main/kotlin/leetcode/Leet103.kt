package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    Solution103().zigzagLevelOrder(createNode(listOf(3,9,20,null,null,15,7))).forEach { println(it) }
    println("---------")
    Solution103().zigzagLevelOrder(createNode(listOf(1))).forEach { println(it) }
}

class Solution103 {
    val result = mutableMapOf<Int, MutableList<Int>>()

    fun zigzagLevelOrder(root: TreeNode?): List<List<Int>> {
        writeValue(root, 0)

        return result.values.toList()
    }

    fun writeValue(node: TreeNode?, level: Int) {
        if (node != null) {
            if (level !in result) {
                result[level] = mutableListOf(node.`val`)
            } else {
                if (level % 2 == 0) {
                    result[level]!!.add(node.`val`)
                } else {
                    result[level]!!.add(0, node.`val`)
                }
            }
            node.left?.let { writeValue(it, level + 1)}
            node.right?.let { writeValue(it, level + 1) }
        }
    }
}