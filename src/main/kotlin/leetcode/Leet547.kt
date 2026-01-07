package leetcode

import helpers.readArrayOfArrays
import kotlin.math.min
import kotlin.math.max

fun main () {
    println(findCircleNum(readArrayOfArrays("[[1,1,0],[1,1,0],[0,0,1]]")))
    println(findCircleNum(readArrayOfArrays("[[1,0,0],[0,1,0],[0,0,1]]")))
    println(findCircleNum(readArrayOfArrays("[[1,0,0,1],[0,1,1,0],[0,1,1,1],[1,0,1,1]]")))
}

fun findCircleNum(isConnected: Array<IntArray>): Int {
    val connections = isConnected.flatMapIndexed { i, col -> col.mapIndexed { j, isConnected -> Triple(i, j, isConnected) } }
                                 .filter { it.third == 1 && it.first != it.second }.map { Pair(min(it.first, it.second), max(it.first, it.second)) }
    val mapped = HashSet<Int>()
    var provinces = 0
    while (mapped.size < isConnected.size) {
        provinces++
        for (i in isConnected.indices) {
            if (i in mapped) {
                continue
            }
            map(i, mapped, connections)
            break
        }
    }
    return provinces
}

fun map(i: Int, mapped: HashSet<Int>, connections: List<Pair<Int, Int>>) {
    mapped.add(i)
    connections.filter { it.first == i && it.second !in mapped }.forEach { map(it.second, mapped, connections) }
    connections.filter { it.second == i && it.first !in mapped }.forEach { map(it.first, mapped, connections) }
}
