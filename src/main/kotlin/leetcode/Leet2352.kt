package leetcode

fun main() {
    println(equalPairs(arrayOf(intArrayOf(3,2,1), intArrayOf(1,7,6), intArrayOf(2,7,7))))
    println(equalPairs(arrayOf(intArrayOf(3,1,2,2), intArrayOf(1,4,4,5), intArrayOf(2,4,2,2), intArrayOf(2,4,2,2))))
}

fun equalPairs(grid: Array<IntArray>): Int {
    val rowMap = grid.map { it.joinToString { n -> n.toString() } }
                     .groupingBy { it }.eachCount()
    return grid.indices.map { col -> grid.indices.map { row -> grid[row][col] }.joinToString() }
                       .sumOf { rowMap[it] ?: 0 }
}