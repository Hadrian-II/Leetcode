package leetcode

import helpers.readArrayOfArrays
import kotlin.math.abs

fun main() {
    println(numberOfBoomerangs(readArrayOfArrays("[[0,0],[1,0],[2,0]]")))
    println(numberOfBoomerangs(readArrayOfArrays("[[1,1],[2,2],[3,3]]")))
    println(numberOfBoomerangs(readArrayOfArrays("[[1,1]]")))
    println(numberOfBoomerangs(readArrayOfArrays("[[0,0],[1,0],[-1,0],[0,1],[0,-1]]")))
}

fun numberOfBoomerangs(points: Array<IntArray>): Int {
    val distances = mutableMapOf<Int, MutableList<IntArray>>()

    for (i in 0..<points.lastIndex) {
        val pointI = points[i]
        for (j in i + 1..points.lastIndex) {
            val pointJ = points[j]
            val dx = abs(pointI[0] - pointJ[0])
            val dy = abs(pointI[1] - pointJ[1])
            val distance = dx * dx + dy * dy
            val dList = distances[distance]
            if (dList == null) {
                distances[distance] = mutableListOf(intArrayOf(i, j))
            } else {
                dList.add(intArrayOf(i, j))
            }
        }
    }

    var boomerangs = 0

    for(d in distances.values) {
        for (i in 0..<d.lastIndex) {
            val (i1, i2) = d[i]
            for (j in i + 1..d.lastIndex) {
                val(j1, j2) = d[j]
                if (i1 == j1 || i1 == j2 || i2 == j1 || i2 == j2) {
                    boomerangs++
                }
            }
        }
    }

    return boomerangs * 2
}