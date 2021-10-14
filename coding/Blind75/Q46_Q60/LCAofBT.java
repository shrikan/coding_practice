package Blind75.Q46_Q60;

import Commons.TreeNode;

/*
 * Solution to: 54. https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/
 * 
 *  Unlike BST, we cant decide on values alone. Have to traverse till we find the node.
 *  Then,
 *  if both lie on one side, lca would have already be obtained, return the same.
 *  Else if they are found in separate(left and right) subtrees, then root is the answer.
 */
public class LCAofBT {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root.val == p.val || root.val == q.val)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		if (left != null && right != null)
			return root;
		return (left == null ? right : left);
	}

	public static void main(String[] args) {
		LCAofBT solution = new LCAofBT();
		TreeNode root = new TreeNode(6);
		root.left = new TreeNode(2);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(0);
		root.left.right = new TreeNode(4);
		root.right.left = new TreeNode(7);
		root.right.right = new TreeNode(9);
		root.left.right.left = new TreeNode(3);
		root.left.right.right = new TreeNode(5);

		System.out.println(solution.lowestCommonAncestor(root, root.left, root.right).val);
	}
}
