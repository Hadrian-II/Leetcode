package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(reverseList(createList(intArrayOf(1,2,3,4,5))))
    printList(reverseList(createList(intArrayOf(1,2))))
}

fun reverseList(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }
    var start = head
    var current = head.next
    start.next = null
    while (current != null) {
        val next = current.next
        current.next = start
        start = current
        current = next
    }
    return start
}