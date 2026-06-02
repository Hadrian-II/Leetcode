package leetcode

import helpers.ListNode

fun detectCycle(head: ListNode?): ListNode? {
    val visited = mutableSetOf<ListNode>()
    var current = head
    while (current != null) {
        if (current in visited) {
            return current
        } else {
            visited.add(current)
        }
        current = current.next
    }
    return null
}