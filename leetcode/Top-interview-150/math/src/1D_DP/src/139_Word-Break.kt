import kotlin.text.iterator

fun wordBreak(s: String, wordDict: List<String>): Boolean {
  val needWords = mutableListOf<String>("")
  for (c in s) {
    var pointer = 0
    var isDeletedWord = false
    while (pointer < needWords.size) {
      needWords[pointer] += c
      if (wordDict.contains(needWords[pointer])) isDeletedWord = true
      pointer += 1
    }
    if (isDeletedWord) needWords.add("")
  }
  return needWords.contains("")
}

fun main() {
  val s = "aebbbbs"
  val wordDict = listOf<String>("a", "aeb", "ebbbb", "s", "eb")
  println(wordBreak(s, wordDict))
}