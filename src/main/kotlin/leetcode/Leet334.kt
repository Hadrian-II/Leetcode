package leetcode

fun main() {
    println(increasingTriplet(intArrayOf(1,2,3,4,5)))
    println(increasingTriplet(intArrayOf(5,4,3,2,1)))
    println(increasingTriplet(intArrayOf(2,1,5,0,4,6)))
}

fun increasingTriplet(nums: IntArray): Boolean {
    var small = Int.MAX_VALUE
    var middle = Int.MAX_VALUE
    for (num in nums) {
        if (num > middle) {
            return true
        } else if (num > small) {
            middle = num
        } else {
            small = num
        }
    }
    return false
}