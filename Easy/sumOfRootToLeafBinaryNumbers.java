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
    public int sumRootToLeaf(TreeNode root) {
        
        int sum = totalSum(root, 0);
        
        return sum;
    }
    
    int totalSum(TreeNode node, int parentSum)
    {
        parentSum = parentSum * 2 + node.val;
        
        if (node.left == null && node.right == null)
        {
            return parentSum;
        }
        
        int result = 0;
        
        if (node.left != null)
        {
            result = totalSum(node.left, parentSum);
        }
        if (node.right != null)
        {
            result += totalSum(node.right, parentSum);
        }
        
        return result;
    }
}