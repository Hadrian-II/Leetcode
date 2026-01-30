package leetcode

fun main() {
    println(validMountainArray(intArrayOf(2,1)))
    println(validMountainArray(intArrayOf(3,5,5)))
    println(validMountainArray(intArrayOf(0,3,2,1)))
    println(validMountainArray(intArrayOf(1,1,1,1,1,1,1,2,1)))
}

fun validMountainArray(arr: IntArray): Boolean {
    if (arr.size == 1) {
        return false
    }
    var current = arr[0]
    var up = false
    var down = false
    for (i in 1..arr.lastIndex) {
        val nr = arr[i]
        if (nr > current) {
            if (down) {
                return false
            } else {
                up = true
            }
        } else if (nr < current) {
            if (!up) {
                return false
            } else {
                down = true
            }
        } else {
            return false
        }
        current = nr
    }
    return up && down
}