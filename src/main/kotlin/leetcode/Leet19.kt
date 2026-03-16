package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList
import java.util.Queue

fun main() {
    printList(removeNthFromEnd(createList(intArrayOf(1,2,3,4,5)), 2))
    printList(removeNthFromEnd(createList(intArrayOf(1)), 1))
    printList(removeNthFromEnd(createList(intArrayOf(1,2)), 1))
    printList(removeNthFromEnd(createList(intArrayOf(1,2)), 2))
}

fun removeNthFromEnd(head: ListNode?, n: Int): ListNode? {
    val ptrs = mutableListOf<ListNode>()
    var current = head
    while (current != null) {
        ptrs.add(current)
        current = current.next
    }

    if (ptrs.size == 1) {
        return null
    }

    if (ptrs.size == n) {
        return head!!.next
    }

    val nFromLast = ptrs.size - n - 1
    ptrs[nFromLast].next = ptrs[nFromLast].next?.next

    return head
}