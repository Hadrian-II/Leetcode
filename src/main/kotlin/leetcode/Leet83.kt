package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(deleteDuplicates(createList(intArrayOf(1,1,2))))
    printList(deleteDuplicates(createList(intArrayOf(1,1,2,3,3))))
}

fun deleteDuplicates(head: ListNode?): ListNode? {
    if (head == null) {
        return null
    }

    var current = head

    while (current?.next != null) {
        var next = current.next
        while (current.`val` == next?.`val`) {
            next = next.next
        }
        current.next = next
        current = next
    }

    return head
}