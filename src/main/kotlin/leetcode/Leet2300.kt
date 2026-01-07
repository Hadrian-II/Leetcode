package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(Solution2300().successfulPairs(intArrayOf(5,1,3), intArrayOf(1,2,3,4,5), 7))
    printIntArray(Solution2300().successfulPairs(intArrayOf(3,1,2), intArrayOf(8,5,8), 16))
}

class Solution2300 {
    var succ = 0L
    lateinit var sortedPotions: List<Long>

    fun successfulPairs(spells: IntArray, potions: IntArray, success: Long): IntArray {
        succ = success
        sortedPotions = potions.map { it.toLong() }.sorted()
        return spells.map { sortedPotions.size - firstSuccesful(it) }.toIntArray()
    }

    fun firstSuccesful(spellPower: Int): Int {
        var low = 0
        var high = sortedPotions.lastIndex
        while (low <= high) {
            val mid = (high + low) / 2
            if (sortedPotions[mid] * spellPower >= succ) {
                if (mid == 0 || sortedPotions[mid - 1] * spellPower < succ) {
                    return mid
                } else {
                    high = mid - 1
                }
            } else {
                low = mid + 1
            }
        }
        return sortedPotions.size
    }
}