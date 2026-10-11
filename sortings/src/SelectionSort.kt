fun <T: Comparable<T>> selectionSort(
  list: List<T>,
  comparator: Comparator<T> = naturalOrder()
): List<T> {
  val sortedList = list.toMutableList()

  var pointer = 0
  for (i in 0..<sortedList.size) {
    var minIndex = pointer

    for (j in (i+1)..<sortedList.size)
      if (comparator.compare(sortedList[minIndex], sortedList[j]) > 0) minIndex = j

    val savedValue = sortedList[pointer]
    sortedList[pointer] = sortedList[minIndex]
    sortedList[minIndex] = savedValue

    pointer += 1
  }

  return sortedList
}