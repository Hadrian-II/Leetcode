package leetcode

fun main () {
    //println(numberOfWays("SSPPSPS")) // 3
    //println(numberOfWays("PPSPSP"))  // 1
    //println(numberOfWays("S"))       // 0
    //println(numberOfWays("SS"))      // 1
    //println(numberOfWays("SSSS"))    // 1
    //println(numberOfWays("P"))       // 0
    //println(numberOfWays("SPPSSSSPPS")) // 1
    //println(numberOfWays("PPPPPSPPSPPSPPPSPPPPSPPPPSPPPPSPPSPPPSPSPPPSPSPPPSPSPPPSPSPPPPSPPPPSPPPSPPSPPPPSPSPPPPSPSPPPPSPSPPPSPPSPPPPSPSPSS")) // 919999993
    println(numberOfWays("PPPPPPPSPPPSPPPPSPPPSPPPPPSPPPSPPSPPSPPPPPSPSPPPPPSPPSPPPPPSPPSPPSPPPSPPPPSPPPPSPPPPPSPSPPPPSPSPPPSPPPPSPPPPPSPSPPSPPPPSPPSPPSPPSPPPSPPSPSPPSSSS")) // 18335643
}

fun numberOfWays(corridor: String): Int {
    val scount = corridor.count{ it == 'S'}
    if (scount == 2) {
        return 1
    } else if (scount < 2) {
        return 0
    } else if (scount % 2 == 1) {
        return 0
    }
    var seats = 0
    var plants = 0
    var divisions = 1L
    for (element in corridor) {
        if (element == 'S') {
            seats ++
            if (seats == 3) {
                seats = 1
                divisions = (divisions * (plants + 1)) % 1000000007
            }
            plants = 0
        } else {
            plants++
        }
    }
    return divisions.toInt()
}