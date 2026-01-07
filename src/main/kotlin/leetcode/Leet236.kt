package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(Solution236().lowestCommonAncestor(treeFactory("3,5,1,6,2,0,8,null,null,7,4"), TreeNode(5), TreeNode(1)))
    println(Solution236().lowestCommonAncestor(treeFactory("3,5,1,6,2,0,8,null,null,7,4"), TreeNode(5), TreeNode(4)))
    println(Solution236().lowestCommonAncestor(treeFactory("1,2"), TreeNode(1), TreeNode(2)))
}

class Solution236 {
    var pVal = 0
    var qVal = 0
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        pVal = p!!.`val`
        qVal = q!!.`val`
        return findNodes(root!!).first
    }

    fun findNodes(node: TreeNode): Triple<TreeNode?, Boolean, Boolean> {
        var foundP = node.`val` == pVal
        var foundQ = node.`val` == qVal
        val left = if (node.left != null) findNodes(node.left!!) else Triple(null, false, false)
        val right = if (node.right != null) findNodes(node.right!!) else Triple(null, false, false)
        foundP = foundP || left.second || right.second
        foundQ = foundQ || left.third || right.third
        return Triple(left.first ?: right.first ?: if (foundP && foundQ) node else null, foundP, foundQ)
    }
}