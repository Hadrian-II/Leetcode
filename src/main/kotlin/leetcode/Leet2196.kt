package leetcode

import helpers.TreeNode
import helpers.readArrayOfArrays

fun main() {
    val node = createBinaryTree(readArrayOfArrays("[[20,15,1],[20,17,0],[50,20,1],[50,80,0],[80,19,1]]"))
    val node2 = createBinaryTree(readArrayOfArrays("[[1,2,1],[2,3,0],[3,4,1]]"))
    val node3 = createBinaryTree(readArrayOfArrays("[[39,70,1],[13,39,1],[85,74,1],[74,13,1],[38,82,1],[82,85,1]]"))
    val blorp = 4
}

fun createBinaryTree(descriptions: Array<IntArray>): TreeNode? {
    val nodeMap = HashMap<Int, TreeNode>()
    val children = mutableSetOf<Int>()

    for (description in descriptions) {
        val parent = nodeMap.getOrPut(description[0]) { TreeNode(description[0]) }
        val child = nodeMap.getOrPut(description[1]) { TreeNode(description[1]) }
        if (description[2] == 1) {
            parent.left = child
        } else {
            parent.right = child
        }
        children.add(child.`val`)
    }
    return nodeMap[descriptions.first { it[0] !in children }[0]]
}
