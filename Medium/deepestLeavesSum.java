/*
 * Deepest Leaves Sum - Given the root of a binary tree, return the sum of the deepest
 * leaves in the tree, i.e. the nodes at the bottom of the tree.
 * 
 * Since we need all the function calls to know the current sum and max depth of the
 * tree, we make those class variables. Then we do a depth first search. If the current
 * depth is bigger than the current max depth, we reset the sum, and change max depth
 * to be the current depth. If the current depth equals the current max depth, we 
 * increase sum by that node's value. Then we do a call to the left node and a call
 * to the right node.
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
    int sum = 0;
    int maxDepth = 1;
    
    public int deepestLeavesSum(TreeNode root) {
        
        traverse(root, 1);
        
        return sum;
    }
    
    public void traverse(TreeNode head, int depth) {
        if (head == null)
            return;
        
        if (depth > maxDepth) {
            maxDepth = depth;
            sum = head.val;
        }
        else if (depth == maxDepth) {
            sum += head.val;
        }
        
        traverse(head.left, depth + 1);
        traverse(head.right, depth + 1);
    }
}