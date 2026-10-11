fun <T : Comparable<T>> bubbleSort(
  list: List<T>,
  comparator: Comparator<T> = naturalOrder()
): List<T> {
  val sortedList = list.toMutableList()

  for (i in 1..<sortedList.size) {
    for (j in 0..(sortedList.size - 1 - i)) {
      if (comparator.compare(sortedList[j], sortedList[j + 1]) > 0) {
        val savedValue = sortedList[j]
        sortedList[j] = sortedList[j + 1]
        sortedList[j + 1] = savedValue
      }
    }
  }

  return sortedList
}