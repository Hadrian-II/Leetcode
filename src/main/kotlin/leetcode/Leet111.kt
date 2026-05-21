package leetcode

import com.sun.source.tree.Tree
import helpers.TreeNode
import helpers.createNode
import kotlin.math.min

fun main() {
    println(minDepth(createNode(listOf(3,9,20,null,null,15,7))))
    println(minDepth(createNode(listOf(2,null,3,null,4,null,5,null,6))))
}

fun minDepth(root: TreeNode?): Int {
    if (root == null) {
        return 0
    }
    return getMinDepth(root, 1)
}

fun getMinDepth(node: TreeNode, level: Int): Int {
    if (node.left == null && node.right == null) {
        return level
    }
    return min(node.left?.let { getMinDepth(it, level + 1) } ?: Int.MAX_VALUE,
               node.right?.let { getMinDepth(it, level + 1) } ?: Int.MAX_VALUE)
}


