import kotlin.math.min

fun longestCommonPrefix(strs: Array<String>): String {
  var prefix = strs[0]

  for (i in 1..<strs.size) {
    val word = strs[i]
    if (word == "") return ""

    var pointer = 0
    val minSize = min(word.length, prefix.length)
    while (minSize > pointer && word[pointer] == prefix[pointer]) pointer += 1

    var newPrefix = ""
    while (pointer != 0) {
      newPrefix = prefix[pointer - 1] + newPrefix
      pointer -= 1
    }
    prefix = newPrefix
  }

  return prefix
}

fun main() {
  val strs = arrayOf("dog", "racecar", "car")
  println(longestCommonPrefix(strs))
}