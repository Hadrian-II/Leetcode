package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(reverseBetween(createList(intArrayOf(1,2,3,4,5)), 2, 4))
    printList(reverseBetween(createList(intArrayOf(1,2,3,4,5)), 1, 3))
    printList(reverseBetween(createList(intArrayOf(5)), 1, 1))
}

fun reverseBetween(head: ListNode?, left: Int, right: Int): ListNode? {
    val start = ListNode(-1)
    var beforeInsert = start
    var insert: ListNode? = null
    var last = start
    var current = head
    var currentIndex = 1

    while (current != null) {
        val next = current.next
        when (currentIndex) {
            in left..right -> {
                beforeInsert.next = current
                current.next = insert
                if (insert == null) {
                    last = current
                }
                insert = current
            }
            else -> {
                last.next = current
                last = current
                beforeInsert = current
            }
        }
        currentIndex++
        current = next
    }

    return start.next
}