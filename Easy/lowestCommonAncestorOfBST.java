/*
 * Lowest Common Ancestor of a Binary Search Tree - Given a binary search tree and two nodes, find the
 * lowest common ancestor of the two given nodes (the lowest node such that the two given nodes are
 * descendants of it).
 * 
 * We traverse the tree. If the current node is greater than both p and q, then we can go further left.
 * If the current node is less than both p and q, then we can go further right. When the current node
 * is neither less than or greater than both p and q, we have found our least common ancestor.
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
        if (root.val > p.val && root.val > q.val)
            return lowestCommonAncestor(root.left, p, q);
        else if (root.val < p.val && root.val < q.val)
            return lowestCommonAncestor(root.right, p, q);
        else
            return root;
    }
}