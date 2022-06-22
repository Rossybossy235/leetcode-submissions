/*
 * Same Tree - Given the root nodes of two binary trees, determine whether the trees are the same.
 * 
 * We iterate through the tree, first checking if both nodes are null, then if either one are null, 
 * then if their values are the same. If the results of both the left checks and right checks mean
 * those parts of the trees are the same, we return true.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null)
            return true;
        if (p == null || q == null)
            return false;
        if (p.val != q.val)
            return false;
        
        return isSameTree(p.right, q.right) && isSameTree(p.left, q.left);
    }
}