package leetcode

import helpers.TreeNode
import helpers.treeFactory
import kotlin.math.abs
import kotlin.math.max

fun main() {
    println(Solution110().isBalanced(treeFactory("3,9,20,null,null,15,7")))
    println(Solution110().isBalanced(treeFactory("1,2,2,3,3,null,null,4,4")))
    println(Solution110().isBalanced(treeFactory("1,null,2,null,3")))
    println(Solution110().isBalanced(treeFactory("1,2,3,4,5,6,null,8")))
}

class Solution110 {
    var failed = false
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }

        parseTree(root)
        return !failed
    }

    fun parseTree(node: TreeNode): Int {
        if (failed || (node.left == null && node.right == null)) {
            return 1
        }

        val l = node.left?.let { parseTree(it)} ?: 0
        val r = node.right?.let { parseTree(it)} ?: 0
        return if (abs(l - r) > 1) {
            failed = true
            0
        } else {
            max(l, r) + 1
        }
    }
}