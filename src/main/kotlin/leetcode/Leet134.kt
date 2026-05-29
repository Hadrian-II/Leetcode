package leetcode

fun main() {
    println(canCompleteCircuit(intArrayOf(1,2,3,4,5), intArrayOf(3,4,5,1,2)))
    println(canCompleteCircuit(intArrayOf(2,3,4), intArrayOf(3,4,3)))
}

fun canCompleteCircuit(gas: IntArray, cost: IntArray): Int {
    var total = 0
    var startOfPos = -1
    var current = 0

    for (i in gas.indices) {
        total += gas[i] - cost[i]
        current += gas[i] - cost[i]

        if (current < 0) {
            startOfPos = -1
            current = 0
        } else if (startOfPos == -1) {
            startOfPos = i
        }
    }

    return if (total >= 0) startOfPos else -1
}