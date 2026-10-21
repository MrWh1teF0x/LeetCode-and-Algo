fun twoSum(numbers: IntArray, target: Int): IntArray {
  var left = 0
  var right = 1
  while (numbers[left] + numbers[right] != target) {
    println("left = $left, right = $right")
    val s = numbers[left] + numbers[right]
    if (s < target) {
      if (right + 1 == numbers.size) left += 1
      else right += 1
    } else {
      left += 1
      while (numbers[left] + numbers[right] > target) right -= 1
    }
  }
  return if (left < right) intArrayOf(left + 1, right + 1) else intArrayOf(right + 1, left + 1)
}

fun main() {
  val numbers = intArrayOf(
    12,
    13,
    23,
    28,
    43,
    44,
    59,
    60,
    61,
    68,
    70,
    86,
    88,
    92,
    124,
    125,
    136,
    168,
    173,
    173,
    180,
    199,
    212,
    221, // первый элемент, индекс 23
    227,
    230,
    277,
    282,
    306,
    314,
    316,
    321, // второй элемент, индекс 31
    325,
    328,
    336,
    337,
    363,
    365,
    368,
    370,
    370,
    371,
    375,
    384,
    387,
    394,
    400,
    404,
    414,
    422,
    422,
    427,
    430,
    435,
    457,
    493,
    506,
    527,
    531,
    538,
    541,
    546,
    568,
    583,
    585,
    587,
    650,
    652,
    677,
    691,
    730,
    737,
    740,
    751,
    755,
    764,
    778,
    783,
    785,
    789,
    794,
    803,
    809,
    815,
    847,
    858,
    863,
    863,
    874,
    887,
    896,
    916,
    920,
    926,
    927,
    930,
    933,
    957,
    981,
    997
  )
  println(twoSum(numbers, 542).contentToString())
}