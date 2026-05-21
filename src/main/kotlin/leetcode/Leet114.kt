package leetcode

import helpers.TreeNode
import helpers.createNode
import java.util.Stack

fun main () {
    val r1 = createNode(listOf(1,2,5,3,4,null,6))
    Solution114().flatten(r1)
    val blorp = 1
}

class Solution114 {
    val leftOverStack = Stack<TreeNode>()

    fun flatten(root: TreeNode?): Unit {
        if (root != null) {
            process(root)
        }
    }

    fun process(node: TreeNode) {
        if (node.right != null) {
            if (node.left != null) {
                leftOverStack.add(node.right)
                node.right = node.left
                node.left = null
            }
        } else {
            if (node.left != null) {
                node.right = node.left
                node.left = null
            } else if (leftOverStack.isNotEmpty()) {
                node.right = leftOverStack.pop()
            }
        }

        if (node.right != null) {
            process(node.right!!)
        }
    }
}