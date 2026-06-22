package leetcode

import helpers.ListNode

fun main() {

}

fun deleteNode(node: ListNode?) {
    requireNotNull(node)
    node.`val` = node.next!!.`val`
    if (node.next!!.next == null) {
        node.next = null
    } else {
        node.next = node.next!!.next
    }
}