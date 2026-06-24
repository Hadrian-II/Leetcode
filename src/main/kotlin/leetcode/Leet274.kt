package leetcode

fun main() {
    println(hIndex(intArrayOf(3,0,6,1,5)))
    println(hIndex(intArrayOf(1,3,1)))
}

fun hIndex(citations: IntArray): Int {
    citations.sort()

    for (i in citations.indices) {
        if (citations[i] >= citations.size - i) {
            return citations.size - i
        }
    }

    return 0
}