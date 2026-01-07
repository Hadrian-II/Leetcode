package leetcode

fun main() {
    val obj = RecentCounter()
    println(obj.ping(1))
    println(obj.ping(100))
    println(obj.ping(3001))
    println(obj.ping(3002))
}

class RecentCounter() {
    val count = ArrayDeque<Int>()
    val timeout = 3000

    fun ping(t: Int): Int {
        while (count.isNotEmpty()) {
            if (count.first() < t - timeout) {
                count.removeFirst()
            } else {
                break
            }
        }
        count.addLast(t)
        return count.size
    }
}