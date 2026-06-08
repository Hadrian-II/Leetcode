package leetcode

import helpers.readArrayOfArrays

fun main() {
    println(maxPoints(readArrayOfArrays("[[1,1],[2,2],[3,3]]")))
    println(maxPoints(readArrayOfArrays("[[1,1],[3,2],[5,3],[4,1],[2,3],[1,4]]")))
    println(maxPoints(readArrayOfArrays("[[2,3],[3,3],[-5,3]]")))
    println(maxPoints(readArrayOfArrays("[[2,1],[2,2],[2,3],[3,1],[3,2],[3,3],[3,4]]")))
    println(maxPoints(readArrayOfArrays("[[7,3],[19,19],[-16,3],[13,17],[-18,1],[-18,-17],[13,-3],[3,7],[-11,12],[7,19],[19,-12],[20,-18],[-16,-15],[-10,-15],[-16,-18],[-14,-1],[18,10],[-13,8],[7,-5],[-4,-9],[-11,2],[-9,-9],[-5,-16],[10,14],[-3,4],[1,-20],[2,16],[0,14],[-14,5],[15,-11],[3,11],[11,-10],[-1,-7],[16,7],[1,-11],[-8,-3],[1,-6],[19,7],[3,6],[-1,-2],[7,-3],[-6,-8],[7,1],[-15,12],[-17,9],[19,-9],[1,0],[9,-10],[6,20],[-12,-4],[-16,-17],[14,3],[0,-1],[-18,9],[-15,15],[-3,-15],[-5,20],[15,-14],[9,-17],[10,-14],[-7,-11],[14,9],[1,-1],[15,12],[-5,-1],[-17,-5],[15,-2],[-12,11],[19,-18],[8,7],[-5,-3],[-17,-1],[-18,13],[15,-3],[4,18],[-14,-15],[15,8],[-18,-12],[-15,19],[-9,16],[-9,14],[-12,-14],[-2,-20],[-3,-13],[10,-7],[-2,-10],[9,10],[-1,7],[-17,-6],[-15,20],[5,-17],[6,-6],[-11,-8]]")))
    println(maxPoints(readArrayOfArrays("[[0,1],[0,0],[0,4],[0,-2],[0,-1],[0,3],[0,-4]]")))
}

fun maxPoints(points: Array<IntArray>): Int {
    if (points.size < 3) {
        return points.size
    }
    val lines = HashMap<Pair<Double, Double>, MutableSet<Int>>()

    for (i in 0..<points.lastIndex) {
        val pointI = points[i]
        for (j in i + 1..points.lastIndex) {

            val pointJ = points[j]
            val width = (pointI[0] - pointJ[0]).toDouble()
            val height = (pointI[1] - pointJ[1]).toDouble()
            var steepness = height / width
            if (steepness == -0.0) {
                steepness = 0.0
            }

            val offset = if (steepness.isInfinite()) {
                steepness = Double.POSITIVE_INFINITY
                pointI[0].toDouble()
            } else if (steepness == 0.0) {
                pointI[1].toDouble()
            } else {
                pointI[0] - steepness * pointI[1]
            }
            val key = Pair(steepness, offset)
            if (key in lines) {
                lines[key]!!.add(j)
            } else {
                lines[key] = mutableSetOf(i, j)
            }
        }
    }

    return lines.values.maxOf { it.size }
}