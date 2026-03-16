package leetcode

import helpers.ListNode

fun mergeTwoLists(list1: ListNode?, list2: ListNode?): ListNode? {
    val dummy = ListNode(0)
    var current = dummy
    var left: ListNode? = list1
    var right: ListNode? = list2

    while (left != null || right != null) {
        if ((left?.`val` ?: Int.MAX_VALUE) < (right?.`val` ?: Int.MAX_VALUE)) {
            current.next = left
            left = left!!.next
        } else {
            current.next = right
            right = right!!.next
        }
        current = current.next!!
    }

    return dummy.next
}