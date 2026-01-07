package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main () {
    val r1 = deleteNode(treeFactory("5,3,6,2,4,null,7"), 3)
    val r2 = deleteNode(treeFactory("5,3,6,2,4,null,7"), 0)
    val r3 = deleteNode(treeFactory("50,30,70,null,40,60,80"), 50)
    val blah = 1
}

fun deleteNode(root: TreeNode?, key: Int): TreeNode? {
    if (root == null) {
        return null
    } else if (root.`val` == key) {
        if (root.right == null) {
            return root.left
        } else {
            if (root.left == null) {
                return root.right
            } else {
                val succ = findSuccessor(root.right!!)
                deleteNode(root, succ.`val`)
                root.`val` = succ.`val`
            }
        }
    } else if (root.`val` > key && root.left != null) {
        root.left = deleteNode(root.left, key)
    } else if (root.`val` < key && root.right != null) {
        root.right = deleteNode(root.right, key)
    }
    return root
}

fun findSuccessor(node: TreeNode): TreeNode {
    return if (node.left != null) {
        findSuccessor(node.left!!)
    } else {
        node
    }
}