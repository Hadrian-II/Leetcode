package leetcode

import java.util.PriorityQueue
import kotlin.math.max
import kotlin.math.min

fun main() {
    println(trap(intArrayOf(0,1,0,2,1,0,1,3,2,1,2,1)))
    println(trap(intArrayOf(4,2,0,3,2,5)))
}

fun trap(height: IntArray): Int {
    val priors = PriorityQueue<Pair<Int, Int>>(compareBy { it.first })
    var waterlevel = 0
    var fill = 0

    for (i in height.indices) {
        val h = height[i]
        var p: Pair<Int, Int>? = null
        var newWaterlevel = 0

        while (priors.isNotEmpty()) {
            p  = priors.poll()
            newWaterlevel = min(h, p.first)
            if (newWaterlevel > waterlevel) {
                fill += max(i - p.second - 1, 0) * (newWaterlevel - waterlevel)
                waterlevel = newWaterlevel
            }

            if (p.first > h) {
                priors.add(p)
                break
            }
        }

        if (p != null) {
            waterlevel = newWaterlevel
        }

        if (h > 0) {
            priors.add(Pair(h, i))
        }
    }
    return fill
}