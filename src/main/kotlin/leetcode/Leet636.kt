package leetcode

import helpers.printIntArray

fun main() {
    printIntArray(exclusiveTime(2, listOf("0:start:0","1:start:2","1:end:5","0:end:6")))
    printIntArray(exclusiveTime(1, listOf("0:start:0","0:start:2","0:end:5","0:start:6","0:end:6","0:end:7")))
    printIntArray(exclusiveTime(2, listOf("0:start:0","0:start:2","0:end:5","1:start:6","1:end:6","0:end:7")))
}

fun exclusiveTime(n: Int, logs: List<String>): IntArray {
    val result = IntArray(n)
    val callStack = ArrayDeque<Int>()
    var currentTime = 0
    for (log in logs) {
        val processed = log.split(":")
        val start = processed[1][0] == 's'
        val newTime = processed[2].toInt() + if (start) 0 else 1
        result[callStack.lastOrNull() ?: 0] += newTime - currentTime
        currentTime = newTime
        if (start) {
            callStack.add(processed[0].toInt())
        } else {
            callStack.removeLast()
        }
    }

    return result
}