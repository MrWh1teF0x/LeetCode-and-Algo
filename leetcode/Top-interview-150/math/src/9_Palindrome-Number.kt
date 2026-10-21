fun isPalindrome(x: Int): Boolean {
  if (x < 0) return false
  var rank = 1L
  val deque = ArrayDeque<Long>()
  while (rank <= x) {
    deque.addLast((x.toLong() % (rank * 10)) / rank)
    rank *= 10
  }
  while (!deque.isEmpty()) {
    val firstDigit = deque.removeLast()
    if (deque.isEmpty()) return true
    val lastDigit = deque.removeFirst()
    if (firstDigit != lastDigit) return false
  }
  return true
}

fun main() {
  println(isPalindrome(1410110141))
}