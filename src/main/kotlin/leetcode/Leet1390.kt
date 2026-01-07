package leetcode

import java.io.File
import kotlin.math.sqrt
import kotlin.time.measureTime

fun main() {
    println(Solution1390().sumFourDivisors(intArrayOf(21,4,7))) // 32
    println(Solution1390().sumFourDivisors(intArrayOf(21,21))) // 64
    println(Solution1390().sumFourDivisors(intArrayOf(1,2,3,4,5))) // 0
    println(Solution1390().sumFourDivisors(intArrayOf(1,2,3,4,5,6,7,8,9,10))) // 45
    println(Solution1390().sumFourDivisors(intArrayOf(7286,18704,70773,8224,91675))) // 10932
    println(measureTime { println(Solution1390().sumFourDivisors(File("src/main/kotlin/leetcode/input1390_17").readText().split(",").map { it.toInt() }.toIntArray()))}) // 134716980
}

class Solution1390 {
    lateinit var primes: IntArray

    fun sumFourDivisors(nums: IntArray): Int {
        primes = loadPrimes(nums.max())
        val divisors = nums.map { divisors(it) }.filter { it.size in 2..3 }
        var sum = 0
        for (divisor in divisors) {
            if (divisor.size == 2 && divisor[0] != divisor[1]) {
                sum += 1 + divisor[0] + divisor[1] + divisor[0] * divisor[1]
            }
            else if (divisor.size == 3 && divisor[0] == divisor[1] && divisor[1] == divisor[2]) {
                sum += 1 + divisor[0] + divisor[0] * divisor[0] + divisor[0] * divisor[0] * divisor[0]
            }
        }
        return sum
    }

    fun divisors(number: Int): IntArray {
        var procNumber = number
        val divisors = ArrayList<Int>()
        val sqrt = sqrt(number.toDouble())
        for (prime in primes) {
            if (prime > sqrt) {
                break
            }
            while (procNumber % prime == 0) {
                divisors.add(prime)
                procNumber /= prime
            }
        }
        if (procNumber != number && procNumber != 1) {
            divisors.add(procNumber)
        }
        return divisors.toIntArray()
    }

    fun loadPrimes(max: Int): IntArray {
        val sieve = BooleanArray(sqrt(max.toDouble()).toInt() + 1) { true }
        sieve[0] = false
        sieve[1] = false
        for (i in 2..sqrt(max.toDouble()).toInt()) {
            if (!sieve[i]) {
                continue
            }
            var curr = i * 2
            while (curr <= sieve.lastIndex) {
                sieve[curr] = false
                curr += i
            }
        }
        return sieve.mapIndexed { v, i -> Pair(v, i) }.filter { it.second }.map { it.first }.toIntArray()
    }
}