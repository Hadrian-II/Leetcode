package leetcode

import helpers.TreeNode
import helpers.treeFactory
import kotlin.math.max

fun main() {
    println(longestZigZag(treeFactory("1,null,1,1,1,null,null,1,1,null,1,null,null,null,1")))
    println(longestZigZag(treeFactory("1,1,1,null,1,null,null,1,1,null,1")))
    println(longestZigZag(treeFactory("1")))
}

fun longestZigZag(root: TreeNode?): Int {
    return maxZigZag(root!!, 0, null)
}

fun maxZigZag(node: TreeNode, length: Int, left: Boolean?): Int {
    var max = length

    if (node.left != null) {
        max = max(max, maxZigZag(node.left!!, if (left == false) length + 1 else 1, true))
    }
    if (node.right != null) {
        max = max(max, maxZigZag(node.right!!, if (left == true) length + 1 else 1, false))
    }

    return max
}