fun isIsomorphic(s: String, t: String): Boolean {
  if (s.length != t.length) return false

  val changes = mutableMapOf<Char, Char>()
  var pointer = 0
  while (pointer != s.length) {
    if (!changes.contains(s[pointer])) {
      val key = changes.entries.firstOrNull { it.value == t[pointer] }?.key
      if (key == null) changes[s[pointer]] = t[pointer]
      else return false
    } else
      if (changes[s[pointer]] != t[pointer]) return false

    pointer += 1
  }

  return true
}

fun main() {
  val s = "badc"
  val t = "baba"

  println(isIsomorphic(s, t))
}