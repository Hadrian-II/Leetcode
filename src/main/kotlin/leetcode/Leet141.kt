package leetcode

import helpers.ListNode

fun main() {

}

fun hasCycle(head: ListNode?): Boolean {
    val visited = mutableSetOf<ListNode>()
    var current = head
    while (current != null) {
        if (current in visited) {
            return true
        } else {
            visited.add(current)
        }
        current = current.next
    }
    return false
}