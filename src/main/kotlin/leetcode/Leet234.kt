package leetcode

import helpers.ListNode
import helpers.createList

fun main() {
    println(isPalindrome(createList(intArrayOf(1,2,2,1))))
    println(isPalindrome(createList(intArrayOf(1,2))))
}

fun isPalindrome(head: ListNode?): Boolean {
    val values = mutableListOf<Int>()
    var current = head
    while (current != null) {
        values.add(current.`val`)
        current = current.next
    }
    for (i in 0..values.size / 2) {
        if (values[i] != values[values.lastIndex - i]) {
            return false
        }
    }
    return true
}