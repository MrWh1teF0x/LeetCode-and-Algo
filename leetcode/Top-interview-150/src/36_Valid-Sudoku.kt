fun isValidSudoku(board: Array<CharArray>): Boolean {
  val columns = List(9) { mutableListOf<Char>() }
  val rows = List(9) { mutableListOf<Char>() }
  val blocks = List(9) { mutableListOf<Char>() }

  for (row in 0..<9) {
    for (column in 0..<9) {
      val elem = board[row][column]
      val block = (row / 3) * 3 + (column / 3)

      if (columns[column].contains(elem)) return false
      if (rows[row].contains(elem)) return false
      if (blocks[block].contains(elem)) return false
      if (elem != '.') {
        columns[column].add(elem)
        rows[row].add(elem)
        blocks[block].add(elem)
      }
    }
  }

  return true
}

fun main() {
  val boardValid: Array<CharArray> = arrayOf(
    charArrayOf('5', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
  )

  val boardUnvalid: Array<CharArray> = arrayOf(
    charArrayOf('8', '3', '.', '.', '7', '.', '.', '.', '.'),
    charArrayOf('6', '.', '.', '1', '9', '5', '.', '.', '.'),
    charArrayOf('.', '9', '8', '.', '.', '.', '.', '6', '.'),
    charArrayOf('8', '.', '.', '.', '6', '.', '.', '.', '3'),
    charArrayOf('4', '.', '.', '8', '.', '3', '.', '.', '1'),
    charArrayOf('7', '.', '.', '.', '2', '.', '.', '.', '6'),
    charArrayOf('.', '6', '.', '.', '.', '.', '2', '8', '.'),
    charArrayOf('.', '.', '.', '4', '1', '9', '.', '.', '5'),
    charArrayOf('.', '.', '.', '.', '8', '.', '.', '7', '9')
  )

  println(isValidSudoku(boardValid))
  println(isValidSudoku(boardUnvalid))
}