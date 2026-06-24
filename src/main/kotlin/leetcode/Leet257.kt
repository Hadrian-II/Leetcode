package leetcode

import helpers.TreeNode
import helpers.createNode

fun main() {
    println(binaryTreePaths(createNode(listOf(1,2,3,null,5))))
    println(binaryTreePaths(createNode(listOf(1))))
}

fun binaryTreePaths(root: TreeNode?): List<String> {
    return binaryTreeBuilders(root).map { it.toString() }
}

fun binaryTreeBuilders(root: TreeNode?): List<StringBuilder> {
    return if (root == null) {
        emptyList()
    } else {
        val childs = binaryTreeBuilders(root.left) + binaryTreeBuilders(root.right)
        if (childs.isEmpty()) {
            listOf(StringBuilder(root.`val`.toString()))
        } else {
            childs.forEach { it.insert(0, "${root.`val`}->") }
            childs
        }
    }
}