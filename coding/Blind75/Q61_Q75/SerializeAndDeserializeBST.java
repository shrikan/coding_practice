package Blind75.Q61_Q75;

import Commons.TreeNode;

public class SerializeAndDeserializeBST {
	// Encodes a tree to a single string.
	public String serialize(TreeNode root) {
		return "";
	}

	// Decodes your encoded data to tree.
	public TreeNode deserialize(String data) {
		return null;
	}

	private void print(TreeNode root) {
		if (root == null)
			return;
		print(root.left);
		System.out.println(root.val);
		print(root.right);
	}

	public static void main(String[] args) {
		SerializeAndDeserializeBST solution = new SerializeAndDeserializeBST();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		root.right = new TreeNode(4);

		String res = solution.serialize(root);
		TreeNode res1 = solution.deserialize(res);
		System.out.println(res);
		solution.print(res1);
	}
}
