import java.util.*
import kotlin.text.iterator

fun isValid(s: String): Boolean {
  val stack = Stack<Char>()
  val map = mapOf<Char, Char>('(' to ')', '[' to ']', '{' to '}')
  for (b in s) {
    if (b in map.keys) stack.add(b)
    else {
      if (stack.isEmpty() || map[stack.peek()] != b) return false
      stack.pop()
    }
  }
  return stack.isEmpty()
}

fun main() {
  val s = "[(])"
  println(isValid(s))
}