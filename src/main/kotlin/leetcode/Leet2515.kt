package leetcode

fun main() {
    println(closestTarget(arrayOf("hello","i","am","leetcode","hello"), "hello", 1))
    println(closestTarget(arrayOf("a","b","leetcode"), "leetcode", 0))
    println(closestTarget(arrayOf("i","eat","leetcode"), "ate", 0))
}

fun closestTarget(words: Array<String>, target: String, startIndex: Int): Int {
    for (current in 0..words.size / 2) {
        if (words[(startIndex + current) % words.size] == target ||
            words[(words.size + startIndex - current) % words.size] == target) {
            return current
        }
    }

    return -1
}