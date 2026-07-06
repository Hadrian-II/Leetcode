package leetcode

fun main() {
    println(Solution306().isAdditiveNumber("112358"))
    println(Solution306().isAdditiveNumber("199100199"))
    println(Solution306().isAdditiveNumber("0"))
    println(Solution306().isAdditiveNumber("101"))
    println(Solution306().isAdditiveNumber("000"))
    println(Solution306().isAdditiveNumber("011112"))
}

class Solution306 {
    private lateinit var nums: List<Long>

    fun isAdditiveNumber(num: String): Boolean {
        if (num.length < 3) {
            return false
        }

        nums = num.map { it.digitToInt().toLong() }
        var current = 0L
        var i = 0
        while (i <= nums.size / 3) {
            current *= 10
            current += nums[i]
            i++
            if (startWidth(i, current)) {
                return true
            }
            if (current == 0L) {
                break
            }
        }
        return false
    }

    fun startWidth(start: Int, first: Long): Boolean {
        var current = nums[start]
        var j = 1
        while (j <= (nums.size - start) / 2) {
            if (canFinish(start + j, first, current)) {
                return true
            }
            if (current == 0L) {
                break
            }
            current *= 10
            current += nums[start + j]
            j++
        }
        return false
    }

    fun canFinish(start: Int, first: Long, second: Long): Boolean {
        var current = nums[start]
        val target = first + second
        if (current == 0L) {
            return target == 0L
        }
        var i = start + 1
        while (current < target && i <= nums.lastIndex) {
            current *= 10
            current += nums[i]
            i++
        }
        return if (current == target) {
            if (i > nums.lastIndex) true else canFinish(i, second, current)
        } else {
            false
        }
    }
}