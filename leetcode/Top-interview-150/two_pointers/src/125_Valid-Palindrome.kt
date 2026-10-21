fun isPalindrome(s: String): Boolean {
  var left = 0
  var right = s.length - 1

  val allLetters = "abcdefghijklmnopqrstuvwxyz"
  val allNumbers = "0123456789"

  while (left < right) {
    val leftChar = s[left].lowercaseChar()
    val rightChar = s[right].lowercaseChar()

    if (leftChar !in allLetters && leftChar !in allNumbers) left += 1
    else if (rightChar !in allLetters && rightChar !in allNumbers) right -= 1
    else if (leftChar != rightChar) return false
    else {
      left += 1
      right -= 1
    }
  }

  return true
}

fun main() {
  val s = "A man, a plan, a canal: Panama"
  println(isPalindrome(s))
}