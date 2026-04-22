package leetcode

import kotlin.math.min
import kotlin.time.measureTime

fun main() {
    println(minWindow("ADOBECODEBANC", "ABC")) // BANC
    println(minWindow("a", "a"))
    println(minWindow("a", "aa"))
    println(minWindow("a", "b"))
    println(measureTime {
    println(minWindow("wegdtzwabazduwwdysdetrrctotpcepalxdewzezbfewbabbseinxbqqplitpxtcwwhuyntbtzxwzyaufihclztckdwccpeyonumbpnuonsnnsjscrvpsqsftohvfnvtbphcgxyumqjzltspmphefzjypsvugqqjhzlnylhkdqmolggxvneaopadivzqnpzurmhpxqcaiqruwztroxtcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanllpunlyohwfsssiazeixhebipfcdqdrcqiwftutcrbxjthlulvttcvdtaiwqlnsdvqkrngvghupcbcwnaqiclnvnvtfihylcqwvderjllannflchdklqxidvbjdijrnbpkftbqgpttcagghkqucpcgmfrqqajdbynitrbzgwukyaqhmibpzfxmkoeaqnftnvegohfudbgbbyiqglhhqevcszdkokdbhjjvqqrvrxyvvgldtuljygmsircydhalrlgjeyfvxdstmfyhzjrxsfpcytabdcmwqvhuvmpssingpmnpvgmpletjzunewbamwiirwymqizwxlmojsbaehupiocnmenbcxjwujimthjtvvhenkettylcoppdveeycpuybekulvpgqzmgjrbdrmficwlxarxegrejvrejmvrfuenexojqdqyfmjeoacvjvzsrqycfuvmozzuypfpsvnzjxeazgvibubunzyuvugmvhguyojrlysvxwxxesfioiebidxdzfpumyon", "ozgzyywxvtublcl"))})
    // tcnvhxqgndyozpcigzykbiaucyvwrjvknifufxducbkbsmlanl
    println(minWindow("cabefgecdaecf", "cae")) // aec
    println(minWindow("coobdafceeaxab", "abc")) // bdafc
    println(minWindow("aAaabAbBaa", "aaAB")) // AbBaa
    println(measureTime {
    println(minWindow("hwffmpuhbqftfeqfsyvwbrxwbgzalhfselzsctbdmgzrnpzfnwdonakoilrutwozjormjurvaspphouwkzmxczokkfgddvcplvdupussphhwxethdfgfeusrbyufvzugwzdmvvgkenhbtckzjqeqnyhoxbvscrbzqenmbtwfifiejudtkjjziqqhtlzwdcxtikhjfgqpnatxuwqfgbgqtwxmiyklbhgjtqvywlojmhiggynobweusbjcztpadwmwmhxkultgucpcceqgauatvlvxfnzkjlgxudhpqcxngmpltgrtctoafmxmzwwkkcheiqvystlbhdoajfwnaknfwktvjpftuozcevczoqcxtqyevurxgffdryaaoivkyvmdsqeiggfbwfhtbzqigvlxunakxxuwuibmafujnckjhscjturzqeymtywrwspscqfcxblkdwtlqxwlrpkjvkvolthjlwbnogqlibvnzqyrpwchlosgboxmhevvbwkrfcdpgachrdzizdrnukvvysjhxeeacprjtwyzxdhqgiyhlswhcsccklljrqlwhdfabgcyjjqprryejvmlnopzcajtsupzzxcbdgbmpudilbmwyajlryltawotqgusdytgewutqxddaqbzqkkhkxcltrgmzagczzkdxgzqdctfuxenhrwuqzhmsnyr", "pgvofhuentu"))})
    // eqgauatvlvxfnzkjlgxudhpqcxngmpltgrtcto // 269..306
}

fun minWindow(s: String, t: String): String {
    if (t.length > s.length) {
        return ""
    }

    val tCount = t.groupingBy { it }.eachCount()
    val fCount = tCount.keys.associateBy({it}, {0}).toMutableMap()
    val missing = tCount.keys.toMutableSet()

    var min = Int.MAX_VALUE
    var minString = 0..0
    var left = 0
    for (i in s.indices) {
        val c = s[i]
        val cCount = (fCount[c] ?: -1) + 1
        if (cCount != 0) {
            fCount[c] = cCount
            if (cCount >= tCount[c]!!) {
                missing.remove(c)
            }
            while (missing.isEmpty()) {
                val cl = s[left]
                val clCount = (fCount[cl] ?: -1) - 1
                if (clCount != -2) {
                    fCount[cl] = clCount
                    if (clCount < tCount[cl]!!) {
                        missing.add(cl)
                    }
                    val size = i - left
                    if (size < min) {
                        min = min(size, min)
                        minString = (left..i)
                    }
                }
                left++
            }
        }
    }
    return if (min == Int.MAX_VALUE) "" else s.substring(minString)
}