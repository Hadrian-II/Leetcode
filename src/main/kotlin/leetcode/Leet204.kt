package leetcode

import kotlin.math.sqrt

fun main() {
    println(countPrimes(10))
    println(countPrimes(0))
    println(countPrimes(1))
    println(countPrimes(2))
    println(countPrimes(3))
}

fun countPrimes(n: Int): Int {
    if (n < 2) {
        return 0
    }

    val sieve = BooleanArray(n) { true }
    sieve[0] = false
    sieve[1] = false
    var prime = 2
    val limit = sqrt(n.toDouble())
    while (prime < limit) {
        var current = prime * prime
        while (current < sieve.size) {
            sieve[current] = false
            current += prime
        }
        prime++
        while (!sieve[prime]) {
            prime++
        }
    }
    return sieve.count { it }
}