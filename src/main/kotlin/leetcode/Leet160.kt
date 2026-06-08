package leetcode

import helpers.ListNode

fun main() {

}

fun getIntersectionNode(headA: ListNode?, headB:ListNode?): ListNode? {
    val visited = mutableSetOf<ListNode>()
    var lastA = headA
    while (lastA != null) {
        visited.add(lastA)
        lastA = lastA.next
    }

    var lastB = headB
    while (lastB != null) {
        if (lastB in visited) {
            return lastB
        }
        lastB = lastB.next
    }

    return null
}