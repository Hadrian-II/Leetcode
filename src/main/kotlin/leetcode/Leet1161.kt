package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main () {
    println(Solution1161().maxLevelSum(treeFactory("1,7,0,7,-8,null,null")))
    println(Solution1161().maxLevelSum(treeFactory("989,null,10250,98693,-89388,null,null,null,-32127")))
}

class Solution1161 {
    val levelSums = ArrayList<Int>()

    fun maxLevelSum(root: TreeNode?): Int {
        sumUp(root!!, 0)
        return levelSums.indexOf(levelSums.max()) + 1
    }

    fun sumUp(node: TreeNode, level: Int) {
        if (level >= levelSums.size) {
            levelSums.add(0)
        }
        levelSums[level] += node.`val`
        node.left?.let { sumUp(it, level + 1) }
        node.right?.let { sumUp(it, level + 1) }
    }
}