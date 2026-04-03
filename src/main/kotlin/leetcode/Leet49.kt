package leetcode

import kotlin.time.measureTime

fun main() {
    println(groupAnagrams(arrayOf("eat","tea","tan","ate","nat","bat")))
    println(groupAnagrams(arrayOf("")))
    println(groupAnagrams(arrayOf("a")))
    println(measureTime {  groupAnagrams(arrayOf("eatasdf","teaasdf","tanasdf","ateasdf","natasdf","batasdf", "asdfeat","asdftea","asdftan","asdfate","nassdfat","asdfbat", "eatasdfasdf","teaasdfasdf","tanasdfasdf","ateasdfasdf","natasdfasdf","batasdfasdf", "eatasdf","teaasdf","tanasdf","ateasdf","natasdf","batasdf", "asdfeat","asdftea","asdftan","asdfate","nassdfat","asdfbat", "eatasdfasdf","teaasdfasdf","tanasdfasdf","ateasdfasdf","natasdfasdf","batasdfasdf", "eatasdf","teaasdf","tanasdf","ateasdf","natasdf","batasdf", "asdfeat","asdftea","asdftan","asdfate","nassdfat","asdfbat", "eatasdfasdfasdfasdfaqsdgfwdefggsdfgasdfasdf","teawdefgwergwergwergwergwergasdfasdf","tanasdfasdf","ateasdfasdf","natasdfasdf","batasdfasdf"))})
}

fun groupAnagrams(strs: Array<String>): List<List<String>> {
    val resultMap = HashMap<String, MutableList<String>>()

    for (str in strs) {
        val kray = IntArray(26)
        for (c in str) {
            kray[c - 'a']++
        }
        val kbuilder = StringBuilder()
        for (i in 0..<26) {
            if (kray[i] != 0) {
                kbuilder.append((i + 'a'.code).toChar().toString().repeat(kray[i]))
            }
        }
        val key = kbuilder.toString()
        if (key in resultMap) {
            resultMap[key]!!.add(str)
        } else {
            resultMap[key] = mutableListOf(str)
        }
    }

    return resultMap.values.toList()
}