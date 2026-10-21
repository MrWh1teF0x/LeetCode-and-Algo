import kotlin.math.abs

fun myPow(x: Double, n: Int): Double {
  if (n == 0) return 1.0
  var num = if (n == Int.MIN_VALUE) abs(n + 1) else abs(n)
  var res = 1.0
  val isPositivePow = n > 0
  for (i in 0..30) {
    var mult = 1.0
    if (num and 1 == 1) {
      mult = abs(x)
      repeat(i) { mult *= mult }
    }
    res *= mult
    num = num ushr 1
  }
  if (x < 0 && n % 2 != 0) res = -res
  return if (isPositivePow) res else 1.0 / res
}

fun main() {
  val x = -1.00000
  val n = -2147483648
  println(myPow(x, n))
}