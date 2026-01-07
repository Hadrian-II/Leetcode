package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(Solution1339().maxProduct(treeFactory("1,2,3,4,5,6")))
    println(Solution1339().maxProduct(treeFactory("1,null,2,3,4,null,null,5,6")))
}

class Solution1339 {
    val treeMap = HashMap<TreeNode, Pair<Int, Int>>()

    fun maxProduct(root: TreeNode?): Int {
        sumTree(root!!)
        var currentNode = root!!
        var max = 0L
        var top = 0
        var current = calcNodeMax(currentNode, top)
        while (current > max) {
            max = current
            val currentValues = treeMap[currentNode]!!
            currentNode = if (currentValues.first > currentValues.second) {
                top += currentNode.`val` + currentValues.second
                currentNode.left!!
            } else {
                top += currentNode.`val` + currentValues.first
                currentNode.right!!
            }
            current = calcNodeMax(currentNode, top)
        }
        return (max % 1000000007).toInt()
    }

    fun calcNodeMax(node: TreeNode, top: Int): Long {
        val data = treeMap[node]!!
        return if (data.first > data.second) {
            data.first * (data.second + top + node.`val`.toLong())
        } else {
            data.second * (data.first + top + node.`val`.toLong())
        }
    }

    fun sumTree(node: TreeNode): Int {
        val left = node.left?.let { sumTree(it) } ?: 0
        val right = node.right?.let { sumTree(it) } ?: 0
        treeMap[node] = Pair(left, right)
        return left + right + node.`val`
    }
}