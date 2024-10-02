fun main() {
    println(factorial(5))
}

fun sumOfNaturalNumber(n: Int): Int {
    if (n == 1) return 1
    val sum = sumOfNaturalNumber(n - 1)
    return sum + n
}

fun factorial(n: Int) : Int {
    if(n==1) return 1
    val res = factorial(n-1)
    return res * n
}