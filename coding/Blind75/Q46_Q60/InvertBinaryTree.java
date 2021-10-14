package Blind75.Q46_Q60;

import Commons.TreeNode;

/*
 * Solution to: 51. https://leetcode.com/problems/invert-binary-tree/
 */
public class InvertBinaryTree {
	// Time complexity: O(n)
	public TreeNode invertTree(TreeNode root) {
		if (root == null || (root.left == null && root.right == null))
			return root;
		TreeNode temp = root.left;
		root.left = invertTree(root.right);
		root.right = invertTree(temp);

		return root;
	}

	private void print(TreeNode root) {
		if (root == null)
			return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}

	public static void main(String[] args) {
		InvertBinaryTree solution = new InvertBinaryTree();
		TreeNode root = new TreeNode(4);
		root.left = new TreeNode(2);
		root.right = new TreeNode(7);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(3);
		root.right.left = new TreeNode(6);
		root.right.right = new TreeNode(9);

		root = solution.invertTree(root);
		solution.print(root);
	}
}
