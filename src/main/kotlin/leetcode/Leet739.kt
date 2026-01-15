package leetcode

import helpers.printIntArray
import java.util.PriorityQueue
import kotlin.math.min

fun main() {
    printIntArray(dailyTemperatures(intArrayOf(73,74,75,71,69,72,76,73)))
    printIntArray(dailyTemperatures(intArrayOf(30,40,50,60)))
    printIntArray(dailyTemperatures(intArrayOf(30,60,90)))
}

fun dailyTemperatures(temperatures: IntArray): IntArray {
    val minStack = PriorityQueue<Pair<Int, Int>>(compareBy { it.second })
    val result = IntArray(temperatures.size) { 0 }
    for (i in temperatures.indices) {
        while (minStack.isNotEmpty() && minStack.peek().second  < temperatures[i]) {
            val colder = minStack.poll()
            result[colder.first] = i - colder.first
        }
        minStack.add(Pair(i, temperatures[i]))
    }
    return result
}