package leetcode

fun main() {
    println(countPermutations(intArrayOf(1,2,3)))       // 2
    println(countPermutations(intArrayOf(3,3,3,4,4,4))) // 0
    println(countPermutations(intArrayOf(2,68,61)))     // 2
    println(countPermutations(intArrayOf(38,223,100,123,406,234,256,93,222,259,233,69,139,245,45,98,214)))     // 789741546
}

fun countPermutations(complexity: IntArray): Int {
    val DIVISOR = 1000000007
    val min = complexity.min()
    if (complexity[0] > complexity.min() || (complexity[0] == min && complexity.count { it == min } > 1)) {
        return 0
    }
    var perms = 1.0
    for (i in 2..<complexity.size) {
        perms *= i
        perms %= DIVISOR
    }
    return perms.toInt()
}