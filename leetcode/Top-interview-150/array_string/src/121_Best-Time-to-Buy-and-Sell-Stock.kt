import kotlin.math.max

fun maxProfit(prices: IntArray): Int {
  var bestProfit = 0
  var minPrice = if (!prices.isEmpty()) prices[0] else 0
  var maxPrice = if (!prices.isEmpty()) prices[0] else 0

  for (i in 0..(prices.size - 1)) {
    val price = prices[i]
    if (maxPrice <= price) maxPrice = price
    else if (minPrice > price) {
      bestProfit = max(bestProfit, maxPrice - minPrice)
      minPrice = price
      maxPrice = price
    }
  }

  return max(bestProfit, maxPrice - minPrice)
}

fun main() {
  val prices = intArrayOf(1, 0, 5, 6)
  println(maxProfit(prices))
}