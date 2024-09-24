fun main() {
    val input = intArrayOf(-5, -2, 1, 8, 10, 12, 15)
    val k = 1
    println(findPairTwoPointers(input, k))
}

fun findAnyPair(input: IntArray, k: Int): Boolean {

    for (i in input.indices) {
        for (j in i..<input.size) {
            if (input[i] + input[j] == k) return true
        }
    }

    return false
    // T.C - O(N^2) S.C - O(1)
}

fun findPairTwoPointers(input: IntArray, k: Int): Boolean {

    var start = 0
    var end = input.size -1

    while(start < end) {
        val sum = input[start] + input[end]
        if(sum == k) return true
        else if (sum < k) start++
        else end--
    }

    return false
    // T.C - O(N) S.C - O(1)
}