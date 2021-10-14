package Blind75.Q16_Q30;

import Commons.TreeNode;

/*
 * Solutiton to: 28. https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * 
 * Check for max height in left and right subtree. Return that value with
 * one extra level(root to that subtree)
 */
public class MaximumDepthOfBinaryTree {
	// Time complexity: O(n)
	public int maxDepth(TreeNode root) {
		if (root == null)
			return 0;
		int left = maxDepth(root.left);
		int right = maxDepth(root.right);
		return 1 + ((left > right) ? left : right);
	}

	public static void main(String[] args) {
		MaximumDepthOfBinaryTree solution = new MaximumDepthOfBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(9);
		root.right = new TreeNode(2);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		System.out.println(solution.maxDepth(root));
	}
}
