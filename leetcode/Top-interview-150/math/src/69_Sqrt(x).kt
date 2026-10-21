fun mySqrt(x: Int): Int {
  if (x == 0) return 0

  var upperBound = 46341L
  var lowerBound = 1L
  while (!(lowerBound + 1 == upperBound && lowerBound * lowerBound <= x && upperBound * upperBound > x)) {
    if (lowerBound * lowerBound > x) {
      upperBound = lowerBound
      lowerBound /= 2
    } else if (upperBound * upperBound > x) {
      upperBound -= (upperBound - lowerBound) / 2
    } else {
      val diff = upperBound - lowerBound + 1
      lowerBound = upperBound
      upperBound = lowerBound + diff
    }
  }

  return lowerBound.toInt()
}

fun main() {
  println(mySqrt(2147395599))
}