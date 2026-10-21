import java.util.*

fun averageOfLevels(root: TreeNode?): MutableList<Double> {
  if (root == null) return mutableListOf()
  val list: MutableList<Double> = mutableListOf(root.`val`.toDouble())

  val queue = ArrayDeque<TreeNode>()
  queue.addLast(root)

  while (!queue.isEmpty()) {
    var levelSum = 0L
    var counter = 0
    val parentsSize = queue.size
    for (i in 0..<parentsSize) {
      val node = queue.removeFirst()

      val left = node.left
      if (left != null) {
        queue.addLast(left)
        levelSum += left.`val`
        counter += 1
      }

      val right = node.right
      if (right != null) {
        queue.addLast(right)
        levelSum += right.`val`
        counter += 1
      }
    }
    if (counter > 0) list.add(levelSum.toDouble() / counter)
  }

  return list
}

fun main() {
  val root = TreeNode(3)
  root.left = TreeNode(9)
  root.right = TreeNode(20)
  root.right!!.left = TreeNode(15)
  root.right!!.right = TreeNode(7)

  println(averageOfLevels(root))
}