package Blind75.Q46_Q60;

import Commons.TreeNode;

/*
 * Solution to: 52. https://leetcode.com/problems/kth-smallest-element-in-a-bst/
 * 
 * Inorder traversal gives ascending order sorted elements.
 * By keeping track of k from there should fetch in O(n)
 */
public class KthSmallestBST {
	int smallest = -1;

	// Time complexity: O(n) 
	public int kthSmallest(TreeNode root, int k) {
		if (root.left == null && root.right == null) {
			return root.val;
		}
		kthSmallestUtil(root, k);
		return smallest;
	}

	private int kthSmallestUtil(TreeNode root, int k) {
		if (root == null)
			return k;
		k = kthSmallestUtil(root.left, k);
		if (--k == 0) {
			smallest = root.val;
			return k;
		}
		return kthSmallestUtil(root.right, k);
	}

	public static void main(String[] args) {
		KthSmallestBST solution = new KthSmallestBST();
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(3);
		root.right = new TreeNode(6);
		root.left.left = new TreeNode(2);
		root.left.right = new TreeNode(4);
		root.left.left.left = new TreeNode(1);

		System.out.println(solution.kthSmallest(root, 1));
	}
}
