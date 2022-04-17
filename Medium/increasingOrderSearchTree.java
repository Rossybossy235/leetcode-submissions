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
    public TreeNode increasingBST(TreeNode root) {
        List<Integer> nums = new ArrayList();
        traverse(root, nums);
        
        TreeNode newTree = new TreeNode(0);
        TreeNode current = newTree;
        
        for (int n: nums)
        {
            current.right = new TreeNode(n);
            current = current.right;
        }
        
        return newTree.right;
    }
    
    public void traverse(TreeNode node, List<Integer> nums)
    {
        if (node == null)
            return;
        traverse(node.left, nums);
        nums.add(node.val);
        traverse(node.right, nums);
    }
}