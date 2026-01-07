package leetcode

import helpers.TreeNode
import helpers.treeFactory
import kotlin.math.max

fun main(){
    println(goodNodes(treeFactory("3,1,4,3,null,1,5")))
    println(goodNodes(treeFactory("3,3,null,4,2")))
    println(goodNodes(treeFactory("1")))
}

fun goodNodes(root: TreeNode?): Int {
    return goodSum(root!!, Int.MIN_VALUE)
}

fun goodSum(node: TreeNode, max: Int): Int {
    var newMax = max
    var isGood = if (node.`val` >= max) {
        newMax = node.`val`
        1
    } else {
        0
    }
    if (node.left != null) {
        isGood += goodSum(node.left!!, newMax)
    }
    if (node.right != null) {
        isGood += goodSum(node.right!!, newMax)
    }
    return isGood
}