package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(Solution2265().averageOfSubtree(createNode(listOf(4,8,5,0,1,null,6))))
    println(Solution2265().averageOfSubtree(createNode(listOf(1))))
}

class Solution2265 {
    fun averageOfSubtree(root: TreeNode?): Int {
        return findAverages(root!!)[0]
    }

    fun findAverages(node: TreeNode): IntArray {
        var result = node.left?.let { findAverages(it) }

        node.right?.let {
            if (result != null) {
                val child = findAverages(it)
                result[0] += child[0]
                result[1] += child[1]
                result[2] += child[2]
            } else {
                result = findAverages(it)
            }
        }

        if (result == null)  {
            result = IntArray(3)
        }

        result[1] += node.`val`
        result[2] += 1
        if (result[1] / result[2] == node.`val`) {
            result[0]++
        }

        return result
    }
}
