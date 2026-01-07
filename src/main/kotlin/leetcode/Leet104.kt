package leetcode

import helpers.TreeNode
import helpers.treeFactory
import kotlin.math.max

fun main() {
    println(maxDepth(treeFactory("3,9,20,null,null,15,7")))
    println(maxDepth(treeFactory("1,null,2")))
}

fun maxDepth(root: TreeNode?): Int {
    return getDepth(root, 1)
}

fun getDepth(node: TreeNode?, depth: Int): Int {
    return if (node == null) {
        0
    } else if (node.left == null && node.right == null) {
        depth
    } else {
        max(getDepth(node.left, depth + 1), getDepth(node.right, depth + 1))
    }
}