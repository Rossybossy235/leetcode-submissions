/*
 * Lowest Common Ancestor of a Binary Tree - Given a binary tree and two nodes in the tree, find the
 * lowest common ancestor of the two nodes.
 * 
 * We use a depth first search to recursively move through the tree. If the current tree contains
 * both p and q, then the result is the lowest common ancestor.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == p || root == q)
            return root;
        
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        
        if (left == null)
            return right;
        else if (right == null)
            return left;
        else
            return root;
    }
}