fun merge(nums1: IntArray, m: Int, nums2: IntArray, n: Int): Unit {
  var nums1Pointer = m
  var nums2Pointer = n
  var lastPointer = n + m - 1
  while (nums1Pointer + nums2Pointer != 0) {
    val nums1Value = if (nums1Pointer > 0) nums1[nums1Pointer - 1] else Int.MIN_VALUE
    val nums2Value = if (nums2Pointer > 0) nums2[nums2Pointer - 1] else Int.MIN_VALUE
    if (nums1Value >= nums2Value) {
      nums1[lastPointer] = nums1Value
      nums1Pointer -= 1
    } else {
      nums1[lastPointer] = nums2Value
      nums2Pointer -= 1
    }
    lastPointer -= 1
  }
}


fun main() {
  val nums1 = intArrayOf(1, 2, 3, 0, 0, 0)
  val nums2 = intArrayOf(2, 5, 6)
  val m = 3
  val n = 3

  merge(nums1, m, nums2, n)

  println(nums1.joinToString(","))
}