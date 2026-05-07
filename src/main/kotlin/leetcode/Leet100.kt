package leetcode

import helpers.TreeNode
import helpers.createNode
import helpers.treeFactory

fun main () {
    println(isSameTree(createNode(listOf(1,2,3)), createNode(listOf(1,2,3))))
    println(isSameTree(createNode(listOf(1,2)), createNode(listOf(1,null,2))))
    println(isSameTree(createNode(listOf(1,2,1)), createNode(listOf(1,1,2))))
}

fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
    if ((p != null || q != null) && p?.`val` != q?.`val`) {
        return false
    } else if (p?.left == null && q?.left == null && p?.right == null && q?.right == null) {
        return true
    }

    return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
}