import kotlin.math.max

fun jump(nums: IntArray): Int {
  if (nums.isEmpty()) return 0
  var jumps = nums[0]
  var next = 0
  var totalJumps = 0
  var newJump = true
  for (i in 1..<nums.size) {
    if (newJump) {
      totalJumps += 1
      newJump = false
    }
    val jump = nums[i]
    jumps--
    next--
    next = max(jump, next)
    if (jumps == 0) {
      jumps = next
      newJump = true
    }
  }
  return totalJumps
}

fun main() {
  val nums = intArrayOf(1, 1, 2, 1, 4)
  println(jump(nums))
}