fun majorityElement(nums: IntArray): Int {
    var candidate = nums[0]
    var counter = 0
    for (i in 0..(nums.size - 1)) {
        val elem = nums[i]
        if (elem == candidate) counter += 1 else counter -= 1
        if (counter == 0) {
            candidate = elem
            counter += 1
        }
    }
    return candidate
}

fun main() {
    val nums = intArrayOf(2, 2, 1, 1, 1, 2, 2)

    println(majorityElement(nums))
}
