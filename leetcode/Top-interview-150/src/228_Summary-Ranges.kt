fun summaryRanges(nums: IntArray): List<String> {
  if (nums.isEmpty()) return emptyList()
  val res = mutableListOf<String>()
  var startRange = nums[0]
  var endRange = nums[0]
  for (i in 1..<nums.size) {
    val num = nums[i]
    if (endRange == num - 1) endRange = num
    else {
      if (startRange < endRange) res.add("$startRange->$endRange")
      else res.add("$startRange")
      startRange = num
      endRange = num
    }
  }
  if (startRange < endRange) res.add("$startRange->$endRange")
  else res.add("$startRange")
  return res
}

fun main() {
  val nums = intArrayOf(0, 1, 2, 4, 5, 7)
  println(summaryRanges(nums).toString())
}