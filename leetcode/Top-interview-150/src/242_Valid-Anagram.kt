fun isAnagram(s: String, t: String): Boolean {
  if (s.length != t.length) return false
  val counter = mutableMapOf<Char, Int>()
  for (c in s) {
    if (!counter.contains(c)) counter[c] = 0
    counter[c] = counter[c]!! + 1
  }
  for (c in t) {
    if (!counter.contains(c)) return false
    counter[c] = counter[c]!! - 1
    if (counter[c]!! < 0) return false
  }
  return true
}

fun main() {
  val s = "rat"
  val t = "car"

  println(isAnagram(s, t))
}