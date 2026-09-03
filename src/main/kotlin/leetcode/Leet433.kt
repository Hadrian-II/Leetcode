package leetcode

fun main() {
    println(Solution433().minMutation("AACCGGTT", "AACCGGTA", arrayOf("AACCGGTA")))
    println(Solution433().minMutation(
        "AACCGGTT", "AAACGGTA",
        arrayOf("AACCGGTA","AACCGCTA","AAACGGTA")))
    println(Solution433().minMutation("AACCGGTT", "AACCGGTA", arrayOf()))
    println(Solution433().minMutation("AACCGGTT", "AAACGGTA", arrayOf("AACCGATT","AACCGATA","AAACGATA","AAACGGTA")))
}

class Solution433 {
    val genes = charArrayOf('A', 'C', 'G', 'T')
    lateinit var bank: Array<String>
    val visited = mutableSetOf<String>()

    fun minMutation(startGene: String, endGene: String, bank: Array<String>): Int {
        if (startGene == endGene) {
            return 0
        }
        this.bank = bank
        if (endGene !in this.bank) {
            return -1
        }



        var mutationsStart = setOf(startGene)
        var mutationCount = 1

        while (mutationsStart.isNotEmpty()) {
            val result = mutableSetOf<String>()

            for (mutation in mutationsStart) {
                val mChars = mutation.toCharArray()
                for (i in mutation.indices) {
                    val original = mChars[i]
                    for (gene in genes) {
                        if (gene != original) {
                            mChars[i] = gene
                            val new = String(mChars)
                            if (new == endGene) {
                                return mutationCount
                            }
                            if (new in bank && new !in visited) {
                                result.add(new)
                                visited.add(new)
                            }
                        }
                    }
                    mChars[i] = original
                }
            }
            mutationsStart = result
            mutationCount++
        }
        return -1
    }
}