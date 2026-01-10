package leetcode

import helpers.printIntArray
import kotlin.math.min

fun main() {
    println(Solution712().minimumDeleteSum("sea", "eat"))
    println(Solution712().minimumDeleteSum("delete", "leet"))
}

class Solution712 {
    lateinit var t1: CharArray
    lateinit var t2: CharArray
    val memo = HashMap<Pair<Int, Int>, Int>()

    fun minimumDeleteSum(s1: String, s2: String): Int {
        val r1 = clean(s1, s2)
        t1 = r1.second
        var result = r1.first
        val r2 = clean(s2, s1)
        t2 = r2.second
        result += r2.first
        return result + mds(0, 0)
    }

    private fun clean(s1: String, s2: String): Pair<Int, CharArray> {
        val check = s2.toSet()
        val r = s1.fold(Pair(0, mutableListOf<Char>())) { r, ch ->
            if (ch in check) {
                r.second.add(ch)
                r
            } else {
                Pair(r.first + ch.code, r.second)
            }
        }
        return Pair(r.first, r.second.toCharArray())
    }

    fun mds(i: Int, j: Int): Int {
        return memo.getOrPut(Pair(i, j)) {
            if (i == t1.size && j == t2.size) {
                0
            } else if (i == t1.size) {
                t2.slice(j..t2.lastIndex).sumOf { it.code }
            } else if (j == t2.size) {
                t1.slice(i..t1.lastIndex).sumOf { it.code }
            } else {
                if (t1[i] == t2[j]) {
                    mds(i + 1, j + 1)
                } else {
                    min(t1[i].code + mds(i + 1, j),
                        t2[j].code + mds(i, j + 1))
                }
            }
        }
    }
}