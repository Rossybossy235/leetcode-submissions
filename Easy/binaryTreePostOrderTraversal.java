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

/*
 * Binary Tree Postorder Traversal - given the root node of a binary tree, do a postorder
 * traversal of the tree, adding elements into a List.
 * 
 * A good ol' postorder traversal using recursion. Iterate all the way to the left, then 
 * to the right, then add values into the List as you move back up the tree.
 */

class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        traverse(root, res);
        
        return res;
    }
    
    public void traverse(TreeNode head, List<Integer> list) {
        if (head == null)
            return;
        
        traverse(head.left, list);
        traverse(head.right, list);
        list.add(head.val);
    }
}