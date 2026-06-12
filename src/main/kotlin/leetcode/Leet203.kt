package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(removeElements(createList(intArrayOf(1,2,6,3,4,5,6)), 6))
    printList(removeElements(null, 1))
    printList(removeElements(createList(intArrayOf(7,7,7,7)), 7))
}

fun removeElements(head: ListNode?, `val`: Int): ListNode? {
    val workshop = ListNode(-1)
    var appendTo = workshop
    var current = head

    while (current != null) {
        val next = current.next
        if (current.`val` != `val`) {
            appendTo.next = current
            appendTo = current
            current.next = null
        }

        current = next
    }

    return workshop.next
}