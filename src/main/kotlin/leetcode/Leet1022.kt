package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(sumRootToLeaf(treeFactory("1,0,1,0,1,0,1")))
    println(sumRootToLeaf(treeFactory("0")))
}

fun sumRootToLeaf(root: TreeNode?): Int {
    return nodeValue(root!!, 0)
}

fun nodeValue(node: TreeNode, value: Int): Int {
    val current = value.shl(1) + node.`val`
    return if (node.right == null && node.left == null) {
        current
    } else {
        (node.left?.let { nodeValue(it, current) } ?: 0) +
        (node.right?.let { nodeValue(it, current) } ?: 0)
    }
}