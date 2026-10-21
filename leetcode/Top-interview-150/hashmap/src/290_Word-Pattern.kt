fun wordPattern(pattern: String, s: String): Boolean {
  val map = mutableMapOf<Char, String>()

  var pointer = 0
  for (c in pattern) {
    var word = ""
    while (pointer < s.length && s[pointer] != ' ') {
      word += s[pointer]
      pointer += 1
    }
    if (word == "") return false
    pointer += 1
    if (!map.contains(c)) {
      val key = map.entries.firstOrNull { it.value == word }?.key
      if (key == null) map[c] = word
      else return false
    } else {
      if (map[c] != word) return false
    }
  }

  return if (pointer >= s.length) return true else false
}

fun main() {
  val pattern = "abba"
  val s = "dog cat cat dog"

  println(wordPattern(pattern, s))
}