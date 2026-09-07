package leetcode

import helpers.TreeNode
import helpers.treeFactory

fun main() {
    println(pathSum(treeFactory("10,5,-3,3,2,null,11,3,-2,null,1"), 8))  // 3
    println(pathSum(treeFactory("5,4,8,11,null,13,4,7,2,null,null,5,1"), 22)) // 3
    println(pathSum(treeFactory("1"), 1))  // 1
    println(pathSum(treeFactory("1000000000,1000000000,null,294967296,null,1000000000,null,1000000000,null,1000000000"), 1))  // 0
}

fun pathSum(root: TreeNode?, targetSum: Int): Int {
    if (root == null) {
        return 0
    }
    return nodeSum(root, emptyList(), targetSum.toLong())
}

fun nodeSum(node: TreeNode, currentSums: List<Long>, targetSum: Long): Int {
    var count = 0

    val sums = ArrayList<Long>(currentSums.size + 1)
    for (sum in currentSums) {
        val newSum = sum + node.`val`
        if (newSum == targetSum) {
            count++
        }
        sums.add(newSum)
    }

    val current = node.`val`.toLong()
    if (current == targetSum) {
        count ++
    }
    sums.add(current)

    node.left?.let { count += nodeSum(it, sums, targetSum) }
    node.right?.let { count += nodeSum(it, sums, targetSum) }

    return count
}