package leetcode

import helpers.TreeNode
import helpers.createNode
import helpers.printIntArray
import java.util.TreeSet

fun main() {
    printIntArray(Solution501().findMode(createNode(listOf(1,null,2,2))))
}

class Solution501 {
    val elements = mutableMapOf<Int, Int>()

    fun findMode(root: TreeNode?): IntArray {
        root?.let { collect(it) }
        var max = 0
        var result = mutableListOf<Int>()
        for ((key, value) in elements) {
            if (value > max) {
                max = value
                result = mutableListOf(key)
            } else if (value == max) {
                result.add(key)
            }
        }
        return result.toIntArray()
    }

    fun collect(node: TreeNode) {
        elements[node.`val`] = (elements[node.`val`] ?: 0) + 1
        node.left?.let { collect(it) }
        node.right?.let { collect(it) }
    }
}