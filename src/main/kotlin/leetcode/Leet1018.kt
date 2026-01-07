package leetcode

import java.math.BigInteger

fun main() {
    println(prefixesDivBy5(intArrayOf(1,0,1))) // [false,false,true]
    println(prefixesDivBy5(intArrayOf(0,1,1))) // [true,false,false]
    println(prefixesDivBy5(intArrayOf(1,1,1))) // [false,false,false]
    println(prefixesDivBy5(intArrayOf(1,0,0,1,0,1,0,0,1,0,1,1,1,1,1,1,1,1,1,1,0,0,0,0,1,0,1,0,0,0,0,1,1,0,1,0,0,0,1)))
    // [false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,false,true,false,false,true,true,true,true,false]
}

fun prefixesDivBy5(nums: IntArray): List<Boolean> {
    val bigZero = BigInteger.valueOf(0)
    val bigFive = BigInteger.valueOf(5)
    val results = ArrayList<Boolean>()
    var sum = bigZero
    for (num in nums) {
        sum += num.toBigInteger()
        //println(sum)
        results.add(sum % bigFive == bigZero)
        sum = sum shl 1
    }
    return results;
}