package leetcode

fun main() {
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1), 1))     // true
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1), 2))     // false
    println(canPlaceFlowers(intArrayOf(1,0,1,0,1,0,1), 1)) // false
    println(canPlaceFlowers(intArrayOf(1,0,1,0,1,0,1), 0)) // true
    println(canPlaceFlowers(intArrayOf(0,0,1,0,1), 1))     // true
    println(canPlaceFlowers(intArrayOf(1,0,0,0,1,0,0), 2)) // true
}

fun canPlaceFlowers(flowerbed: IntArray, n: Int): Boolean {
    if (n == 0) {
        return true
    }
    var spaces = 1
    var planted = 0
    for (i in flowerbed) {
        if (i == 1) {
            spaces = 0
        } else {
            spaces += 1
            if (spaces == 3) {
                planted += 1
                spaces = 1
                if (planted == n) {
                    return true
                }
            }
        }
    }
    return spaces == 2 && planted + 1 == n
}