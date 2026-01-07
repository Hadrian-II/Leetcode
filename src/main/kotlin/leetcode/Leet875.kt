package leetcode

fun main() {
    println(minEatingSpeed(intArrayOf(3,6,7,11), 8))          // 4
    println(minEatingSpeed(intArrayOf(30,11,23,4,20), 5))     // 30
    println(minEatingSpeed(intArrayOf(30,11,23,4,20), 6))     // 23
    println(minEatingSpeed(intArrayOf(312884470), 312884469)) // 2
    println(minEatingSpeed(intArrayOf(82,37), 6))             // 21
    println(minEatingSpeed(intArrayOf(805306368,805306368,805306368), 1000000000))             // 3
}

fun minEatingSpeed(piles: IntArray, h: Int): Int {
    val longPiles = piles.map { it.toLong() }
    var minSpeed = 1
    var maxSpeed = piles.max()
    val answers = ArrayList<Int>()
    while (minSpeed <= maxSpeed) {
        val nomSpeed = (maxSpeed + minSpeed) / 2
        val nomTime = longPiles.sumOf { ((it - 1)/ nomSpeed) + 1 }
        if (nomTime <= h) {
            maxSpeed = nomSpeed - 1
            answers.add(nomSpeed)
        } else {
            minSpeed = nomSpeed + 1
        }
    }
    return answers.min()
}