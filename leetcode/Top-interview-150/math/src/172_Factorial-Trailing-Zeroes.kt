fun trailingZeroes(n: Int): Int {
  var res = 0
  var pow5 = 5
  while (pow5 <= n) {
    res += n / pow5
    pow5 *= 5
  }
  return res
}

fun main() {
  println(trailingZeroes(3125))
}