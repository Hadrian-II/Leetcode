package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(Solution199().rightSideView(treeFactory("1,2,3,null,5,null,4")))
    println(Solution199().rightSideView(treeFactory("1,2,3,4,null,null,null,5")))
    println(Solution199().rightSideView(treeFactory("1,null,3")))
}

class Solution199 {
    val rights = ArrayList<Int>()

    fun rightSideView(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        getRights(root, 1)
        return rights
    }

    fun getRights(node: TreeNode, level: Int) {
        if (rights.size < level) {
            rights.add(node.`val`)
        }
        node.right?.let { getRights(it, level + 1) }
        node.left?.let { getRights(it, level + 1) }
    }
}