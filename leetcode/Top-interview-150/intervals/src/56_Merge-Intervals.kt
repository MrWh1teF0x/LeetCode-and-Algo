fun merge(intervals: Array<IntArray>): Array<IntArray> {
  val sorted = intervals.sortedBy { it[0] }
  val res = mutableListOf<IntArray>(sorted[0])
  for (i in 1..<sorted.size) {
    val interval = sorted[i]
    var isUpdated = false
    for (j in 0..<res.size) {
      if (res[j][0] > interval[1] || res[j][1] < interval[0]) continue

      val changeLeft = res[j][0] <= interval[1] && res[j][0] >= interval[0]
      val changeRight = res[j][1] >= interval[0] && res[j][1] <= interval[1]

      if (changeLeft) res[j][0] = interval[0]
      if (changeRight) res[j][1] = interval[1]
      isUpdated = true
    }
    if (!isUpdated) res.add(interval)
  }
  return res.toTypedArray()
}

fun main() {
  val intervals: Array<IntArray> = arrayOf(
    intArrayOf(1, 3),
    intArrayOf(2, 6),
    intArrayOf(8, 10),
    intArrayOf(15, 18),
  )
  for (interval in merge(intervals)) {
    println(interval.contentToString())
  }
}