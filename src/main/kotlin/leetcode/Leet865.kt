package leetcode

import helpers.TreeNode
import helpers.treeFactory
import kotlin.math.max

fun main() {
    println(Solution865().subtreeWithAllDeepest(treeFactory("3,5,1,6,2,0,8,null,null,7,4")))
    println(Solution865().subtreeWithAllDeepest(treeFactory("1")))
    println(Solution865().subtreeWithAllDeepest(treeFactory("0,1,3,null,2")))
}

class Solution865 {
    val result = HashMap<TreeNode, Int>()

    fun subtreeWithAllDeepest(root: TreeNode?): TreeNode? {
        traceTree(root!!, 1)
        var current = root!!
        while (true) {
            val self = result[current]!!
            val left = result[current.left] ?: 0
            val right = result[current.right] ?: 0
            if (left == self && right != self) {
                current = current.left!!
            } else if (right == self && left != self) {
                current = current.right!!
            } else {
                return current
            }
        }
    }

    fun traceTree(node: TreeNode, level: Int): Int {
        val left = node.left?.let { traceTree(it, level + 1)} ?: level
        val right = node.right?.let { traceTree(it, level + 1) } ?: level
        val deepest = max(left, right)
        result[node] = deepest
        return deepest
    }
}