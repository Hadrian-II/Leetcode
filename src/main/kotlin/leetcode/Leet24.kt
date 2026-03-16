package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(swapPairs(createList(intArrayOf(1,2,3,4))))
    printList(swapPairs(null))
    printList(swapPairs(createList(intArrayOf(1))))
    printList(swapPairs(createList(intArrayOf(1,2,3))))
}

fun swapPairs(head: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    var next = head
    var afternext = head?.next

    while (next != null) {
        if (afternext != null) {
            val nbr = next.next?.next
            val abr = afternext.next?.next
            current.next = afternext
            current = current.next!!
            current.next = next
            current = current.next!!
            current.next = null
            next = nbr
            afternext = abr

        } else {
            current.next = next
            break
        }
    }

    return dummy.next
}