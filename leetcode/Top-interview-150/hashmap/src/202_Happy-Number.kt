fun isHappy(n: Int): Boolean {
  val squares = mutableMapOf<Char, Int>().apply { for (i in 0..9) this['0' + i] = i * i }

  var sum = n
  val allSums = mutableListOf<Int>()
  while (sum != 1) {
    if (sum in allSums) return false
    allSums.add(sum)
    var newSum = 0
    for (c in sum.toString()) {
      newSum += squares[c]!!
    }
    sum = newSum
  }

  return true
}

fun main() {
  val n = 2
  println(isHappy(n))
}