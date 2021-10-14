package Blind75.Q46_Q60;

import Commons.TreeNode;

/*
 * Solution to: 53. https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/
 * 
 * Since it is BST, you can just check the values and decide.
 * If both values are greater than root, lca shd be in right subtree.
 * If both values are smaller than root, lca shd be in left subtree.
 * If one is on left, other is on right, then root shd be LCA.
 */
public class LCAofBST {
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;
		if (p.val > root.val && q.val > root.val)
			return lowestCommonAncestor(root.right, p, q);
		if (p.val < root.val && q.val < root.val)
			return lowestCommonAncestor(root.left, p, q);
		return root;
	}

	public static void main(String[] args) {
		LCAofBST solution = new LCAofBST();
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
