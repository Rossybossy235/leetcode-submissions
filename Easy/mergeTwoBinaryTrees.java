/*
 * Merge Two Binary Trees - Given the roots of two binary trees, merge the two trees. If two nodes
 * overlap, then the new node will have the sum of the values of those two nodes.
 * 
 * We use a depth-first search, traversing through both trees. At each location, we get the sum of
 * the values of both nodes, and make a new node from it. Then, we move left and right, with the 
 * parameters depending on the nodes we are currently looking at.
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
    public TreeNode mergeTrees(TreeNode r1, TreeNode r2) {
        if (r1 == null && r2 == null)
            return null;
        
        int value = 0;
        
        if (r1 != null)
            value += r1.val;
        if (r2 != null)
            value += r2.val;
        
        TreeNode node = new TreeNode(value);
        node.left = mergeTrees(r1 == null ? null : r1.left, r2 == null ? null : r2.left);
        node.right = mergeTrees(r1 == null ? null : r1.right, r2 == null ? null : r2.right);
        
        return node;
    }
}