/*
 * Balanced Binary Tree - Given a binary tree, determine if it is height balanced. A tree is
 * height balanced if the left and right subtrees of every node differ in height by no more than
 * one.
 * 
 * We use depth-first search. If any nodes' left and right subtrees differ by more than one, we return
 * -1. If it is balanced, we return a non -1 number. Depending on the values of left and right, a 
 * parent node can determine whether its subtrees are balanced, and decide on its return value.
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
    
    public boolean isBalanced(TreeNode root) {
        return traverse(root) != -1;
    }
    
    public int traverse(TreeNode head) {
        if (head == null) 
            return 0;
        
        int left = traverse(head.left);
        if (left == -1)
            return -1;
        
        int right = traverse(head.right);
        if (right == -1)
            return -1;
        
        if (Math.abs(left - right) > 1)
            return -1;
        
        return Math.max(left, right) + 1;
    }
}