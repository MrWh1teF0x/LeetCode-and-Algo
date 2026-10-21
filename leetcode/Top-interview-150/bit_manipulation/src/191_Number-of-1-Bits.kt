fun hammingWeight(n: Int): Int {
  var num = n
  var weight = 0
  for (i in 0..<31) {
    weight += num and 1
    num = num ushr 1
  }
  return weight
}

fun main() {
  println(hammingWeight(2147483645))
}