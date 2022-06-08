/*
 * Root Equals Sum Of Children - Given the root node of a binary tree with two children,
 * determine whether the sum of the children nodes' values equal the root node.
 * 
 * Since the tree only consists of a root with two children, we can just look at the values
 * of the left and right nodes, and see if they add up to the root node.
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
    public boolean checkTree(TreeNode root) {
        if (root.left.val + root.right.val == root.val)
            return true;
        else
            return false;
    }
}