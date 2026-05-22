package leetcode

fun main() {
    println(getRow(3))
}

fun getRow(rowIndex: Int): List<Int> {
    if (rowIndex == 0) {
        return listOf(1)
    } else {
        val last = getRow(rowIndex  - 1)
        val current = mutableListOf(1)

        for(i in 1..last.lastIndex) {
            current.add(last[i - 1] + last[i])
        }

        current.add(1)
        return current
    }
}