package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(Solution82().deleteDuplicates(createList(intArrayOf(1,2,3,3,4,4,5))))
    printList(Solution82().deleteDuplicates(createList(intArrayOf(1,1,1,2,3))))
}

class Solution82() {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        val result = ListNode(-1)
        var addAt = result
        var current = head

        while (current != null) {
            var duplicate = false
            while (current?.`val` == current?.next?.`val`) {
                current = current?.next
                duplicate = true
            }
            if (duplicate) {
                current = current?.next
            } else {
                val c = current
                current = current?.next

                if (c != null) {
                    addAt.next = c
                    c.next = null
                    addAt = c
                }
            }
        }

        return result.next
    }
}