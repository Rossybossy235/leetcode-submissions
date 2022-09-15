/*
 * Pseudo-Palindromic Paths In a Binary Tree - Given a binary tree who's nodes contain numbers from 1 to
 * 9, return the number of paths that are pseudo-palindromic. A path is pseudo-palindromic if any part
 * of the path contains a palindrome.
 * 
 * We use depth first search and a hash set. We use the hash set to store unique values. If we find
 * a value that is already in the hash set, then we remove that value from the set. If we get to
 * the end of a path and the hash set has one or zero values in it, that means the path was 
 * pseudo-palindromic, and we increase our count.
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
    
    int res = 0;
    
    public int pseudoPalindromicPaths (TreeNode root) {
        Set<Integer> nodes = new HashSet<>();
        traverse(root, nodes);
        
        return res;
    }
    
    public void traverse(TreeNode head, Set<Integer> nodes) {
        if (head == null)
            return;
        if (nodes.contains(head.val)) 
            nodes.remove(head.val);
        else
            nodes.add(head.val);
        
        if (head.left == null && head.right == null)
            if (nodes.size() < 2)
                res++;
        
        traverse(head.left, new HashSet(nodes));
        traverse(head.right, new HashSet(nodes));
    }
}