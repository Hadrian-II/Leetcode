package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList


fun main() {
    printList(deleteMiddle(createList(intArrayOf(1,3,4,7,1,2,6))))
    printList(deleteMiddle(createList(intArrayOf(1,2,3,4))))
    printList(deleteMiddle(createList(intArrayOf(2,1))))
    printList(deleteMiddle(createList(intArrayOf(1))))
}

fun deleteMiddle(head: ListNode?): ListNode? {
    var size = 1
    var current = head
    while (current!!.next != null) {
        size++
        current = current.next

    }
    size /= 2
    if (size == 0) {
        return null
    }
    var beforeRemove = head
    for (i in 0..<size - 1) {
        beforeRemove = beforeRemove!!.next
    }
    val remove = beforeRemove!!.next
    val afterRemove  = remove?.next
    beforeRemove.next = afterRemove
    return head
}