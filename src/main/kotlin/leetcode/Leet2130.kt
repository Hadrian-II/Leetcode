package leetcode

import helpers.ListNode
import helpers.createList
import kotlin.math.max

fun main() {
    println(pairSum(createList(intArrayOf(5,4,2,1))))
    println(pairSum(createList(intArrayOf(4,2,2,3))))
    println(pairSum(createList(intArrayOf(1,100000))))
}

fun pairSum(head: ListNode?): Int {
    var current = head
    var secondHalf = head
    var move = true
    while(current?.next != null) {
        if (move) {
            secondHalf = secondHalf!!.next
        }
        move = !move
        current = current.next
    }
    secondHalf = reverse(secondHalf!!)
    current = head
    var maxTwin = 0
    while (current != null) {
        maxTwin = max(maxTwin, current.`val` + (secondHalf?.`val` ?: 0))
        current = current.next
        secondHalf = secondHalf?.next
    }
    return maxTwin
}

fun reverse(head: ListNode): ListNode {
    var first = head
    var current = head.next
    first.next = null
    while (current != null) {
        val next = current.next
        current.next = first
        first = current
        current = next
    }
    return first
}