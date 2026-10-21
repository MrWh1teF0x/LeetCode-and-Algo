fun climbStairs(n: Int): Int {
  if (n <= 0) return 0
  if (n == 1) return 1
  if (n == 2) return 2
  var prev = 1
  var curr = 2
  for (i in 0..<(n - 2)) {
    val tmp = prev + curr
    prev = curr
    curr = tmp
  }
  return curr
}

fun main() {
  println(climbStairs(5))
}