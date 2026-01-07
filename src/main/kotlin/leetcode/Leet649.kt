package leetcode

fun main() {
    println(predictPartyVictory("RD"))    //r
    println(predictPartyVictory("RDD"))   //d
    println(predictPartyVictory("RRDDD")) //r
    println(predictPartyVictory("RDRDRDDRDRDRDRDRRDRDRDRDRDRDDDDRRDRDRDRDRDRDRDRRRRRDRDRDRDRDDDDDRDRDRDRDRDRDRDRRDRDRDRDRDRDRRDRDRDRDRDRDRDRDRRDRDRDRDRDRRD")) //r
}

fun predictPartyVictory(senate: String): String {
    return predictPartyVictory(ArrayDeque(senate.map { it == 'D' }))
}

fun predictPartyVictory(senators: ArrayDeque<Boolean>): String {
    val acted = ArrayDeque<Boolean>()

    while (senators.isNotEmpty()) {
        val voter = senators.removeFirst()
        var ix = senators.indexOf(!voter)
        if (ix != -1) {
            senators.removeAt(ix)
        } else {
            ix = acted.indexOf(!voter)
            if (ix != -1) {
                acted.removeAt(ix)
            } else {
                return if (voter) "Dire" else "Radiant"
            }
        }
        acted.addLast(voter)
    }

    return predictPartyVictory(acted)
}