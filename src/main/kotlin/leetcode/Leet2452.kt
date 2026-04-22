package leetcode

fun main() {
    println(twoEditWords(arrayOf("word","note","ants","wood"), arrayOf("wood","joke","moat")))
    println(twoEditWords(arrayOf("yes"), arrayOf("not")))
}

fun twoEditWords(queries: Array<String>, dictionary: Array<String>): List<String> {
    return queries.filter {
        for (dword in dictionary) {
            var errors = 0
            for (i in dword.indices) {
                if (it[i] != dword[i]) {
                    errors++
                    if (errors > 2) {
                        break
                    }
                }
            }
            if (errors <= 2) {
                return@filter true
            }
        }
        false
    }
}