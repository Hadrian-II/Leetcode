package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(Solution230().kthSmallest(createNode(listOf(3,1,4,null,2)), 1))
    println(Solution230().kthSmallest(createNode(listOf(5,3,6,2,4,null,null,1)), 3))
}

class Solution230 {
    var k = -1
    var ix = 0
    var result = -1

    fun kthSmallest(root: TreeNode?, k: Int): Int {
        this.k = k
        findNode(root!!)
        return result
    }

    fun findNode(node: TreeNode) {
        if (result != -1) {
            return
        }
        node.left?.let { findNode(it) }
        ix ++
        if (ix == k) {
            result = node.`val`
        } else {
            node.right?.let { findNode(it) }
        }
    }
}