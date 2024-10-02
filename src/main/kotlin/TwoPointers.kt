import kotlin.math.max
import kotlin.math.min

fun main() {
    val input = intArrayOf(1, 1, 1)
    val k = 2
    println(findPairElementsAreDuplicate(input, k))

}

// Brute Force
fun findAnyPair(input: IntArray, k: Int): Boolean {

    for (i in input.indices) {
        for (j in i..<input.size) {
            if (input[i] + input[j] == k) return true
        }
    }

    return false
    // T.C - O(N^2) S.C - O(1)
}

fun findPairElementsDuplicate(input: IntArray, k: Int): Boolean {

    // When input array elements are distinct - No duplicates

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

fun findPairElementsAreDuplicate(input: IntArray, k: Int): Int {

    // When input array elements are duplicate

    var start = 0
    val size = input.size
    var end = size-1
    var count = 0

    while (start < end) {
        val sum = input[start] + input[end]
        if (sum == k) {
            var startCount = 1
            var endCount = 1

            while ((start + 1) < end && input[start + 1] == input[start]) {
                startCount++
                start++
            }

            while ((end - 1) > start && input[end - 1] == input[end]) {
                endCount++
                end--
            }

            if (input[start] != input[end]) {
                count += startCount * endCount
            }
            else {
                val totalCount = startCount + endCount
                val x = (totalCount * (totalCount - 1)) / 2
                count += x
            }
            start++
            end--


        } else if (sum < k) start++
        else end--
    }

    return count
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

fun subArrayWithSumKPrefixSum(input: IntArray, k: Int): Boolean {

    val pSum = IntArray(input.size)

    for (index in input.indices) {
        if (index == 0) pSum[index] = input[index]
        else pSum[index] = pSum[index - 1] + input[index]
    }

    println(pSum.joinToString())

    for (i in pSum.indices) {
        var diff = 0
        for (j in i..<pSum.size) {
            diff = input[j] - input[i]
            if (diff == k) return true
        }
    }
    return false

    // T.C - O(N) // S.C - O(N)
}

fun subArrayWithSumK(input: IntArray, k: Int): Boolean {
    var i = 0
    var j = 0
    var sum = input[0]
    val n = input.size - 1

    while (j < n) {
        if (sum == k) {
            for (h in i..j) println("i: ${input[h]}")
            break
        } else if (sum < k) {
            j++
            sum += input[j]
        } else {
            sum -= input[i]
            i++
        }
    }

    return false
}



