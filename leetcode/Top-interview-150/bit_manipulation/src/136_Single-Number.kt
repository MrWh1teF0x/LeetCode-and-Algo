fun singleNumber(nums: IntArray): Int {
  val ranksCounter = mutableMapOf<Int, Int>().apply {
    for (i in 0..31)
      this[i] = 0
  }
  for (i in 0..<nums.size) {
    var num = nums[i]
    for (j in 0..31) {
      ranksCounter[j] = ranksCounter[j]!! + (num and 1)
      num = num ushr 1
    }
  }
  var res = 0
  for (i in 31 downTo 0) {
    res = res shl 1
    if (ranksCounter[i]!! % 3 == 1) res += 1
  }
  return res
}

fun main() {
  println(singleNumber(intArrayOf(-2, -2, 1, 1, 4, 1, 4, 4, -4, -2)))
}