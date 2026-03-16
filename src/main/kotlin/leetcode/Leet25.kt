package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(reverseKGroup(createList(intArrayOf(1,2,3,4,5)), 2))
    printList(reverseKGroup(createList(intArrayOf(1,2,3,4,5)), 3))
}

fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
    var size = 0
    var current = head
    while (current != null) {
        size++
        current = current.next
    }
    size -= size % k

    val dummy = ListNode(0)
    var ptr = dummy
    current = head
    var i = 0
    while (current != null) {
        val buffer = current.next

        current.next = ptr.next
        ptr.next = current
        i++
        size--
        if (i == k) {
            while (ptr.next != null) {
                ptr = ptr.next!!
            }
            i = 0
        }

        current = buffer
        if (size == 0) {
            ptr.next = current
            break
        }
    }
    return dummy.next
}