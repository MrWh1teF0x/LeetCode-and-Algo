fun isSubsequence(s: String, t: String): Boolean {
  var leftS = 0
  var rightS = s.length - 1

  var leftT = 0
  var rightT = t.length - 1

  while (leftS <= rightS) {
    val leftCharS = s[leftS]
    val rightCharS = s[rightS]

    while (leftT <= rightT) {
      val leftCharT = t[leftT]
      val rightCharT = t[rightT]

      if (leftCharS == leftCharT && rightCharS == rightCharT) break

      if (leftCharS != leftCharT) leftT += 1
      if (rightCharS != rightCharT) rightT -= 1
    }

    if (leftT > rightT || (rightT - leftT) < (rightS - leftS)) return false

    leftS += 1
    rightS -= 1
    leftT += 1
    rightT -= 1
  }

  return true
}

fun main() {
  val s = "bb"
  val t = "b"

  println(isSubsequence(s, t))
}