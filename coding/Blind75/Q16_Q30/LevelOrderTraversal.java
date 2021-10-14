package Blind75.Q16_Q30;

import java.util.ArrayList;
import java.util.List;

import Commons.TreeNode;

/*
 * Solution to: 27. https://leetcode.com/problems/binary-tree-level-order-traversal/
 * 
 * Pass the levels(incrementing on each call) and add the node in corresponding level in the list.
 */
public class LevelOrderTraversal {
	public List<List<Integer>> levelOrder(TreeNode root) {
		return traverse(root, new ArrayList<List<Integer>>(), 0);
	}

	private List<List<Integer>> traverse(TreeNode root, List<List<Integer>> listOfNodes, int level) {
		if (root == null)
			return listOfNodes;
		if (listOfNodes.size() > level) {
			List<Integer> row = listOfNodes.get(level);
			row.add(root.val);
			listOfNodes.set(level, row);
		} else {
			List<Integer> row = new ArrayList<>();
			row.add(root.val);
			listOfNodes.add(level, row);
		}
		listOfNodes = traverse(root.left, listOfNodes, level + 1);
		return traverse(root.right, listOfNodes, level + 1);
	}

	public static void main(String[] args) {
		LevelOrderTraversal solution = new LevelOrderTraversal();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(9);
		root.right = new TreeNode(20);
		root.right.left = new TreeNode(15);
		root.right.right = new TreeNode(7);
		List<List<Integer>> res = solution.levelOrder(root);

		for (List<Integer> row : res) {
			for (Integer ele : row)
				System.out.print(ele + " ");
			System.out.println();
		}
	}
}
