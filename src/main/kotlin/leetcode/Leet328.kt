package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(oddEvenList(createList(intArrayOf(1,2,3,4,5))))
    printList(oddEvenList(createList(intArrayOf(2,1,3,5,6,4,7))))
}

fun oddEvenList(head: ListNode?): ListNode? {
    var lastOdd: ListNode? = null
    var firstEven: ListNode? = null
    var lastEven: ListNode? = null
    var isOdd = true
    var current = head
    while (current != null) {
        if (isOdd) {
            lastOdd?.let { it.next = current }
            lastOdd = current
        } else {
            if (firstEven == null) {
                firstEven = current
            }
            lastEven?.let { it.next = current }
            lastEven = current
        }
        isOdd = !isOdd
        current = current.next
    }
    lastEven?.next = null
    lastOdd?.next = firstEven
    return head
}