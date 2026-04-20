package leetcode

fun main() {
    println(mySqrt(4))
    println(mySqrt(8))
    println(mySqrt(2147395599))
}

fun mySqrt(x: Int): Int {
    var result = 0
    var closest = Long.MAX_VALUE
    var start = 1L
    var end = x.toLong()
    while (start <= end) {
        val mid = (start + end) / 2
        val distance = x - (mid * mid)
        if (distance == 0L) {
            return mid.toInt()
        }
        if (distance in 1..<closest) {
            result = mid.toInt()
            closest = distance
        }
        if (distance > 0) {
            start = mid + 1
        }  else {
            end = mid - 1
        }
    }
    return result
}