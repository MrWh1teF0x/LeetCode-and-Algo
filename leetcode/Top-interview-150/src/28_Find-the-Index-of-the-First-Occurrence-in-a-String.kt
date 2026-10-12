fun strStr(haystack: String, needle: String): Int {
  for (i in 0..(haystack.length - needle.length)) {
    var pointer = 0
    while (pointer < needle.length && haystack[i + pointer] == needle[pointer]) pointer += 1
    if (pointer == needle.length) return i
  }

  return -1
}

fun main() {
  val haystack = "leetcode"
  val needle = "leeto"

  println(strStr(haystack, needle))
}