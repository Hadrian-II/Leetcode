package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(searchBST(treeFactory("4,2,7,1,3"), 2))
    println(searchBST(treeFactory("4,2,7,1,3"), 5))
}

fun searchBST(root: TreeNode?, `val`: Int): TreeNode? {
    return when (`val`) {
        root!!.`val` -> root
        in 0..<root.`val` -> if (root.left == null) null else searchBST(root.left!!, `val`)
        else -> if (root.right == null) null else searchBST(root.right!!, `val`)
    }
}