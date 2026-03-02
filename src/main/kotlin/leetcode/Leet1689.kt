package leetcode

fun main() {
    println(minPartitions("32"))
    println(minPartitions("82734"))
    println(minPartitions("27346209830709182346"))
}

fun minPartitions(n: String): Int {
    return n.maxOf { it.digitToInt() }
}