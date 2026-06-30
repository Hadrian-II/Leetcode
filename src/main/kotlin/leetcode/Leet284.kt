package leetcode

fun main() {
    val i = PeekingIterator(listOf(1,2,3).iterator())
    println(i.next())
    println(i.peek())
    println(i.next())
    println(i.next())
    println(i.hasNext())
}

class PeekingIterator(var iterator:Iterator<Int>):Iterator<Int> {
    private var peeked: Int? = null

    fun peek(): Int {
        if (peeked == null) {
            peeked = iterator.next()
        }

        return peeked!!
    }

    override fun next(): Int {
        return if (peeked != null) {
            val ret = peeked!!
            peeked = null
            ret
        } else {
            iterator.next()
        }
    }

    override fun hasNext(): Boolean {
        return peeked != null || iterator.hasNext()
    }
}
