fun removeElement(nums: IntArray, `val`: Int): Int {
  var leftPointer = 0
  var rightPointer = nums.size - 1
  var k = 0
  while (leftPointer <= rightPointer) {
    if (`val` == nums[rightPointer]) {
      nums[rightPointer] = 0
      rightPointer -= 1
    } else if (nums[leftPointer] == `val`) {
      nums[leftPointer] = nums[rightPointer]
      nums[rightPointer] = 0
      rightPointer -= 1
      leftPointer += 1
      k += 1
    } else {
      leftPointer += 1
      k += 1
    }
  }
  return k
}


fun main() {
  val nums = intArrayOf(3, 2, 2, 3)
  val `val` = 3

  val k = removeElement(nums, `val`)

  println("k = $k")
  println(nums.joinToString(","))
}