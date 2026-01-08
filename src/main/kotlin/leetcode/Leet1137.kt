package leetcode

fun main() {
    println(Solution1137().tribonacci(4))
    println(Solution1137().tribonacci(25))
}

class Solution1137 {
    val memo = HashMap<Int, Int>()
    fun tribonacci(n: Int): Int {
        return memo.getOrPut(n) {
            when (n) {
                0 -> {
                    0
                }

                1 -> {
                    1
                }

                2 -> {
                    1
                }

                else -> tribonacci(n - 1) + tribonacci(n - 2) + tribonacci(n - 3)
            }
        }
    }
}