package leetcode

import com.sun.source.tree.Tree
import helpers.TreeNode
import helpers.createNode
import java.util.Stack

fun main() {
//    val bSTIterator = BSTIterator(createNode(listOf(7, 3, 15, null, null, 9, 20)))
//    println(bSTIterator.next())
//    println(bSTIterator.next())
//    println(bSTIterator.hasNext())
//    println(bSTIterator.next())
//    println(bSTIterator.hasNext())
//    println(bSTIterator.next())
//    println(bSTIterator.hasNext())
//    println(bSTIterator.next())
//    println(bSTIterator.hasNext())

    val bSTIterator2 = BSTIterator(createNode(listOf(1)))
    println(bSTIterator2.hasNext())
    println(bSTIterator2.next())
    println(bSTIterator2.hasNext())
}

class BSTIterator(root: TreeNode?) {
    var current: TreeNode? = null
    val parents = Stack<TreeNode>()
    val visited = Stack<Int>()

    init {
        downLeft(root)
    }



    fun next(): Int {
        val value = current!!.`val`

        if (current!!.right != null) {
            visited.add(value)
            parents.add(current)
            downLeft(current!!.right)
        } else {
            current = if (parents.isNotEmpty()) parents.pop() else null
            while (visited.isNotEmpty() && visited.peek() == current!!.`val`) {
                current = if (parents.isNotEmpty()) parents.pop() else null
                visited.pop()
            }
        }

        return value
    }

    fun hasNext(): Boolean {
        return current != null
    }

    private fun downLeft(node: TreeNode?) {
        current = node
        while (current != null && current!!.left != null) {
            parents.add(current)
            current = current!!.left!!
        }
    }
}