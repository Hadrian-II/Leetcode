package leetcode

import helpers.TreeNode
import helpers.createNode
import kotlin.math.max

fun main() {
    println(Solution124().maxPathSum(createNode(listOf(1,2,3))))
    println(Solution124().maxPathSum(createNode(listOf(-10,9,20,null,null,15,7))))
    println(Solution124().maxPathSum(createNode(listOf(-3))))
    println(Solution124().maxPathSum(createNode(listOf(2,-1, -2))))
    println(Solution124().maxPathSum(createNode(listOf(-1,null,9,-6,3,null,null,null,-2))))
}

class Solution124 {
    fun maxPathSum(root: TreeNode?): Int {
        return getMax(root!!).let { max(it.first, it.second) }
    }

    fun getMax(node: TreeNode): Pair<Int, Int> {
        val left = node.left?.let { getMax(it) } ?: Pair(0, Int.MIN_VALUE)
        val right = node.right?.let { getMax(it) } ?: Pair(0, Int.MIN_VALUE)

        return Pair(maxOf(left.first, right.first, 0) + node.`val`,
                    maxOf(left.second,
                                   right.second,
                                   node.`val`,
                                   left.first + node.`val`,
                                   right.first + node.`val`,
                                   left.first + right.first + node.`val`))
    }
}