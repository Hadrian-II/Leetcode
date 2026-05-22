package leetcode

fun main() {
    generate(5).forEach { println(it) }
}

fun generate(numRows: Int): MutableList<MutableList<Int>> {
    if (numRows == 1) {
        return mutableListOf(mutableListOf(1))
    } else {
        val previous = generate(numRows - 1)
        val current = mutableListOf(1)
        val last = previous.last()
        var i = 1
        while (i < last.size) {
            current.add(last[i - 1] + last[i])
            i++
        }

        current.add(1)
        previous.add(current)
        return previous
    }
}