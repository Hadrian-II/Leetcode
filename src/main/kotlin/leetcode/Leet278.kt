package leetcode

fun main() {

}


fun isBadVersion(version: Int): Boolean {
    return false
}

fun firstBadVersion(n: Int) : Int {
    var low = 1
    var high = n

    while (low <= high) {
        val mid = low + (high - low) / 2

        if (isBadVersion(mid)) {
            high = mid - 1
        } else {
            low = mid + 1
        }
    }

    return low
}