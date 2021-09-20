package Facebook.Graphs_Trees;

import Commons.TreeNode;

/*
 * Solution to: https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class MaximumPathSumBinTree {
	int maxSum = Integer.MIN_VALUE;

	public int findMaxSum(TreeNode root) {
		maxSumUtil(root);
		return maxSum;
	}

	private int maxSumUtil(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null)
			return root.val;

		int sumLeft = maxSumUtil(root.left);
		int sumRight = maxSumUtil(root.right);

		int path_sum = Math.max(root.val, Math.max(sumLeft, sumRight) + root.val);
		int maxSoFar = Math.max(path_sum, sumLeft + sumRight + root.val);
		if (maxSoFar > maxSum) {
			maxSum = maxSoFar;
		}
		return path_sum;
	}

	public static void main(String[] args) {
		MaximumPathSumBinTree solution = new MaximumPathSumBinTree();
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(20);
		root.left.right = new TreeNode(1);
		root.right = new TreeNode(10);
		root.right.right = new TreeNode(-25);
		root.right.right.left = new TreeNode(3);
		root.right.right.right = new TreeNode(4);
		System.out.println(solution.findMaxSum(root));
	}
}
