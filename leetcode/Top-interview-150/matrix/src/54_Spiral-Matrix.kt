import kotlin.math.min

fun spiralOrder(matrix: Array<IntArray>): List<Int> {
  val res = mutableListOf<Int>()
  if (matrix.isEmpty()) return res

  val rowsSize = matrix.size
  val columnsSize = matrix[0].size

  val visited = mutableMapOf<Pair<Int, Int>, Boolean>()
  for (row in 0..<rowsSize) {
    for (column in 0..<columnsSize) {
      visited[row to column] = false
    }
  }
  var row = 0
  var column = 0
  repeat(min(matrix.size / 2 + 1, matrix[0].size / 2 + 1)) {
    // Идем по верхней стороне
    while (column < columnsSize) {
      if (visited[row to column] == true) break
      res.add(matrix[row][column])
      visited[row to column] = true
      column += 1
    }
    column -= 1
    // Идем по правой границе
    row += 1
    while (row < rowsSize) {
      if (visited[row to column] == true) break
      res.add(matrix[row][column])
      visited[row to column] = true
      row += 1
    }
    row -= 1
    // Идем по нижней границе
    column -= 1
    while (column >= 0) {
      if (visited[row to column] == true) break
      res.add(matrix[row][column])
      visited[row to column] = true
      column -= 1
    }
    column += 1
    // Идем по левой границе
    row -= 1
    while (row >= 0) {
      if (visited[row to column] == true) break
      res.add(matrix[row][column])
      visited[row to column] = true
      row -= 1
    }
    row += 1
    column += 1
  }
  return res.toList()
}

fun main() {
  val matrix: Array<IntArray> = arrayOf(
    intArrayOf(1, 2, 3),
    intArrayOf(4, 5, 6)
  )

  println(spiralOrder(matrix))
}

