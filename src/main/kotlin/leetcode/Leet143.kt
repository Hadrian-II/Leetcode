package leetcode

import helpers.ListNode
import helpers.createList

fun main() {
    val r1 = createList(intArrayOf(1,2,3,4))
    reorderList(r1)
    val r2 = createList(intArrayOf(1,2,3,4,5))
    reorderList(r2)
    val blorp = 1
}

fun reorderList(head: ListNode?): Unit {
    if (head == null) {
        return
    }

    val nodes = ArrayDeque<ListNode>()
    var current = head.next
    while (current != null) {
        val next = current.next
        current.next = null
        nodes.add(current)
        current = next
    }

    var last = head
    var first = false
    while (nodes.isNotEmpty()) {
        val next = if (first) nodes.removeFirst() else nodes.removeLast()
        last!!.next = next
        last = next
        first = !first
    }
}