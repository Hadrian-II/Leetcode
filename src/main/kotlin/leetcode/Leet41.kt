package leetcode

fun main() {
    println(firstMissingPositive(intArrayOf(1,2,0)))       // 3
    println(firstMissingPositive(intArrayOf(1,2,3)))       // 4
    println(firstMissingPositive(intArrayOf(3,4,-1,1)))    // 2
    println(firstMissingPositive(intArrayOf(7,8,9,11,12))) // 1
    println(firstMissingPositive(intArrayOf(1)))           // 2
    println(firstMissingPositive(intArrayOf(-1, -2)))      // 1
    println(firstMissingPositive(intArrayOf(2, 2)))        // 1
    println(firstMissingPositive(intArrayOf(0,-1,3,1)))    // 2
    println(firstMissingPositive(intArrayOf(100000, 3, 4000, 2, 15, 1, 99999)))    // 4
    println(firstMissingPositive(intArrayOf(1,1)))         // 2
    println(firstMissingPositive(intArrayOf(10,4,16,54,17,-7,21,15,25,31,61,1,6,12,21,46,16,56,54,12,23,20,38,63,2,27,35,11,13,47,13,11,61,39,0,14,42,8,16,54,50,12,-10,43,11,-1,24,38,-10,13,60,0,44,11,50,33,48,20,31,-4,2,54,-6,51,6)))         // 2
}

fun firstMissingPositive(nums: IntArray): Int {
    val mark = -666666
    var foundSize = false
    for (i in nums.indices) {
        if (nums[i] == mark) {
            nums[i] = -1
        }
    }

    for (i in nums.indices) {
        if (nums[i] == nums.size) {
            foundSize = true
        } else if (0 < nums[i] && nums[i] < nums.size) {
            if (nums[i] < i || nums[i] > nums.size) {
                nums[nums[i]] = mark
            } else {
                var replaced = nums[i]
                while (replaced > i && replaced < nums.size) {
                    val buffer = nums[replaced]
                    nums[replaced] = mark
                    if (buffer == mark || buffer >= nums.size || buffer < 0) {
                        if (buffer == nums.size) {
                            foundSize = true
                        }
                        break
                    } else {
                        replaced = buffer
                    }
                }
                if (nums[replaced] == nums.size) {
                    foundSize = true
                }
                nums[replaced] = mark
            }
        }
        if (nums[i] != mark) {
            nums[i] = 0
        }
    }

    var i = 1
    while (i <= nums.lastIndex) {
        if (nums[i] == 0) {
            return i
        }
        i++
    }

    return if (foundSize) nums.size + 1 else nums.size
}