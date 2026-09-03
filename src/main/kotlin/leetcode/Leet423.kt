package leetcode

fun main() {
    println(Solution423().originalDigits("owoztneoer"))
    println(Solution423().originalDigits("fviefuro"))
}

class Solution423 {
    fun originalDigits(s: String): String {
        val map = IntArray(26)
        for (c in s) {
            map[c - 'a']++
        }

        //      e   g   f   i   h   o   n   s   r   u   t   w   v   x   z
        //1     1                   1   1
        //2                         .                   .   .
        //3     2               1               1       1
        //4             .           .           .   .
        //5     .       .   .                                   .
        //6                 .               .                       .
        //7     .                       .   .                   .
        //8     .   .       .   .                       .
        //9     1           1           2
        //0     1                   1           1                       1

        val numbers = IntArray(10)
        numbers[2] = map[W]
        map[T] -= numbers[2]
        map[O] -= numbers[2]

        numbers[4] = map[U]
        map[F] -= numbers[4]
        map[O] -= numbers[4]
        map[R] -= numbers[4]

        numbers[5] = map[F]
        map[I] -= numbers[5]
        map[V] -= numbers[5]
        map[E] -= numbers[5]

        numbers[6] = map[X]
        map[S] -= numbers[6]
        map[I] -= numbers[6]

        numbers[7] = map[V]
        map[E] -= numbers[7] * 2
        map[N] -= numbers[7]

        numbers[8] = map[G]
        map[E] -= numbers[8]
        map[I] -= numbers[8]
        map[H] -= numbers[8]
        map[T] -= numbers[8]

        numbers[0] = map[Z]
        map[O] -= numbers[0]

        numbers[9] = map[I]
        numbers[1] = map[O]
        numbers[3] = map[H]


        val result = StringBuilder()

        for (i in numbers.indices) {
            val number = numbers[i]
            if (number > 0) {
                result.append(CharArray(number) {'0' + i})
            }
        }

        return result.toString()
    }

    companion object {
        const val E = 'e' - 'a'
        const val G = 'g' - 'a'
        const val F = 'f' - 'a'
        const val I = 'i' - 'a'
        const val H = 'h' - 'a'
        const val O = 'o' - 'a'
        const val N = 'n' - 'a'
        const val S = 's' - 'a'
        const val R = 'r' - 'a'
        const val U = 'u' - 'a'
        const val T = 't' - 'a'
        const val W = 'w' - 'a'
        const val V = 'v' - 'a'
        const val X = 'x' - 'a'
        const val Z = 'z' - 'a'
    }
}