fun addBinary(a: String, b: String): String {
  var s = ""
  var n = a.length - 1
  var m = b.length - 1
  var transfer = 0
  while (n >= 0 || m >= 0) {
    val aLastDigit = if (n >= 0) a[n].digitToIntOrNull() ?: 0 else 0
    val bLastDigit = if (m >= 0) b[m].digitToIntOrNull() ?: 0 else 0
    n -= 1
    m -= 1
    s = ((aLastDigit + bLastDigit + transfer) % 2).toString() + s
    transfer = (aLastDigit + bLastDigit + transfer) / 2
  }
  if (transfer > 0) s = "1" + s
  return s
}

fun main() {
  println(addBinary("11", "1"))
}