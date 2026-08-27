package leetcode

import kotlin.math.min

fun main() {
    println(Solution365().canMeasureWater(3, 5, 4))
    println(Solution365().canMeasureWater(2, 6, 5))
    println(Solution365().canMeasureWater(1, 2, 3))
}

class Solution365 {
    val processed = mutableSetOf<Int>()
    var x: Int = 0
    var y: Int = 0
    var target: Int = 0

    fun canMeasureWater(x: Int, y: Int, target: Int): Boolean {
        this.x = x
        this.y = y
        this.target = target

        val r = solve(0, 0)
        return r
    }

    fun solve(first: Int, second: Int): Boolean {
        val key = first * (y + 1) + second
        if (key in processed) {
            return false
        }
        processed.add(key)
        if (first + second == target) {
            return true
        }
        if (first != x && solve(x, second)) {
            return true
        } else if (first != 0 && solve(0, second)) {
            return true
        } else if (first != 0 && second != y) {
            val pour = min(first, y - second)
            if (solve(first - pour, second + pour)) {
                return true
            }
        } else if (second !=y && solve(first, y)) {
            return true
        } else if (second != 0 && solve(first, 0)) {
            return true
        } else if (second != 0 && first != x) {
            val pour = min(second, x - first)
            if(solve(first + pour, second - pour)) {
                return true
            }
        }
        return false
    }
}