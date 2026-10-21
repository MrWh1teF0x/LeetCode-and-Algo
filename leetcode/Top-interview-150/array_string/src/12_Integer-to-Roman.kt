fun intToRoman(num: Int): String {
  var temp = num
  val res = StringBuilder()
  // Обработка тысяч
  if (temp in 1000..3999) {
    var n = temp / 1000
    temp -= n * 1000
    while (n != 0) {
      res.append("M")
      n -= 1
    }
  }
  // Обработка сотен
  if (temp in 100..999) {
    var n = temp / 100
    temp -= n * 100
    when (n) {
      9 -> res.append("CM")
      4 -> res.append("CD")
      else -> {
        if (n >= 5) {
          res.append("D")
          n -= 5
        }
        while (n != 0) {
          res.append("C")
          n -= 1
        }
      }
    }
  }
  // Обработка десятков
  if (temp in 10..99) {
    var n = temp / 10
    temp -= n * 10
    when (n) {
      9 -> res.append("XC")
      4 -> res.append("XL")
      else -> {
        if (n >= 5) {
          res.append("L")
          n -= 5
        }
        while (n != 0) {
          res.append("X")
          n -= 1
        }
      }
    }
  }
  // Обработка единиц
  if (temp in 1..9) {
    var n = temp
    when (n) {
      9 -> res.append("IX")
      4 -> res.append("IV")
      else -> {
        if (n >= 5) {
          res.append("V")
          n -= 5
        }
        while (n != 0) {
          res.append("I")
          n -= 1
        }
      }
    }
  }
  return res.toString()
}

fun main() {
  println(intToRoman(3749))
}