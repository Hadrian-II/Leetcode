package leetcode

fun main() {
    println(Solution856().scoreOfParentheses("()"))
    println(Solution856().scoreOfParentheses("(())"))
    println(Solution856().scoreOfParentheses("()()"))
}

class Solution856 {
    class Char(var value: Int) {
        var prev: Char? = null
        var next: Char? = null

        companion object {
            const val OPEN = -1
            const val CLOSE = -2
        }

        override fun toString(): String {
            return when (value) {
                OPEN -> "("
                CLOSE -> ")"
                else -> value.toString()
            }
        }
    }

    fun scoreOfParentheses(s: String): Int {
        val factory = Char(0)
        var current = factory

        var i = 0
        while (i <= s.lastIndex) {
            val c = s[i]
            if (c == '(') {
                current.next = Char(Char.OPEN)
            } else {
                current.next = Char(Char.CLOSE)
            }
            current.next!!.prev = current
            current = current.next!!
            i++
        }

        while (factory.next?.next != null) {
            current = factory.next!!
            while (current.next != null) {
                if (current.value == Char.OPEN && current.next?.value == Char.CLOSE) {
                    current.value = 1
                    current.next = current.next!!.next
                    current.next?.prev = current
                } else if (current.value > 0 && current.prev?.value == Char.OPEN && current.next?.value == Char.CLOSE) {
                    current.prev!!.value = current.value * 2
                    current.prev!!.next = current.next!!.next
                    current.prev!!.next?.prev = current
                    current = current.prev!!
                } else if (current.value > 0 && current.next!!.value > 0) {
                    current.value += current.next!!.value
                    current.next = current.next!!.next
                    current.next?.prev = current
                } else {
                    current = current.next!!
                }
            }
        }

        return factory.next!!.value
    }
}