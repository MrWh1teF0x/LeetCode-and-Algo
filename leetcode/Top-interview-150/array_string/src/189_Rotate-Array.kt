import java.util.*

fun rotate(nums: IntArray, k: Int): Unit {
  if (nums.size == 1 || k == 0) return
  val rightK = k % nums.size
  val savedNums = Stack<Int>()
  var counter = 0
  for (i in 0..<nums.size) {
    if (i < nums.size - rightK) savedNums.addFirst(nums[i])
    else {
      nums[counter] = nums[i]
      counter++
    }
  }
  var pos = nums.size - 1
  while (!savedNums.isEmpty()) {
    nums[pos] = savedNums.removeFirst()
    pos -= 1
  }
}

fun main() {
  val nums = intArrayOf(-1, -100, 3, 99)
  rotate(nums, 2)
  println(nums.contentToString())
}