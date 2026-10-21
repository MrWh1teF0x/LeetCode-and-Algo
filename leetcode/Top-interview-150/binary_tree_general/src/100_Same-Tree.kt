fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
  if (p == null && q == null) return true
  else if (p == null || q == null) return false
  val isSameLeft = isSameTree(p.left, q.left)
  val isSameRight = isSameTree(p.right, q.right)
  return isSameLeft && isSameRight && p.`val` == q.`val`
}