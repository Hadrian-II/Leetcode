package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(countNodes(createNode(listOf(1,2,3,4,5,6))))
    println(countNodes(createNode(listOf(1))))
}

fun countNodes(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }

    var current = root!!
    var result = 1
    while (current.left != null) {
        result = result.shl(1)
        if (current.right == null || getDepth(current.right!!) < getDepth(current.left!!)) {
            current = current.left!!
        } else {
            current = current.right!!
            result++
        }
    }
    return result
}

fun getDepth(node: TreeNode): Int {
    var depth = 1
    var current = node
    while (current.left != null) {
        depth++
        current = current.left!!
    }

    return depth
}