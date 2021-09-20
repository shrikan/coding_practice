package Facebook.Graphs_Trees;

import Commons.TreeNode;

/*
 * Solution to: https://leetcode.com/problems/range-sum-of-bst/
 */
public class RangeSumOfBST {
	// Time complexity: O(n)
	public int rangeSumBST(TreeNode root, int low, int high) {
		if (root == null)
			return 0;
		int sum = 0;
		if (root.val >= low && root.val <= high) {
			sum += root.val;
			sum += rangeSumBST(root.left, low, high);
			sum += rangeSumBST(root.right, low, high);
		} else if (root.val < low) {
			sum += rangeSumBST(root.right, low, high);
		} else {
			sum += rangeSumBST(root.left, low, high);
		}

		return sum;
	}

	public static void main(String[] args) {
		RangeSumOfBST solution = new RangeSumOfBST();
		TreeNode root1 = new TreeNode(10);
		root1.left = new TreeNode(5);
		root1.right = new TreeNode(15);
		root1.left.left = new TreeNode(3);
		root1.left.right = new TreeNode(7);
		root1.right.right = new TreeNode(18);

		TreeNode root2 = new TreeNode(10);
		root2.left = new TreeNode(5);
		root2.right = new TreeNode(15);
		root2.left.left = new TreeNode(3);
		root2.left.left.left = new TreeNode(1);
		root2.left.right = new TreeNode(7);
		root2.left.right.left = new TreeNode(6);
		root2.right.left = new TreeNode(13);
		root2.right.right = new TreeNode(18);

		System.out.println(solution.rangeSumBST(root1, 7, 15));
		System.out.println(solution.rangeSumBST(root2, 6, 10));
	}
}
