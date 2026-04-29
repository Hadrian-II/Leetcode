package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(partition(createList(intArrayOf(1,4,3,2,5,2)), 3))
    printList(partition(createList(intArrayOf(2,1)), 2))
}

fun partition(head: ListNode?, x: Int): ListNode? {
    if (head == null) {
        return null
    }

    val less = ListNode(-1)
    val bigger = ListNode(-1)
    var addLessTo = less
    var addBiggerTo = bigger

    var current = head
    while (current != null) {
        val c = current
        current = current.next

        c.next = null
        if (c.`val` < x) {
            addLessTo.next = c
            addLessTo = c
        } else {
            addBiggerTo.next = c
            addBiggerTo = c
        }
    }

    if (less.next == null) {
        return bigger.next
    } else {
        addLessTo.next = bigger.next
        return less.next
    }
}