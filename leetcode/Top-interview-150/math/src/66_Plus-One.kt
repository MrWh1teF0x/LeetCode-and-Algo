fun plusOne(digits: IntArray): IntArray {
  val newNums = mutableListOf<Int>()
  var transfer = 1
  for (d in digits.reversed()) {
    val sum = d + transfer
    transfer = sum / 10
    newNums.add(sum % 10)
  }
  if (transfer > 0) newNums.add(transfer)
  return newNums.reversed().toIntArray()
}

fun main() {

}