fun <T : Comparable<T>> insertionSort(
  list: List<T>,
  comparator: Comparator<T> = naturalOrder()
): List<T> {
  val sortedList = list.toMutableList()

  for (i in 1..<sortedList.size) {
    var pointer = i
    while (pointer > 0 && comparator.compare(sortedList[pointer - 1], sortedList[pointer]) > 0) {
      val savedValue = sortedList[pointer - 1]
      sortedList[pointer - 1] = sortedList[pointer]
      sortedList[pointer] = savedValue

      pointer -= 1
    }
  }

  return sortedList
}