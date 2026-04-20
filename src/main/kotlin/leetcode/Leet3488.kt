package leetcode

import java.io.File
import kotlin.math.abs
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(solveQueries(intArrayOf(1,3,1,4,1,3,2), intArrayOf(0,3,5)))
    println(solveQueries(intArrayOf(1,2,3,4), intArrayOf(0,1,2,3)))
    println(solveQueries(intArrayOf(2,10,20,20,20), intArrayOf(1,4,2)))
    println(solveQueries(intArrayOf(6,12,17,9,16,7,6), intArrayOf(5,6,0,4)))
    println(measureTime {
    println(solveQueries(IntArray(1000000) {1},
        File("src/main/kotlin/leetcode/input3488_612").readText()
                                                                         .split(",")
                                                                         .map { it.toInt()}
                                                                         .toIntArray()))
    })
}

fun solveQueries(nums: IntArray, queries: IntArray): List<Int> {
    val result = mutableListOf<Int>()
    val imap = nums.withIndex().groupBy({it.value}, {it.index})

    for (query in queries) {
        val ixs = imap[nums[query]]!!
        if (ixs.size == 1) {
            result.add(-1)
        } else {
            val myIx = ixOfNum(query, ixs)
            var distance = Int.MAX_VALUE
            if (myIx == 0 || myIx == ixs.lastIndex) {
                distance = abs(ixs.first() + nums.size - ixs.last())
            }

            if (myIx > 0) {
                distance = min(distance, ixs[myIx] - ixs[myIx - 1])
            }

            if (myIx < ixs.lastIndex) {
                distance = min(distance, ixs[myIx + 1] - ixs[myIx])
            }

            result.add(distance)
        }
    }

    return result
}

fun ixOfNum(num: Int, list: List<Int>): Int {
    var low = 0
    var high = list.lastIndex
    while (low <= high) {
        val mid = (low + high) / 2
        if (list[mid] == num) {
            return mid
        } else if (list[mid] > num) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }
    return Int.MAX_VALUE
}