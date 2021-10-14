package Blind75.Q16_Q30;

import Commons.TreeNode;

/*
 * Solution to: 26. https://leetcode.com/problems/same-tree/
 * 
 * Do one of the DFS traversals and check at every stage if both have same
 * values and structure.
 */
public class SameTree {
	// Time complexity: O(n)
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if (p == null || q == null)
			return p == q;
		if (p.val == q.val && isSameTree(p.left, q.left))
			return isSameTree(p.right, q.right);
		return false;
	}

	public static void main(String[] args) {
		SameTree solution = new SameTree();
		TreeNode p = new TreeNode(1);
		p.left = new TreeNode(2);
		p.right = new TreeNode(3);

		TreeNode q = new TreeNode(1);
		q.left = new TreeNode(2);
		q.right = new TreeNode(3);

		System.out.println(solution.isSameTree(p, q));
	}
}
