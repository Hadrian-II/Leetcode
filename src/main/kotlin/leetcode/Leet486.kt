package leetcode

import kotlin.math.max
import kotlin.math.min

fun main() {
    println(Solution486().predictTheWinner(intArrayOf(1,5,2)))
    println(Solution486().predictTheWinner(intArrayOf(1,5,233,7)))
    println(Solution486().predictTheWinner(intArrayOf(1,1)))
    println(Solution486().predictTheWinner(intArrayOf(1,5,2,4,6)))
}

class Solution486 {
    lateinit var nums: IntArray

    fun predictTheWinner(nums: IntArray): Boolean {
        if (nums.size == 1) {
            return true
        }

        this.nums = nums
        return p1Wins(0, 0, 0, nums.lastIndex, true)
    }

    fun p1Wins(p1score: Int, p2score: Int, start: Int, end: Int, p1Turn: Boolean): Boolean {
        val sNum = nums[start]
        val eNum = nums[end]
        return if (start + 1 == end) {
            if (p1Turn) {
                p1score + max(sNum, eNum) >= p2score + min(sNum, eNum)
            } else {
                p1score + min(sNum, eNum) >= p2score + max(sNum, eNum)
            }
        } else if (p1Turn) {
            p1Wins(p1score + sNum, p2score, start + 1, end, false) || p1Wins(p1score + eNum, p2score, start, end - 1, false)
        } else {
            p1Wins(p1score, p2score + sNum, start + 1, end, true) && p1Wins(p1score, p2score + eNum, start, end - 1, true)
        }
    }
}