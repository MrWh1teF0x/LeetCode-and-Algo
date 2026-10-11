import kotlin.random.Random

fun main() {
  val list = List(10) { Random.nextInt(0, 100) }
  println(insertionSort(list).toString())
}