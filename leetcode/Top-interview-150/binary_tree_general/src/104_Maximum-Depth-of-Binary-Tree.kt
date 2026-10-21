import kotlin.math.max

class TreeNode(var `val`: Int) {
  var left: TreeNode? = null
  var right: TreeNode? = null
}

fun maxDepth(root: TreeNode?): Int {
  if (root == null) return 0
  return max(maxDepth(root.left), maxDepth(root.right)) + 1
}

fun main() {

}