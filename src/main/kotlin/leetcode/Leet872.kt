package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(leafSimilar(treeFactory("3,5,1,6,2,9,8,null,null,7,4"), treeFactory("3,5,1,6,7,4,2,null,null,null,null,null,null,9,8")))
    println(leafSimilar(treeFactory("1,2,3"), treeFactory("1,3,2")))
}

fun leafSimilar(root1: TreeNode?, root2: TreeNode?): Boolean {
    return getLeaves(root1!!, ArrayList()) == getLeaves(root2!!, ArrayList())
}

fun getLeaves(root: TreeNode, leaves: MutableList<Int>): MutableList<Int> {
    if (root.left == null && root.right == null) {
        leaves.add(root.`val`)
    }
    if (root.left != null) {
        getLeaves(root.left!!, leaves)
    }
    if (root.right != null) {
        getLeaves(root.right!!, leaves)
    }
    return leaves
}