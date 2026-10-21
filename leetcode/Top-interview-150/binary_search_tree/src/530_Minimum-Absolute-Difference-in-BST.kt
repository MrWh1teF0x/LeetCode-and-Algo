import kotlin.math.abs
import kotlin.math.min

fun getMinimumDifference(root: TreeNode?): Int {
  if (root == null) return Int.MAX_VALUE
  val left = root.left
  val right = root.right

  var maxLeftRightChild = Int.MAX_VALUE
  if (left != null) maxLeftRightChild = getMaxRightChild(left)

  var minRightLeftChild = Int.MAX_VALUE
  if (right != null) minRightLeftChild = getMinLeftChild(right)

  return min(
    min(abs(maxLeftRightChild - root.`val`), abs(minRightLeftChild - root.`val`)),
    min(getMinimumDifference(left), getMinimumDifference(right))
  )
}

fun getMaxRightChild(root: TreeNode): Int {
  if (root.right == null) return root.`val`
  return getMaxRightChild(root.right!!)
}

fun getMinLeftChild(root: TreeNode): Int {
  if (root.left == null) return root.`val`
  return getMinLeftChild(root.left!!)
}

fun main() {
  val root = TreeNode(600)
  root.left = TreeNode(424)
  root.right = TreeNode(612)
  root.left!!.right = TreeNode(499)
  root.right!!.right = TreeNode(689)

  println(getMinimumDifference(root))
}