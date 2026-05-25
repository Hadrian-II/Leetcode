package leetcode

import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(canReach("011010",2,3))
    println(canReach("01101110",2,3))
    println(canReach("00",1,1))
    println(measureTime {
        println(canReach("0".repeat(100000), 1, 99999))
    })
}

fun canReach(s: String, minJump: Int, maxJump: Int): Boolean {
    if (s.last() == '1') {
        return false
    }

    val visited = BooleanArray(s.length)
    var found = false

    fun jump(to: Int) {
        if (found) return
        visited[to] = true

        if (s[to] == '0') {
            var i = to + maxJump

            if (i >= visited.lastIndex) {
                if (to + minJump <= visited.lastIndex) {
                    found = true
                }
                return
            }

            while (i >= to + minJump) {
                if (!visited[i]) {
                    jump(i)
                }
                i--
            }
        }
    }
    jump(0)

    return found
}