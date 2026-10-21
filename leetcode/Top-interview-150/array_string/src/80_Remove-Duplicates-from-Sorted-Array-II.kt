fun removeDuplicates2(nums: IntArray): Int {
  var leftPointer = 0
  var rightPointer = 1
  var savedValue = if (!nums.isEmpty()) nums[0] else 0
  var k = if (!nums.isEmpty()) 1 else 0
  var foundSecondDublicate = false

  while (rightPointer <= nums.size - 1) {
    if (savedValue != nums[rightPointer] || !foundSecondDublicate) {
      foundSecondDublicate = if (savedValue == nums[rightPointer]) true else false
      k += 1
      leftPointer += 1
      nums[leftPointer] = nums[rightPointer]
      savedValue = nums[leftPointer]
    }
    rightPointer += 1
  }
  return k
}

fun main() {
  val nums = intArrayOf(0, 0, 0, 0, 0)

  val k = removeDuplicates2(nums)

  println("k = $k")
  println(nums.joinToString(","))
}