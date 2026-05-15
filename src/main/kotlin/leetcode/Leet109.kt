package leetcode

import helpers.ListNode
import helpers.TreeNode
import helpers.createList
import helpers.createNode

fun main() {
    val r1 = sortedListToBST(createList(intArrayOf(-10,-3,0,5,9)))
    val b = 4
}

fun sortedListToBST(head: ListNode?): TreeNode? {
    if (head == null) {
        return null
    }
    var current = head
    var mid = head
    var beforeMid: ListNode? = null
    var moveMid = false

    while (current != null) {
        if (moveMid) {
            beforeMid = mid
            mid = mid!!.next
        }
        moveMid = !moveMid
        current = current.next
    }

    val top = TreeNode(mid!!.`val`)
    top.right = sortedListToBST(mid.next)

    if (beforeMid != null) {
        beforeMid.next = null
        top.left = sortedListToBST(head)
    }
    return top
}