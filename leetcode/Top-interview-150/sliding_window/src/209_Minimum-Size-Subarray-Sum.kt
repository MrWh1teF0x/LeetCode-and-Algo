import kotlin.math.min

fun minSubArrayLen(target: Int, nums: IntArray): Int {
  var minLen = Int.MAX_VALUE
  var currSum = 0
  var left = 0
  var right = 0
  while (right != nums.size) {
    val num = nums[right]
    currSum += num
    if (currSum >= target) {
      while (currSum >= target) {
        minLen = min(minLen, right - left + 1)
        currSum -= nums[left]
        left += 1
      }
    }
    right += 1
  }
  return if (minLen != Int.MAX_VALUE) minLen else 0
}

fun main() {
  val nums = intArrayOf(1, 3, 4, 4)
  val target = 4
  println(minSubArrayLen(target, nums))
}