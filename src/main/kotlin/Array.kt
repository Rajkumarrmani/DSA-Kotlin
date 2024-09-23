fun main() {
    subArrayMaxSum()
}

fun subArrayFindMaxWithQuery() {

    //Given N elements and Q queries. For each query, calculate sum of all elements from L to R [0 based index].
    val input = intArrayOf(-3, 6, 2, 4, 5, 2, 8, -9, 3, 1)
    
}


fun subArrayMaxSum() {

    /**
     *  contiguous part of an array
     *  complete array is also subArray
     *  Single element is also sebArray
     *  Total subArray Formula = (n * (n+1)) /2
     */

    // Given arr[N]. Find the maximum subArray sum out of all subArrays
    val input = arrayOf(-3, 2, 4, -1, 3, -4, 3)

    var output = Int.MIN_VALUE

    // Bruteforce idea
    for (start in input.indices) {
        for (end in start..<input.size) {
            var sum = 0
            for (final in start..end) {
                sum += input[final]
            }
            if (output < sum) output = sum
        }
    }
    println("Bruteforce output ==== $output ")
    // T.C - 0(N^3), S.C - 0(1)
}

