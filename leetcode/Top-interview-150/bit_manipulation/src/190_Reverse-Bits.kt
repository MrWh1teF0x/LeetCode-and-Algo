fun reverseBits(n: Int): Int {
  var res = 0
  var num = n
  repeat(32) {
    val lastBit = num and 1
    res = res shl 1
    res = res or lastBit
    num = num ushr 1
  }
  return res
}

fun main() {
  println(reverseBits(2))
}