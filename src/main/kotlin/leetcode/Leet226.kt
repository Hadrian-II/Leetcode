package leetcode

import helpers.TreeNode

fun main() {

}

fun invertTree(root: TreeNode?): TreeNode? {
    if (root != null) {
        val buf = root.left
        root.left = root.right
        root.right = buf
        root.right?.let { invertTree(it) }
        root.left?.let { invertTree(it) }
    }
    return root
}