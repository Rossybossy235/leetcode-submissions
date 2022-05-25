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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        
        traverse(root, res);
        
        return res;
    }
    
    public void traverse(TreeNode head, List<Integer> result) {
        if (head == null)
            return;
        
        result.add(head.val);
        traverse(head.left, result);
        traverse(head.right, result);
    }
}