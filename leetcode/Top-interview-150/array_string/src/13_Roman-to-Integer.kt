import kotlin.text.iterator

fun romanToInt(s: String): Int {
  val romanNumeralsToInt = mapOf<Char, Int>(
    'I' to 1,
    'V' to 5,
    'X' to 10,
    'L' to 50,
    'C' to 100,
    'D' to 500,
    'M' to 1000
  )
  var prevValue = 0
  var res = 0

  for (r in s.reversed()) {
    val newValue = romanNumeralsToInt[r] ?: throw IllegalArgumentException("Invalid Roman numeral: $s")
    if (newValue < prevValue) res -= newValue
    else res += newValue
    prevValue = newValue
  }

  return res
}

fun main() {
  val s = "III"
  println(romanToInt(s))
}