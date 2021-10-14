package Blind75.Q31_Q45;

import Commons.TreeNode;

/*
 * Solution to: 31. https://leetcode.com/problems/binary-tree-maximum-path-sum/
 */
public class BTMaxPathSum {
	int maxSum = Integer.MIN_VALUE;

	public int maxPathSum(TreeNode root) {
		if (root == null)
			return 0;
		maxSumUtil(root);
		return maxSum;
	}

	private int maxSumUtil(TreeNode root) {
		if (root == null)
			return 0;
		if (root.left == null && root.right == null) {
			if (root.val > maxSum) {
				maxSum = root.val;
			}
			return root.val;
		}
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
		BTMaxPathSum solution = new BTMaxPathSum();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.right = null;
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.left.left = new TreeNode(7);
		root.right.left.right = new TreeNode(2);
		root.right.left.left.right = new TreeNode(1);
		System.out.println(solution.maxPathSum(root));
	}
}
