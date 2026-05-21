package leetcode

import java.io.File
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(Solution1345().minJumps(intArrayOf(100,-23,-23,404,100,23,23,23,3,404)))
    println(Solution1345().minJumps(intArrayOf(7)))
    println(Solution1345().minJumps(intArrayOf(7,6,9,6,9,6,9,7)))
    println(measureTime {
        println(
            Solution1345().minJumps(
                File("src/main/kotlin/leetcode/input1345_22").readText().split(",").map { it.toInt() }.toIntArray()
            )
        )
    })
    println(measureTime {
        println(
            Solution1345().minJumps(
                IntArray(66666) {66} + intArrayOf(77)
            )
        )
    })
    println(measureTime {
        println(
            Solution1345().minJumps(
                (1..25000).toList().flatMap { listOf(1, 2) }.toIntArray() + intArrayOf(3, 4)
            )
        )
    })
}

class Solution1345() {
    val jumpMap = HashMap<Int, MutableList<Int>>()
    lateinit var results: BooleanArray
    var moves = mutableSetOf(0)

    fun minJumps(arr: IntArray): Int {
        if (arr.size == 1) {
            return 0
        }
        jumpMap[arr.first()] = mutableListOf(0)
        var i = 1
        var current = arr.first()
        var currentStart = 0
        while (i < arr.size) {
            val value = arr[i]
            if (value !in jumpMap) {
                jumpMap[value] = mutableListOf()
            }

            if (value != current) {
                if (i - 1 > currentStart) {
                    jumpMap[current]!!.add(i - 1)
                }

                jumpMap[value]!!.add(i)
                current = value
                currentStart = i
            }

            i++
        }
        if (currentStart != arr.lastIndex) {
            jumpMap[current]!!.add(arr.lastIndex)
        }

        results = BooleanArray(arr.size) { true }

        var steps = 1
        while (true) {
            val newMoves = mutableSetOf<Int>()
            for (where in moves) {
                results[where] = false

                if (arr[where] in jumpMap) {
                    for (pos in jumpMap[arr[where]]!!) {
                        if (results[pos]) {
                            if (pos == arr.lastIndex) {
                                return steps
                            }
                            newMoves.add(pos)
                        }
                    }
                    jumpMap.keys.remove(arr[where])
                }

                if (where > 0) {
                    if (results[where - 1]) {
                        newMoves.add(where - 1)
                    }
                }

                if (where < results.lastIndex) {
                    if (results[where + 1]) {
                        if (where + 1 == results.lastIndex) {
                            return steps
                        }
                        newMoves.add(where + 1)
                    }
                }
            }
            moves = newMoves
            steps++
        }
    }
}