package leetcode

fun main() {
    println(buildArray(intArrayOf(1,3), 3))
    println(buildArray(intArrayOf(1,2,3), 3))
    println(buildArray(intArrayOf(1,2), 4))
}

fun buildArray(target: IntArray, n: Int): List<String> {
    val push = "Push"
    val pop = "Pop"
    val operations = ArrayList<String>()
    var i = 1
    for (t in target) {
        while (i < t) {
            operations.add(push)
            operations.add(pop)
            i++
        }
        operations.add(push)
        i++
    }
    return operations
}