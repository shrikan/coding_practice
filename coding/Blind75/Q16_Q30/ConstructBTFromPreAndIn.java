package Blind75.Q16_Q30;

import java.util.HashMap;
import java.util.Map;

import Commons.TreeNode;

/*
 * Solution to: 29. https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 * 
 * Store the indices of each node from inorder- this gives us root index.
 * Traverse through preorder, the element encountered is root. split inorder
 * based on root index. elements on left will be left subtree, elements on
 * the right will be right subtree.
 */
public class ConstructBTFromPreAndIn {
	int preIndex = 0;
	Map<Integer, Integer> inOrderMap = new HashMap<>();

	public TreeNode buildTree(int[] preorder, int[] inorder) {
		int len = preorder.length;
		if (len == 0)
			return null;
		for (int i = 0; i < len; i++)
			inOrderMap.put(inorder[i], i);
		return buildUtil(preorder, inorder, 0, len - 1);
	}

	private TreeNode buildUtil(int[] pre, int[] in, int left, int right) {
		if (left > right)
			return null;
		TreeNode root = new TreeNode(pre[preIndex++]);
		if (left != right) {
			int rootIndex = inOrderMap.get(pre[preIndex - 1]);
			root.left = buildUtil(pre, in, left, rootIndex - 1);
			root.right = buildUtil(pre, in, rootIndex + 1, right);
		}
		return root;
	}

	private void print(TreeNode root) {
		if (root == null)
			return;
		System.out.println(root.val);
		print(root.left);
		print(root.right);
	}

	public static void main(String[] args) {
		ConstructBTFromPreAndIn solution = new ConstructBTFromPreAndIn();
		int pre[] = { 3, 9, 5, 4, 6, 20, 15, 7 }, in[] = { 4, 5, 9, 6, 3, 15, 20, 7 };
		TreeNode root = solution.buildTree(pre, in);
		solution.print(root);
	}
}
