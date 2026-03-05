package leetcode

fun main() {
    threeSum(intArrayOf(-1,0,1,2,-1,-4)).forEach { println(it)}
    println("----------")
    threeSum(intArrayOf(0,1,1)).forEach { println(it)}
    println("----------")
    threeSum(intArrayOf(0,0,0)).forEach { println(it)}
    println("----------")
    threeSum(intArrayOf(2,-3,0,-2,-5,-5,-4,1,2,-2,2,0,2,-4,5,5,-10)).forEach { println(it)}
}

fun threeSum(nums: IntArray): List<List<Int>> {
    val numbers = mutableMapOf<Int, Int>()
    for (num in nums) {
        numbers[num] = (numbers[num] ?: 0) + 1
    }
    val keys = numbers.keys.sorted()
    var i = 0
    val triplets = mutableSetOf<List<Int>>()
    if ((numbers[0] ?: -1) > 2) {
        triplets.add(listOf(0,0,0))
    }
    while (i < keys.size && keys[i] < 0) {
        var j = if(numbers[keys[i]]!! > 1) i else i + 1
        while(j < keys.size) {
            val mirror = (keys[i] + keys[j]) * -1
            if (mirror <= 0) {
                break
            }
            if (mirror in numbers &&
                !(mirror == keys[i] && numbers[keys[i]]!! < 2) &&
                !(mirror == keys[j] && numbers[keys[j]]!! < 2)) {
                triplets.add(listOf(keys[i], keys[j], mirror).sorted())
            }
            j++
        }
        i++
    }
    return triplets.toList()
}