package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun  main() {
    printList(Solution445().addTwoNumbers(createList(intArrayOf(7,2,4,3)), createList(intArrayOf(5,6,4))))
    printList(Solution445().addTwoNumbers(createList(intArrayOf(2,4,3)), createList(intArrayOf(5,6,4))))
    printList(Solution445().addTwoNumbers(createList(intArrayOf(0)), createList(intArrayOf(0))))
    printList(Solution445().addTwoNumbers(createList(intArrayOf(5)), createList(intArrayOf(5))))
}

class Solution445 {
    fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
        var r1: ListNode? = reverse(l1!!)
        var r2: ListNode? = reverse(l2!!)
        var ptr: ListNode? = null
        var carry = 0
        while (r1 != null || r2 != null) {
            val sum = (r1?.`val` ?: 0) + (r2?.`val` ?: 0) + carry
            carry = if (sum >= 10) 1 else 0
            val node = ListNode(sum % 10)
            node.next = ptr
            ptr = node
            r1 = r1?.next
            r2 = r2?.next
        }
        if (carry == 1) {
            val node = ListNode(1)
            node.next = ptr
            ptr = node
        }
        return ptr
    }

    private fun reverse(node: ListNode): ListNode {
        var first = node
        var current = node.next
        first.next = null
        while (current != null) {
            val next = current.next
            current.next = first
            first = current
            current = next
        }
        return first
    }
}