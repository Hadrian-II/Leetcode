package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(addTwoNumbers(createList(intArrayOf(2,4,3)), createList(intArrayOf(5,6,4))))
    printList(addTwoNumbers(createList(intArrayOf(0)), createList(intArrayOf(0))))
    printList(addTwoNumbers(createList(intArrayOf(9,9,9,9,9,9,9)), createList(intArrayOf(9,9,9,9))))
}

fun addTwoNumbers(l1: ListNode?, l2: ListNode?): ListNode? {
    var rev1 = l1
    var rev2 = l2
    var carry = 0
    var result: ListNode? = null
    var lasttDigit: ListNode? = null
    while (rev1 != null || rev2 != null || carry != 0) {
        var current = (rev1?.`val` ?: 0) + (rev2?.`val` ?: 0) + carry
        if (current > 9) {
            carry = 1
            current -= 10
        } else {
            carry = 0
        }
        if (result == null) {
            result = ListNode(current)
            lasttDigit = result
        } else {
            lasttDigit!!.next = ListNode(current)
            lasttDigit = lasttDigit.next
        }
        rev1 = rev1?.next
        rev2 = rev2?.next
    }
    return result
}