/*
 * Minimum Depth of a Binary Tree - Given the root node of a binary tree, find the minimum depth
 * of the tree.
 * 
 * We use a breadth-first search or a level order traversal of the tree. We use a queue of pairs,
 * with the node and that node's depth being stored in the pair. As we traverse the tree, we place
 * nodes to be checked and their depths into the queue. If we find a leaf node, we check if that is
 * the minimum depth, and update our variable.
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
    public int minDepth(TreeNode root) {
        
        if (root == null)
            return 0;
        
        int minDepth = Integer.MAX_VALUE;
        Queue<Pair<TreeNode, Integer>> q = new LinkedList<>();
        q.add(new Pair(root, 1));
        
        while (!q.isEmpty()) {
            
            Pair<TreeNode, Integer> temp = q.poll();
            
            if (temp.getKey().left == null && temp.getKey().right == null)
                if (temp.getValue() < minDepth)
                    minDepth = temp.getValue();
            
            if (temp.getKey().left != null)
                q.add(new Pair(temp.getKey().left, temp.getValue() + 1));
            
            if (temp.getKey().right != null)
                q.add(new Pair(temp.getKey().right, temp.getValue() + 1));
        }
        
        return minDepth;
    }
}
