package leetcode

fun main() {
    println(mapWordWeights(arrayOf("abcd","def","xyz"), intArrayOf(5,3,12,14,1,2,3,2,10,6,6,9,7,8,7,10,8,9,6,9,9,8,3,7,7,2)))
    println(mapWordWeights(arrayOf("a","b","c"), intArrayOf(1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1)))
    println(mapWordWeights(arrayOf("abcd"), intArrayOf(7,5,3,4,3,5,4,9,4,2,2,7,10,2,5,10,6,1,2,2,4,1,3,4,4,5)))
}

fun mapWordWeights(words: Array<String>, weights: IntArray): String {
    val result = StringBuilder()
    for (word in words) {
        var sum = 0
        for (c in word) {
            sum += weights[c - 'a']
        }
        sum %= 26
        result.append('z' - sum)
    }
    return result.toString()
}