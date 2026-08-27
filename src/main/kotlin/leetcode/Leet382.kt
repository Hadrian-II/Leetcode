package leetcode

import helpers.ListNode
import kotlin.random.Random

class Solution382(head: ListNode?) {
    val numbers = mutableListOf<Int>()

    init {
        var current = head
        while (current != null) {
            numbers.add(current.`val`)
            current = current.next
        }
    }

    fun getRandom(): Int {
        return numbers[Random.nextInt(numbers.size)]
    }
}