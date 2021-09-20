package Facebook.Graphs_Trees;

import Commons.TreeNode;

/*
 * Solution to: https://leetcode.com/problems/diameter-of-binary-tree/
 * Traverse through left and right. If this path from left to right is higher than 
 * current highest, include this as new diameter.
 * Return longer length b/w left subtree and right subtree adding one extra path to root
 * 
 *  Return highest scored diameter at the end.
 */
public class DiameterOfaBinaryTree {
	int diameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {
		diameterUtil(root);
		return diameter;
	}

	private int diameterUtil(TreeNode root) {
		if (root == null)
			return 0;
		int left = diameterUtil(root.left);
		int right = diameterUtil(root.right);

		diameter = Math.max(diameter, left + right);

		return 1 + Math.max(left, right);
	}

	public static void main(String[] args) {
		DiameterOfaBinaryTree solution = new DiameterOfaBinaryTree();
		TreeNode root = new TreeNode(1);
		root.left = new TreeNode(2);
		root.left.left = new TreeNode(4);
		root.left.right = new TreeNode(5);
		root.right = new TreeNode(3);
		System.out.println(solution.diameterUtil(root));
	}
}
