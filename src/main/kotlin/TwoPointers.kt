
import kotlin.math.max
import kotlin.math.min

fun main() {
    val input = intArrayOf(1, 5, 4, 3)
    val k = 0
    println(containerWithMostWater(input))
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
    var end = input.size - 1

    while (start < end) {
        val sum = input[start] + input[end]
        if (sum == k) return true
        else if (sum < k) start++
        else end--
    }

    return false
    // T.C - O(N) S.C - O(1)
}

fun countOfPairs(input: IntArray, k: Int): Int {

    // case 1 - when elements are different

    var count = 0

    var start = 0
    var end = input.size - 1

    while (start < end) {
        val sum = input[start] + input[end]
        if (sum == k) {
            count += 1
            start++
            end--
        } else if (sum < k) start++
        else end--
    }

    return count

    // case 2 - when elements are duplicate
    //TODO
}

fun pairDifference(input: IntArray, k: Int): Int {

    input.sort()

    var start = 0
    var end = 1
    var count = 0
    val size = input.size

    while (end < size) {
        val diff = input[end] - input[start]
        if (diff == k) {
            count += 1
            start += 1
            end++
        } else if (diff < k) {
            end += 1
        } else {
            start += 1
        }

    }
    return count
}


fun containerWithMostWater(input: IntArray): Int {

    var output = Integer.MIN_VALUE
    var start = 0
    var end = input.size - 1

    while (start < end) {
        val diff = end - start
        val min = min(input[start], input[end])
        output = max(output, (diff * min))

        if (input[start] < input[end]) start++
        else if (input[start] > input[end]) end--
        else {
            start++
            end--
        }
    }
    return output
}
