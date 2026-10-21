import kotlin.math.abs

fun containsNearbyDuplicate(nums: IntArray, k: Int): Boolean {
  val indexesByNums = mutableMapOf<Int, Int>()
  for (i in 0..<nums.size) {
    if (!indexesByNums.containsKey(nums[i])) indexesByNums[nums[i]] = i
    else {
      val index = indexesByNums[nums[i]]
      if (abs(index!! - i) <= k) return true
      indexesByNums[nums[i]] = i
    }
  }
  return false
}

fun main() {
  val nums = intArrayOf(1, 2, 3, 1, 2, 3)
  val k = 2
  println(containsNearbyDuplicate(nums, k))
}