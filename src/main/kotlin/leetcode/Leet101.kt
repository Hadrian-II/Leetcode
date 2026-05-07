package leetcode

import helpers.TreeNode
import helpers.createNode

fun main () {
    println(isSymmetric(createNode(listOf(1,2,2,3,4,4,3))))
    println(isSymmetric(createNode(listOf(1,2,2,null,3,null,3))))
}

fun isSymmetric(root: TreeNode?): Boolean {
    return checkSymetry(root?.left, root?.right)
}

fun checkSymetry(left: TreeNode?, right: TreeNode?): Boolean {
    if (left == null && right == null) {
        return true
    } else if (left?.`val` != right?.`val`) {
        return false
    }

    return checkSymetry(left?.right, right?.left) && checkSymetry(left?.left, right?.right)
}
