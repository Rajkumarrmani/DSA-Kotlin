fun main() {
    println(sumOfNaturalNumber(5))
}

fun sumOfNaturalNumber(n: Int): Int {
    if (n == 1) return 1
    val sum = sumOfNaturalNumber(n - 1)
    return sum + n
}