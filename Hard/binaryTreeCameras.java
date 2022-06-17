/*
 * Binary Tree Cameras - Given the root of a binary tree, return the minimum number of cameras
 * needed to monitor all nodes of the tree. A camera at a node can monitor its parent, itself, and
 * its immediate children.
 * 
 * We use a depth first search, increasing our count and returning values based on each node's
 * current state:
 * 0 - the node is not covered by a camera
 * 1 - the node has a camera placed on it
 * 2 - the node is monitored by a camera
 * When we fall off the end of the tree, we count that as the node having already been covered by a 
 * camera. If a node's two children are not covered by a camera, then we are at the optimal place
 * to put a camera. We increment our count, and we return 1. If a node's child has a camera placed
 * on it, then the current node is already covered, and we return 2. At the end, we check if the
 * first function call returned 0. If it did, then we need to add one more camera to cover the
 * root node.
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
    
    public int minCameraCover(TreeNode root) {
        int search = dfs(root);
        
        if (search == 0)
            return 1 + res;
        else
            return res;
    }
    
    public int dfs(TreeNode head) {
        if (head == null) {
            return 2;
        }
        
        int left = dfs(head.left);
        int right = dfs(head.right);
        
        if (left == 0 || right == 0) {
            res++;
            return 1;
        }
        
        if (left == 1 || right == 1) {
            return 2;
        }
        else {
            return 0;
        }
    }
}