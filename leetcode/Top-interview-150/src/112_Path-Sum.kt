fun hasPathSum(root: TreeNode?, targetSum: Int): Boolean {
  if (root == null) return false

  var leftHasPathSum = false
  var rightHasPathSum = false

  val left = root.left
  val right = root.right
  if (left == null && right == null) {
    return root.`val` == targetSum
  }
  if (left != null) leftHasPathSum = hasPathSum(root.left, targetSum - root.`val`)
  if (right != null) rightHasPathSum = hasPathSum(root.right, targetSum - root.`val`)

  return leftHasPathSum || rightHasPathSum
}
