package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
//    val s1 = Codec().serialize(createNode(listOf(2,1,3)))
//    val t1 = Codec().deserialize(s1)
//    val s2 = Codec().serialize(TreeNode(0))
//    val t2 = Codec().deserialize(s2)
    val s3 = Codec().serialize(createNode(listOf(3,1,4,null,2)))
    val t3 = Codec().deserialize(s3)
    val blorp = 4
}

class Codec() {
    // Encodes a tree to a single string.
    fun serialize(root: TreeNode?): String {
        val data = mutableListOf<String>()
        doSerialize(root, data)
        return data.joinToString(",")
    }

    private fun doSerialize(node: TreeNode?, data: MutableList<String>) {
        if (node == null) {
            data.add("n")
        } else {
            data.add(node.`val`.toString())
            doSerialize(node.left, data)
            doSerialize(node.right, data)
        }
    }

    // Decodes your encoded data to tree.
    fun deserialize(data: String): TreeNode? {
        val values = data.split(",")
        val root = createTreeNode(values[0])
        if (root == null) {
            return root
        }
        var i = 1
        var current = root!!
        var left = true
        val stack = ArrayDeque<Pair<TreeNode, Boolean>>()
        while (i < values.size) {
            val value = createTreeNode(values[i])
            if (left) {
                current.left = value
                if (value != null) {
                    stack.add(Pair(current, true))
                    current = value
                } else {
                    left = false
                }
            } else {
                current.right = value
                if (value != null) {
                    stack.add(Pair(current, false))
                    current = value
                    left = true
                } else if (stack.isNotEmpty()) {
                    var parent = stack.removeLast()
                    while (!parent.second && stack.isNotEmpty()) {
                        parent = stack.removeLast()
                    }
                    current = parent.first
                }
            }
            i++
        }
        return root
    }

    private fun createTreeNode(value: String): TreeNode? {
        return if (value == "n") {
            null
        } else {
            TreeNode(value.toInt())
        }
    }
}