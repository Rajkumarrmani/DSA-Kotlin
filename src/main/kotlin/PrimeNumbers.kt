fun main() {
    val A = 49
    println(getAllPrimeNumber(A).joinToString())
}

fun optimizeFindPrimeNumber(A: Int): Boolean {

    if (A == 1) return false
    if (A == 2) return true

    var count = 0
    for (i in 1..kotlin.math.sqrt(A.toDouble()).toInt()) {
        if (A % i == 0) {
            count += if (i == A / i) 1 else 2
        }
    }

    return count == 2

}

fun getAllPrimeNumber(B: Int): IntArray {
    val numbers = mutableListOf<Int>()

    for (A in 2..B) {
        var count = 0
        for (i in 1..kotlin.math.sqrt(A.toDouble()).toInt()) {
            if (A % i == 0) {
                count += if (i == A / i) 1 else 2
            }
        }
        if (count == 2) {
            numbers.add(A)
        }
    }
    return numbers.toIntArray()
}