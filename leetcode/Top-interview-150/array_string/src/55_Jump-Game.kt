fun canJump(nums: IntArray): Boolean {
  if (nums.size == 1) return true
  var maxJump = 1
  for (i in 0..<nums.size) {
    maxJump -= 1
    val jump = nums[i]
    if (jump > maxJump) maxJump = jump
    if (maxJump == 0 && i + 1 != nums.size) return false
  }
  return true
}

fun main() {
  val nums = intArrayOf(0, 1)
  println(canJump(nums))
}