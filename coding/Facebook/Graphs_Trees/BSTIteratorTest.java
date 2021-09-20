package Facebook.Graphs_Trees;

import java.util.ArrayList;
import java.util.List;

import Commons.TreeNode;

/*
 * Solution to: https://leetcode.com/problems/binary-search-tree-iterator/
 * Create a datastructure to hold the values inorder. Set the ptr to -1.
 * On every call of next(), increment ptr and return the value.
 * For hasnext(), return true until the ptr reaches penultimate
 */
class BSTIterator {
	int ptr;
	List<Integer> values = new ArrayList<Integer>();

	public BSTIterator(TreeNode root) {
		helper(root);
		ptr = -1;
	}

	public int next() {
		return values.get(++ptr);
	}

	public boolean hasNext() {
		return ptr < values.size() - 1;
	}

	private void helper(TreeNode root) {
		if (root == null)
			return;
		helper(root.left);
		values.add(root.val);
		helper(root.right);
	}
}

public class BSTIteratorTest {
	public static void main(String[] args) {
		TreeNode root = new TreeNode(7);
		root.left = new TreeNode(3);
		root.right = new TreeNode(15);
		root.right.left = new TreeNode(9);
		root.right.right = new TreeNode(20);

		BSTIterator bSTIterator = new BSTIterator(root);
		System.out.println(bSTIterator.next());
		System.out.println(bSTIterator.next());
		System.out.println(bSTIterator.hasNext());
		System.out.println(bSTIterator.next());
		System.out.println(bSTIterator.hasNext());
		System.out.println(bSTIterator.next());
		System.out.println(bSTIterator.hasNext());
		System.out.println(bSTIterator.next());
		System.out.println(bSTIterator.hasNext());
	}
}
