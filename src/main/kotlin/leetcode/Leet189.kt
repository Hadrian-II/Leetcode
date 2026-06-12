package leetcode

fun main() {
    val r1 = intArrayOf(1,2,3,4,5,6,7)
    rotate(r1, 3)
    val r2 = intArrayOf(-1, -100, 3, 99)
    rotate(r2, 2)
    val blah = 4
}

fun rotate(nums: IntArray, k: Int): Unit {
    if (k == 0 || k == nums.size) {
        return
    }
    val visited = BooleanArray(nums.size)

    val rotation = k % nums.size
    for (i in 0..rotation) {
        var current = i + rotation
        var last = nums[i]
        while (true) {
            if (current >= nums.size) {
                current -= nums.size
            }
            if (visited[current]) {
                break
            } else {
                visited[current] = true
            }
            val currentNr = nums[current]
            nums[current] = last
            last = currentNr
            current += rotation
        }
    }
}