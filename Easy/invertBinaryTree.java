/*
 * Given the root node of a binary tree, invert the binary tree such that each level is reversed.
 * 
 * We use a depth-first search to iterate to the bottom of the tree. Then as we move back up, we 
 * swap the left and right of each node.
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
    public TreeNode invertTree(TreeNode root) {
        invert(root);
        
        return root;
    }
    
    public void invert(TreeNode head) {
        if (head == null)
            return;
        
        invert(head.left);
        invert(head.right);
        
        TreeNode temp = head.left;
        head.left = head.right;
        head.right = temp;
    }
}