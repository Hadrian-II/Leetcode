package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(Solution98().isValidBST(treeFactory("2,1,3")))
    println(Solution98().isValidBST(treeFactory("5,1,4,null,null,3,6")))
    println(Solution98().isValidBST(treeFactory("2,2,2")))
    println(Solution98().isValidBST(treeFactory("2147483647")))
}

class Solution98 {
    fun isValidBST(root: TreeNode?): Boolean {
        return isValid(root!!, null, null)
    }

    fun isValid(node: TreeNode, max: Int?, min: Int?): Boolean {
        return if ((min != null && node.`val` <= min) || (max != null && node.`val` >= max)) {
            false
        } else {
            node.left?.let { isValid(it, node.`val`, min) } ?: true &&
            node.right?.let { isValid(it, max, node.`val`) } ?: true
        }
    }
}