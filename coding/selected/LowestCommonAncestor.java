package selected;

/**
 * Solution to:
 * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-tree/description/
 * 
 * @author shrinidhikanchi
 *
 */

// Definition for a binary tree node.
class TreeNode {
	int val;
	TreeNode left;
	TreeNode right;

	TreeNode(int x) {
		val = x;
	}
}

public class LowestCommonAncestor {
	// Time complexity O(n)
	public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
		if (root == null)
			return null;

		if (root.val == p.val || root.val == q.val)
			return root;

		TreeNode left = lowestCommonAncestor(root.left, p, q);
		TreeNode right = lowestCommonAncestor(root.right, p, q);

		// If one node is found on left and other on right, then current node is
		// ancestor
		if (left != null && right != null)
			return root;
		return (left == null ? right : left);
	}

	public static void main(String[] args) {
		LowestCommonAncestor solution = new LowestCommonAncestor();
		/*
		 * Sample test case tree
		 *               10
		 *             /    \
		 *            5      7
		 *           / \    / \
		 *          3   6  8   4
		 */
		TreeNode tree = new TreeNode(10);
		
		tree.left = new TreeNode(5);
		tree.right = new TreeNode(7);

		tree.left.left = new TreeNode(3);
		tree.left.right = new TreeNode(6);
		tree.right.left = new TreeNode(8);
		tree.right.right = new TreeNode(4);

		TreeNode left = new TreeNode(3);
		TreeNode right = new TreeNode(10);

		System.out.println(solution.lowestCommonAncestor(tree, left, right).val);
	}
}
