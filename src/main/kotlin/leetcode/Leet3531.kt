package leetcode

import helpers.readInput

fun main() {
    println(countCoveredBuildings(3, readInput("[[1,2],[2,2],[3,2],[2,1],[2,3]]")))
    println(countCoveredBuildings(3, readInput("[[1,1],[1,2],[2,1],[2,2]]")))
    println(countCoveredBuildings(1, readInput("[[1,3],[3,2],[3,3],[3,5],[5,3]]")))
}

fun countCoveredBuildings(n: Int, buildings: Array<IntArray>): Int {
    val bPoints = buildings.map { Pair(it[0], it[1]) }
    val rows = bPoints.groupBy ({ it.first })
    val possibleByRow = getPossibilities(rows, false)
    val columns = bPoints.groupBy { it.second }
    val possibleByColumn = getPossibilities(columns, true)
    return (possibleByRow.intersect(possibleByColumn)).size
}

private fun getPossibilities(rows: Map<Int, List<Pair<Int, Int>>>, isColumns: Boolean): Set<Pair<Int, Int>> {
    return rows.values.filter { it.size > 2 }
               .map { r -> r.sortedBy { if (isColumns) it.first else it.second } }
               .flatMap { it.subList(1, it.lastIndex) }.toSet()
}