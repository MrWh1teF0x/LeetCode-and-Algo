import kotlin.text.iterator

fun lengthOfLastWord(s: String): Int {
  var sizeLastWord = 0

  for (c in s.reversed()) {
    if (c != ' ') sizeLastWord += 1
    else if (sizeLastWord > 0) break
  }

  return sizeLastWord
}

fun main() {
  val s = "luffy is still joyboy"
  println(lengthOfLastWord(s))
}