package leetcode

import kotlin.math.max
import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(Solution72().minDistance("horse", "ros"))            // 3
    //println(Solution72().minDistance("rorse", "ros"))            // 2
    //println(Solution72().minDistance("rose", "ros"))             // 1
    //println(Solution72().minDistance("ose", "os"))               // 1
    //println(Solution72().minDistance("se", "s"))                 // 1
    //println(Solution72().minDistance("ros", "ros"))              // 0
    println(Solution72().minDistance("intention", "execution"))  // 5
    println(Solution72().minDistance("a", "b"))                  // 1
    println(Solution72().minDistance("mart", "karma"))           // 3
    println(Solution72().minDistance("a", "ab"))                 // 1
    println(Solution72().minDistance("a", "aa"))                 // 1
    println(measureTime {  Solution72().minDistance("aakdjskajshdfklajshdfkjhwiunvklasdkjfrhyxdfhalksjdfhkyashfdlkasdhfj.kysfflajnmvlökasjdflasdmvlaösdjkfxfkasdfmlköasmfdlköasmvdlöasdmvlöaskdmvalöskdvmlaöskvmlaksövjlasdjflköasdjfy.kxdfölkasdasldfhjlksadjflajglöaskdjfljvlaksjdflökasjdfkasdjflöasdjflökas", "ajdfaslkdfjalöskdjflkaösjdflöasdjflköyjxdlköfjwlejfy-.kxjdajsdvkijsawhdfvkljasdfkjlhaskjdfhkjajlksdhfkjlahfdkhbkjhadfkjhadklfhaskljdfhkalsjdhfkljashdkljbhkaljsldkjfhalskjdhbkljahsdkljhbvkljbhlkjashdkjlfhh.ahdfskyncxvblkjaysdhflkyxdhflkjalksdjfpqdfkjplqsjfplqskjdfaölsdkjflöaksdjflöaksjdflökasjdfkasjdflökasjdflökasjdflköasjdflköasjdflökasjdflköasjdfa") })
}

class Solution72 {
    lateinit var memo: Array<IntArray>
    lateinit var word1: String
    lateinit var word2: String

    fun minDistance(word1: String, word2: String): Int {
        if (word1.isEmpty()) {
            return word2.length
        } else if (word2.isEmpty()) {
            return word1.length
        }
        this.word1 = word1
        this.word2 = word2
        memo = Array(word1.length + 1) { IntArray(word2.length + 1) { -1 } }
        return correctPosition(0, 0)
    }

    fun correctPosition(i: Int, j: Int): Int {
        if (memo[i][j] == -1) {
            memo[i][j] = if (i == word1.length) {
                word2.length - j
            } else if (j == word2.length){
                word1.length - i
            } else {
                if (word1[i] == word2[j]) {
                    correctPosition(i + 1, j + 1)
                } else {
                    1 + intArrayOf(correctPosition(i + 1, j),              // remove
                        correctPosition(i, j + 1),              // add
                        correctPosition(i + 1, j + 1)).min() // swap or match
                }
            }
        }
        return memo[i][j]
    }
}