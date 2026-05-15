package leetcode

import helpers.TreeNode
import kotlin.time.measureTime

fun main() {
    val t1 = Solution105().buildTree(intArrayOf(3,9,20,15,7), intArrayOf(9,3,15,20,7))
    val t2 = Solution105().buildTree(intArrayOf(-1), intArrayOf(-1))
    println(measureTime { val t3 = Solution105().buildTree((0..3000).toList().toIntArray(), (0..3000).reversed().toList().toIntArray()) })
}

class Solution105 {
    lateinit var ino: IntArray
    lateinit var imap: Map<Int, Int>

    fun buildTree(preorder: IntArray, inorder: IntArray): TreeNode? {
        ino = inorder

        imap = inorder.mapIndexed { i, nr -> nr to i }.toMap()

        return createNodes(preorder.toList(), 0, ino.lastIndex)
    }

    fun createNodes(preorder: List<Int>, start: Int, end: Int): TreeNode? {
        val head = TreeNode(preorder.first())
        val hIx = imap[preorder.first()]!!

        if (hIx > start) {
            val cSet = ino.slice(start..<hIx).toSet()
            head.left = createNodes(preorder.filter{it in cSet}, start, hIx - 1)
        }
        if (hIx < end) {
            val cSet = ino.slice(hIx +1..end).toSet()
            head.right = createNodes(preorder.filter{it in cSet}, hIx + 1, end)
        }

        return head
    }
}