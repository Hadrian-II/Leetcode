package leetcode

import helpers.readArrayOfArrays
import java.io.File
import kotlin.time.measureTime

fun main() {
    println(minReorder(6, readArrayOfArrays("[[0,1],[1,3],[2,3],[4,0],[4,5]]")))
    println(minReorder(5, readArrayOfArrays("[[1,0],[1,2],[3,2],[3,4]]")))
    println(minReorder(3, readArrayOfArrays("[[1,0],[2,0]]")))
    println(minReorder(4, readArrayOfArrays("[[0,1],[2,0],[3,2]]")))
    println(measureTime {
        println(minReorder(44667, readArrayOfArrays(File("src/main/kotlin/leetcode/input1466_72").readText())))
    })
}

fun minReorder(n: Int, connections: Array<IntArray>): Int {
    val cons = connections.groupBy({ it[1]}, {it[0]})
    val reversed = connections.groupBy({ it[0]}, {it[1]})
    return changes(0, cons, reversed, mutableSetOf())
}

fun changes(city: Int, cons: Map<Int, List<Int>>, reversed: Map<Int, List<Int>>, visited: MutableSet<Int>): Int {
    visited.add(city)
    var sum = 0
    for (correct in cons.getOrDefault(city, emptyList())) {
        if (correct !in visited) {
            sum += changes(correct, cons, reversed, visited)
        }
    }
    for (wrong in reversed.getOrDefault(city, emptyList())) {
        if (wrong !in visited) {
            sum++
            sum += changes(wrong, cons, reversed, visited)
        }
    }
    return sum
}
