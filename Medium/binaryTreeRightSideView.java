/*
 * Binary Tree Right Side View - Given the root node of a binary tree, return the values of the nodes
 * that can be seen when looking to the right (i.e. the right most node on each row of the tree), 
 * ordered from top to bottom.
 * 
 * We use breadth-first search. We iterate through each row of the tree, adding the last node in each
 * row into our results list. 
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
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        
        if (root == null)
            return res;
        
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            for (int i = 0; i < size; i++) {
                TreeNode current = q.poll();
                
                if (i == size - 1)
                    res.add(current.val);
                
                if (current.left != null)
                    q.offer(current.left);
                
                if (current.right != null)
                    q.offer(current.right);
            }
        }
        
        return res;
    }
}