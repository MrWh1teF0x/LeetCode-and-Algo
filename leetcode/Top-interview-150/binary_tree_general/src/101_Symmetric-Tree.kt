fun isSymmetric(root: TreeNode?): Boolean {
  if (root == null) return true
  return isSymmetricChildren(root.left, root.right)
}

fun isSymmetricChildren(left: TreeNode?, right: TreeNode?): Boolean {
  if (left == null && right == null) return true
  if (left == null || right == null) return false
  return isSymmetricChildren(left.left, right.right) && isSymmetricChildren(
    left.right,
    right.left
  ) && left.`val` == right.`val`
}

fun main() {
  val root = TreeNode(1)
  root.left = TreeNode(2)
  root.right = TreeNode(3)

  println(isSymmetric(root))
}