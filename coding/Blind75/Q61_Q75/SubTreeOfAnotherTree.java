package Blind75.Q61_Q75;

import Commons.TreeNode;

/*
 * Solution to: 74. https://leetcode.com/problems/subtree-of-another-tree/
 */
public class SubTreeOfAnotherTree {
	public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null)
            return true;
        if(root==null)
            return false;
        if(root.val == subRoot.val && areEqual(root.left, subRoot.left)
          && areEqual(root.right, subRoot.right))
                return true;
        return isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }
    
    private boolean areEqual(TreeNode root, TreeNode subRoot){
        if(subRoot==null && root==null)
            return true;
        if(root==null || subRoot ==null || root.val!=subRoot.val)
            return false;
        return (areEqual(root.left, subRoot.left) && 
                areEqual(root.right, subRoot.right));
    }
    
    public static void main(String[] args) {
		SubTreeOfAnotherTree solution = new SubTreeOfAnotherTree();
		TreeNode root = new TreeNode(3);
		root.left = new TreeNode(4);
		root.right = new TreeNode(5);
		root.left.left = new TreeNode(1);
		root.left.right = new TreeNode(2);
		
		System.out.println(solution.isSubtree(root, root.left));
	}
}
