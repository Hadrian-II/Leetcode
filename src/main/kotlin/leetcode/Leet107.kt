package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    Solution107().levelOrderBottom(createNode(listOf(3,9,20,null,null,15,7))).forEach { println(it)}
    println("---------------")
    Solution107().levelOrderBottom(createNode(listOf(1))).forEach { println(it)}
    println("---------------")
    Solution107().levelOrderBottom(null).forEach { println(it)}
}

class Solution107 {
    val result = mutableListOf<MutableList<Int>>()

    fun levelOrderBottom(root: TreeNode?): List<List<Int>> {
        if (root != null) {
            processNode(root, 0)
        }

        return result.reversed()
    }

    fun processNode(node: TreeNode, level: Int) {
        if (result.size <= level) {
            result.add(mutableListOf())
        }
        result[level].add(node.`val`)

        node.left?.let { processNode(it, level + 1) }
        node.right?.let { processNode(it, level + 1)}
    }
}