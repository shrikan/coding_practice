package Blind75.Q16_Q30;

import Commons.TreeNode;

/*
 * Solution to: 25. https://leetcode.com/problems/validate-binary-search-tree/
 * 
 * Traverse inorder, so that elements are fetched in sorted order.
 * Just keep track of previous element and at every step, if prev element
 * is smaller than current, then it is valid BST.
 */
public class ValidateBinarySearchTree {
	int prev = Integer.MIN_VALUE, index = -1;

	// Time complexity: O(n)
	public boolean isValidBST(TreeNode root) {
		if (root == null) {
			return true;
		}
		if (isValidBST(root.left)) {
			if (index >= 0 && prev >= root.val)
				return false;
			index++;
			prev = root.val;
			return isValidBST(root.right);
		}
		return false;
	}

	public static void main(String[] args) {
		ValidateBinarySearchTree solution = new ValidateBinarySearchTree();
		TreeNode root = new TreeNode(-2147483648);
//		root.left = new TreeNode(1);
//		root.right = new TreeNode(3);
//		root.right.left = new TreeNode(3);
//		root.right.right = new TreeNode(6);

		System.out.println(solution.isValidBST(root));
	}
}
