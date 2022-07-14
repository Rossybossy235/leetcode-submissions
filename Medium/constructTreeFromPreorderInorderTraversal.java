/*
 * Construct Binary Tree From Preorder and Inorder Traversal - Given two arrays of integers representing
 * a preorder and inorder traversal of a binary tree, reconstruct the binary tree.
 * 
 * Since all the nodes in preorder are going to be the root nodes for some subtree, we can use
 * that to get the values in order. We find the value of the preorder node in the inorder array,
 * create a new node, and recursively find the rest of the nodes in the subtree, adjusting our
 * search window to find values in inorder as we go.
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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(0, 0, inorder.length - 1, preorder, inorder);
    }
    
    public TreeNode build(int pre, int start, int end, int[] preorder, int[] inorder) {
        if (pre > preorder.length - 1 || start > end)
            return null;
        
        TreeNode n = new TreeNode(preorder[pre]);
        
        int inIdx = 0;
        for (int i = start; i <= end; i++) 
            if (inorder[i] == n.val)
                inIdx = i;
        
        n.left = build(pre + 1, start, inIdx - 1, preorder, inorder);
        n.right = build(pre + inIdx - start + 1, inIdx + 1, end, preorder, inorder);
        return n;
    }
}