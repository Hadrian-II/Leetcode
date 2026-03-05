package leetcode

import kotlin.math.abs

fun main() {
    println(threeSumClosest(intArrayOf(-1,2,1,-4), 1))                  // 2
    println(threeSumClosest(intArrayOf(0,0,0), 1))                      // 0
    println(threeSumClosest(intArrayOf(1,1,1,1), 0))                    // 3
    println(threeSumClosest(intArrayOf(10,20,30,40,50,60,70,80,90), 1)) // 60
    println(threeSumClosest(intArrayOf(4,0,5,-5,3,3,0,-4,-5), -2))      // -2
    println(threeSumClosest(intArrayOf(-4,2,2,3,3,3), 0))               // 0
    println(threeSumClosest(intArrayOf(2,3,8,9,10), 16))                // 15
}

fun threeSumClosest(nums: IntArray, target: Int): Int {
    if (nums.size == 3) {
        return nums.sum()
    }

    val numbers = nums.sorted()

    val min = numbers[0] + numbers[1] + numbers[2]
    if (min > target) {
        return min
    }

    val max = numbers[numbers.size - 1] + numbers[numbers.size - 2] + numbers[numbers.size - 3]
    if (max < target) {
        return max
    }


    var closest = 100000
    var closestSum = -1

    var j = numbers.size - 1
    while(j >= 2) {
        var i = 0
        while (i < j - 1) {
            if (target - numbers[i] - numbers[j] >= numbers[i] - closest) {
                var low = i
                var high = j
                var mid = (high + low) / 2
                while (low < mid && mid < high) {
                    val sum = numbers[i] + numbers[j] + numbers[mid]
                    val diff = target - sum
                    val adiff = abs(diff)
                    if (adiff < closest) {
                        closest = adiff
                        closestSum = sum
                        if (closest == 0) {
                            return closestSum
                        }
                    }
                    if (diff < 0) {
                        high = mid
                    } else if (diff > 0) {
                        low = mid
                    } else {
                        break
                    }
                    mid = (high + low) / 2
                }
            }
            val old = numbers[i++]
            while (i < j - 1 && numbers[i] == old) {
                i++
            }
        }
        val old = numbers[j--]
        while (j >= 2 && numbers[j] == old) {
            j--
        }
    }
    return closestSum
}