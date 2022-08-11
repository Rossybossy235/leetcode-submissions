/*
 * Validate Binary Search Tree - Given the root node of a binary search tree, check whether or not
 * all the nodes are valid.
 * 
 * We traverse the tree, using a min value and a max value. At each node, we check if the value is
 * between the min and max value.
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
    public boolean isValidBST(TreeNode root) {
        return traverse(root, null, null);
    }
    
    public boolean traverse(TreeNode head, Integer min, Integer max) {
        if (head == null)
            return true;
        
        if ((min != null && head.val <= min) || (max != null && head.val >= max))
            return false;
        
        return traverse(head.left, min, head.val) && traverse(head.right, head.val, max);
    }
}