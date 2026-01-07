package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(Solution328().oddEvenList(createList(intArrayOf(1,2,3,4,5))))
    printList(Solution328().oddEvenList(createList(intArrayOf(2,1,3,5,6,4,7))))
}

class Solution328 {
    fun oddEvenList(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        var lastOdd = head
        var i = 1
        var firstEven: ListNode? = null
        var lastEven: ListNode? = null
        var current = head!!.next
        while (current != null) {
            i++
            if (i % 2 == 1) {
                if (firstEven != null) {
                    val next = current.next
                    lastOdd!!.next = current
                    lastOdd = current
                    current.next = firstEven
                    lastEven!!.next = next
                    current = next
                }
            } else {
                lastEven = current
                if (firstEven == null) {
                    firstEven = current
                }
                current = current.next
            }
        }
        return head
    }
}