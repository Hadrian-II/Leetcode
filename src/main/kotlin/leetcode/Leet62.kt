package leetcode

fun main() {
    println(uniquePaths(3, 7))
    println(uniquePaths(3, 2))
}

fun uniquePaths(m: Int, n: Int): Int {
    val pmap = Array(m) { IntArray(n) }
    for (i in 0..<m) {
        for (j in 0..<n) {
            pmap[i][j] = if (i == 0 && j == 0) {
                1
            } else if (i > 0 && j > 0) {
                pmap[i - 1][j] + pmap[i][j - 1]
            } else if (i > 0) {
                pmap[i - 1][j]
            } else {
                pmap[i][j - 1]
            }
        }
    }
    return pmap[m - 1][n - 1]
}