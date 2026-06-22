package leetcode

import kotlin.math.abs
import kotlin.math.min

fun main() {
    println(angleClock(12, 30))
    println(angleClock(3, 30))
    println(angleClock(3, 15))
    println(angleClock(1, 57))
}

fun angleClock(hour: Int, minutes: Int): Double {
    val minute = (minutes % 60) / 60.0
    val hours = ((hour + minute) % 12) / 12.0
    val angle = abs(hours - minute)
    return 360.0 * min(angle, 1 - angle)
}