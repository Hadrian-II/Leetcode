package leetcode

fun main() {
    val summaryRanges = SummaryRanges()
    summaryRanges.addNum(1)      // arr = [1]
    summaryRanges.getIntervals() // return [[1, 1]]
    summaryRanges.addNum(3)      // arr = [1, 3]
    summaryRanges.getIntervals() // return [[1, 1], [3, 3]]
    summaryRanges.addNum(7)      // arr = [1, 3, 7]
    summaryRanges.getIntervals() // return [[1, 1], [3, 3], [7, 7]]
    summaryRanges.addNum(2)      // arr = [1, 2, 3, 7]
    summaryRanges.getIntervals() // return [[1, 3], [7, 7]]
    summaryRanges.addNum(6);      // arr = [1, 2, 3, 6, 7]
    summaryRanges.getIntervals() // return [[1, 3], [6, 7]]

    val sr2 = SummaryRanges()
    sr2.addNum(1)
    sr2.addNum(9)
    sr2.addNum(2)

    val sr3 = SummaryRanges()
    sr3.addNum(1)
    sr3.addNum(0)

    val sr4 = SummaryRanges()
    sr4.addNum(6)
    sr4.addNum(6)
    sr4.addNum(0)
    sr4.addNum(4)
    sr4.addNum(8)
    sr4.addNum(7)
    sr4.addNum(6)
    sr4.addNum(4)
    sr4.addNum(7)
    sr4.addNum(5)

    val blorp = 56
}

class SummaryRanges() {
    val ranges = mutableListOf<IntArray>()

    fun addNum(value: Int) {
        if (ranges.isEmpty()) {
            ranges.add(intArrayOf(value, value))
            return
        }

        var low = 0
        var high = ranges.lastIndex
        var mid = 0
        var range = intArrayOf()
        while (low <= high) {
            mid = (high + low) / 2
            range = ranges[mid]

            if (range[0] > value) {
                high = mid - 1
            } else {
                low = mid + 1
            }
        }

        if (value < range[0]) {
            if (mid == 0) {
                if (value == range[1] + 1) {
                    range[1] = value
                } else {
                    if (value == range[0] - 1) {
                        range[0] = value
                    } else {
                        ranges.add(0, intArrayOf(value, value))
                    }
                }
                return
            }
            mid--
            range = ranges[mid]
        }

        if (value in range[0]..range[1]) {
            return
        }

        val next = if (mid != ranges.lastIndex) ranges[mid + 1] else null
        if (value == range[1] + 1) {

            if ((next?.get(0) ?: -1) == value + 1) {
                range[1] = next!![1]
                ranges.removeAt(mid + 1)
            } else {
                range[1] = value
            }
        } else if (value == (next?.get(0) ?: -1) - 1) {
            next!![0] = value
        } else {
            ranges.add(mid + 1, intArrayOf(value, value))
        }
    }

    fun getIntervals(): Array<IntArray> {
        return ranges.toTypedArray()
    }
}