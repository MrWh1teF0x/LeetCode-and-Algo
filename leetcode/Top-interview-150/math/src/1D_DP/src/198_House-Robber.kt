import kotlin.math.max

fun rob(nums: IntArray): Int {
  val s = nums.size
  if (nums.isEmpty()) return 0
  val bestRobberies = IntArray(s) { 0 }
  for (i in 0..<s) {
    var maxRobbery = 0
    if (i > 1) maxRobbery = bestRobberies[i - 2]
    if (i > 2) maxRobbery = max(maxRobbery, bestRobberies[i - 3])
    bestRobberies[i] = nums[i] + maxRobbery
  }
  var maxRobbery = bestRobberies[s - 1]
  if (s > 1) maxRobbery = max(bestRobberies[s - 1], maxRobbery)
  if (s > 2) maxRobbery = max(bestRobberies[s - 2], maxRobbery)
  return maxRobbery
}

fun main() {
  val nums = intArrayOf(1, 2, 3, 1)
  println(rob(nums))
}