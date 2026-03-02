package leetcode

import helpers.ListNode
import helpers.createList
import helpers.printList

fun main() {
    printList(insertionSortList(createList(intArrayOf(4,2,1,3))))
    printList(insertionSortList(createList(intArrayOf(-1,5,3,4,0))))
}

fun insertionSortList(head: ListNode?): ListNode? {
    var answer = head!!
    var current = answer.next
    answer.next = null

    while (current != null) {
        val next = current.next
        current.next = null

        if (answer.`val` > current.`val`) {
            current.next = answer
            answer = current
        } else {
            var aptr = answer
            while ((aptr.next?.`val` ?: Int.MAX_VALUE) <= current.`val`) {
                aptr = aptr.next!!
            }
            current.next = aptr.next
            aptr.next = current
        }

        current = next
    }

    return answer
}