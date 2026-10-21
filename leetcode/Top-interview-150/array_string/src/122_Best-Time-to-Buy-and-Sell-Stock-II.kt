fun maxProfit2(prices: IntArray): Int {
  if (prices.size == 1) return 0
  var totalMaxProfit = 0
  var maxPrice: Int? = null
  var minPrice = prices[0]
  for (i in 1..<prices.size) {
    val price = prices[i]
    if (maxPrice == null) {
      if (price > minPrice) maxPrice = price
      else {
        minPrice = price
      }
    } else {
      if (price > maxPrice) {
        maxPrice = price
      } else {
        totalMaxProfit += maxPrice - minPrice
        minPrice = price
        maxPrice = null
      }
    }
  }
  if (maxPrice != null && maxPrice > minPrice) totalMaxProfit += maxPrice - minPrice
  return totalMaxProfit
}

fun main() {
  val prices = intArrayOf(7, 1, 5, 3, 6, 4)
  println(maxProfit2(prices))
}