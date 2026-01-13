package leetcode

import helpers.readArrayOfArrays
import kotlin.math.abs

fun main() {
    println(Solution3453().separateSquares(readArrayOfArrays("[[0,0,1],[2,2,1]]")))
    println(Solution3453().separateSquares(readArrayOfArrays("[[0,0,2],[1,1,1]]")))
    //println(Solution3453().separateSquares(readArrayOfArrays("[[4,25,13],[13,26,2]]")))
    //println(Solution3453().separateSquares(readArrayOfArrays("[[106,193,36],[139,195,14]]")))
    //println(Solution3453().separateSquares(readArrayOfArrays("[[11,158,46],[85,171,47],[31,199,46]]")))
    //println(Solution3453().separateSquares(readArrayOfArrays("[[522261215,954313664,225462],[628661372,718610752,10667],[619734768,941310679,44788],[352367502,656774918,289036],[860247066,905800565,100123],[817623994,962847576,71460],[691552058,782740602,36271],[911356,152015365,513881],[462847044,859151855,233567],[672324240,954509294,685569]]")))
    println(Solution3453().separateSquares(readArrayOfArrays("[[897515238,993605108,138720],[100704192,445277930,133649],[85589444,931338985,212734],[285072904,645781006,229200],[923802666,939669574,52444],[896077496,917039304,396346],[32803526,81037204,202006],[226185242,573632339,238829],[193522284,371644830,105829],[105822162,116503224,712164]]")))
}

class Solution3453 {
    lateinit var squares: Array<IntArray>
    val precision = 0.00001

    fun separateSquares(squares: Array<IntArray>): Double {
        this.squares = squares
        var min = squares.minOf { it[1] }.toDouble()
        var max = squares.maxOf { it[1] + it[2] }.toDouble()
        var correct = Double.MAX_VALUE
        while (min < max) {
            val mid = (max + min) / 2
            val difference = calcSums(mid)
            if (abs(difference) < precision) {
                if (correct >= mid) {
                    correct = mid
                }
            }
            if (difference >= 0) {
                if (max == mid) {
                    return mid
                }
                max = mid
            } else {
                if (min == mid) {
                    return mid
                }
                min = mid
            }
        }
        return correct
    }

    fun calcSums(line: Double): Double {
        var difference = 0.0
        for (square in squares) {
            val area = square[2].toLong() * square[2]
            if (square[1] >= line) {
                difference -= area
            } else if (square[1] + square[2] <= line) {
                difference += area
            } else {
                val b = (line - square[1]) * square[2]
                difference += b + b - area
            }
        }
        return difference
    }
}