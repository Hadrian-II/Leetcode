package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(inorderTraversal(treeFactory("1,null,2,3")))
    println(inorderTraversal(treeFactory("1,2,3,4,5,null,8,null,null,6,7,9")))
    println(inorderTraversal(treeFactory("1")))
}

fun inorderTraversal(root: TreeNode?): List<Int> {
    return if (root == null) {
        emptyList()
    } else {
        inorderTraversal(root.left) + listOf(root.`val`) + inorderTraversal(root.right)
    }
}