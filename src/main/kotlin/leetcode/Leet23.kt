package leetcode

import helpers.ListNode
import java.util.PriorityQueue

fun main() {

}

fun mergeKLists(lists: Array<ListNode?>): ListNode? {
    val base = ListNode(0)
    var current = base
    val queue = PriorityQueue<ListNode>(compareBy { it.`val` })

    for (list in lists) {
        if (list != null) {
            queue.add(list)
        }
    }

    while (queue.isNotEmpty()) {
        val next = queue.poll()
        current.next = next
        if (next.next != null) {
            queue.add(next.next)
        }
        current = current.next!!
        current.next == null
    }

    return base.next
}