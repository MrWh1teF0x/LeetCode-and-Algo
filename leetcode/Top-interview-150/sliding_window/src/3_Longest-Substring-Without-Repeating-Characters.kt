import kotlin.math.max

fun lengthOfLongestSubstring(s: String): Int {
  if (s == "") return 0
  var maxLen = 0
  var left = 0
  var right = 0
  val uniqueChars = mutableSetOf<Char>()
  while (right != s.length) {
    val c = s[right]
    if (uniqueChars.contains(c)) {
      maxLen = max(maxLen, right - left)
      while (uniqueChars.contains(c)) {
        uniqueChars.remove(s[left])
        left += 1
      }
    }
    uniqueChars.add(c)
    right += 1
  }
  return max(maxLen, uniqueChars.size)
}

fun main() {
  val s = "pwwkew"
  println(lengthOfLongestSubstring(s))
}