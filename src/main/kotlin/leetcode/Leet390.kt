package leetcode

fun main() {
    println(lastRemaining(9))
    println(lastRemaining(1))
}

fun lastRemaining(n: Int): Int {
    var start = 1
    var end = n
    var step = 1
    while (start != end) {
        if (((end - start) / step) % 2 == 0) {
            end -= step
        }
        start += step
        step *= -2
        val buf = start
        start = end
        end = buf
    }
    return start
}