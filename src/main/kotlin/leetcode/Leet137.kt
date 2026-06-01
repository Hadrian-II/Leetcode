package leetcode

fun main() {
    println(Solution137().singleNumber(intArrayOf(2,2,3,2)))
    println(Solution137().singleNumber(intArrayOf(0,1,0,1,0,1,99)))
}

class Solution137 {
    fun singleNumber(nums: IntArray): Int {
        val count = IntArray(32)
        val mask = IntArray(32)
        var current = 1
        for (i in 0..mask.lastIndex) {
            mask[i] = current
            current = current.shl(1)
        }

        for (num in nums) {
            for (i in mask.indices) {
                val currentMask = mask[i]
                if (num.and(currentMask) == currentMask) {
                    count[i] = if (count[i] == 2) {
                        0
                    } else {
                        count[i] + 1
                    }
                }
            }
        }

        return count.indices.filter { count[it] == 1 }.sumOf { mask[it] }
    }
}