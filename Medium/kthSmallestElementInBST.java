/*
 * Kth Smallest Element in a BST - Given the root of a binary search tree and an integer k, return
 * the kth smallest element in the tree.
 * 
 * We use an inorder traversal to go as far left as we can. Then, as we start to move elsewhere, we
 * increment a counter variable until that variable equals k. When that happens, we set our result
 * variable to the current node's value, and return it.
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
    
    int n = 0;
    int res = 0;
    
    public int kthSmallest(TreeNode root, int k) {
            
        traverse(root, k);
        
        return res;
    }
    
    public void traverse(TreeNode head, int k) {
        if (n == k || head == null)
            return;
        
        traverse(head.left, k);
        n++;
        
        if (n == k) {
            res = head.val;
        }
        
        traverse(head.right, k);
    }
}