/*
 * Binary Tree Level Order Traversal - Given the root node of a binary tree, return a list of 
 * values from a level-order traversal of the tree.
 * 
 * We use a queue to keep track of the row that needs to be traversed. At each node, we add its left
 * and right node to the queue, and add its value to a list of integers. Once we reach the end of the
 * row, we add the current list of integers into our results list.
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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<TreeNode> q = new LinkedList<TreeNode>();
        
        if (root == null)
            return res;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> current = new LinkedList<Integer>();
            
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null)
                    q.add(q.peek().left);
                if (q.peek().right != null)
                    q.add(q.peek().right);
                
                current.add(q.poll().val);
            }
            
            res.add(current);
        }
        
        return res;
    }
}