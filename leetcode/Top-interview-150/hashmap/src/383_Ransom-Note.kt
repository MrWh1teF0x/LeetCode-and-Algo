fun canConstruct(ransomNote: String, magazine: String): Boolean {
  if (ransomNote.length > magazine.length) return false

  val counter = mutableMapOf<Char, Int>()
  for (c in ransomNote) {
    if (!counter.contains(c)) counter[c] = 0
    counter[c] = counter[c]!! + 1
  }

  for (c in magazine) {
    if (!counter.contains(c)) continue
    counter[c] = counter[c]!! - 1
    if (counter[c] == 0) counter.remove(c)
  }

  return counter.isEmpty()
}

fun main() {
  val ransomNote = "aaa"
  val magazine = "aaabb"

  println(canConstruct(ransomNote, magazine))
}