package leetcode

import helpers.TreeNode
import helpers.createNode
import kotlin.math.log10
import kotlin.math.pow

fun main() {
    //println(sumNumbers(createNode(listOf(1,2,3))))
    println(sumNumbers(createNode(listOf(4,9,0,5,1))))
}

fun sumNumbers(root: TreeNode?): Int {
    return leafSum(root!!, 0)
}

fun leafSum(node: TreeNode, fromTop: Int): Int {
    val currNumber = fromTop * 10 + node.`val`

    return if (node.left == null && node.right == null) {
        currNumber
    } else {
        (node.left?.let { leafSum(it, currNumber) } ?: 0) +
        (node.right?.let { leafSum(it, currNumber) } ?: 0)
    }
}