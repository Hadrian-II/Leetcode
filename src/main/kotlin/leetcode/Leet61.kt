package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
//    printList(rotateRight(createList(intArrayOf(1,2,3,4,5)), 2))
//    printList(rotateRight(createList(intArrayOf(0,1,2)), 4))
    printList(rotateRight(createList(intArrayOf(1,2)), 2))
}

fun rotateRight(head: ListNode?, k: Int): ListNode? {
    if (head == null || head.next == null) {
        return head
    }

    var size = 1
    var current = head
    while (current!!.next != null) {
        size ++
        current = current.next
    }
    val last = current

    if (k % size == 0) {
        return head
    }

    val split = size - (k % size)

    current = head
    var i = 1
    while (i < split) {
        current = current!!.next
        i++
    }

    val start = current!!.next
    current.next = null
    last.next = head
    return start
}