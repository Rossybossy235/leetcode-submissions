/*
 * Flatten Binary Tree To Linked List - Given a binary tree, rearrange the nodes such that they are
 * in the order of a preorder traversal. Nodes should be linked by their "right" pointers.
 * 
 * First, we do a preorder traversal of the tree, placing nodes into a queue. Then, we simply order
 * the nodes starting from the root using the queue, placing nodes onto the previous node's right
 * pointer.
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
    public void flatten(TreeNode root) {
        
        if (root == null)
            return;
        
        Queue<TreeNode> q = new LinkedList<>();
        
        traverse(root, q);
        
        root = q.remove();
        TreeNode current = root;
        root.left = null;
        
        while (!q.isEmpty()) {
            current.left = null;
            current.right = q.remove();
            current = current.right;
        }
    }
    
    public void traverse(TreeNode head, Queue<TreeNode> q) {
        if (head == null)
            return;
        
        q.add(head);
        traverse(head.left, q);
        traverse(head.right, q);
    }
}