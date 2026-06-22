package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(lowestCommonAncestor(createNode(listOf(6,2,8,0,4,7,9,null,null,3,5)), TreeNode(2), TreeNode(8)))
    println(lowestCommonAncestor(createNode(listOf(6,2,8,0,4,7,9,null,null,3,5)), TreeNode(2), TreeNode(4)))
    println(lowestCommonAncestor(createNode(listOf(2,1)), TreeNode(2), TreeNode(1)))
}

fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
    val big = maxOf(p!!.`val`, q!!.`val`)
    val small = minOf(p.`val`, q.`val`)
    return findLCA(root!!, small, big)
}

fun findLCA(node: TreeNode, small: Int, big: Int): TreeNode? {
    return if (big < node.`val`) {
        findLCA(node.left!!, small, big)
    } else if (small > node.`val`) {
        findLCA(node.right!!, small, big)
    } else {
        node
    }
}