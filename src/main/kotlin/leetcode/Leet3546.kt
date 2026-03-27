package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(canPartitionGrid(readArrayOfArrays("[[1,4],[2,3]]")))
    println(canPartitionGrid(readArrayOfArrays("[[1,3],[2,4]]")))
}

fun canPartitionGrid(grid: Array<IntArray>): Boolean {
    val resSet = mutableSetOf<Long>()
    var current = 0L
    for(i in grid.indices) {
        current += grid[i].sumOf { it.toLong() }
        resSet.add(current)
    }
    if (current % 2 == 1L) {
        return false
    }
    val target = current / 2
    if (target in resSet) {
        return true
    }


    current = 0L

    for(i in grid[0].indices) {
        current += grid.sumOf { it[i].toLong() }
        if (current >= target) {
            return current == target
        }
    }
    return false
}