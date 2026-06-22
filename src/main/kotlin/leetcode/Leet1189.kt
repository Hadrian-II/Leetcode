package leetcode

fun main() {
    println(maxNumberOfBalloons("nlaebolko"))
    println(maxNumberOfBalloons("loonbalxballpoon"))
    println(maxNumberOfBalloons("leetcode"))
}

fun maxNumberOfBalloons(text: String): Int {
    var b = 0
    var a = 0
    var l = 0
    var o = 0
    var n = 0
    for (c in text) {
        when(c) {
            'b' -> b++
            'a' -> a++
            'l' -> l++
            'o' -> o++
            'n' -> n++
        }
    }
    return minOf(b,a,l / 2,o / 2,n)
}