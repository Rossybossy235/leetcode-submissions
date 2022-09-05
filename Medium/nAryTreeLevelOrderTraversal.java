/*
 * N-ary Tree Level Order Traversal - Given the root of a binary tree where each node can have any
 * number of children, return a level order traversal of the tree.
 * 
 * This problem is very similar to a level order traversal of a binary tree, except each node has a
 * list of its children. We start by adding the root to a queue. Then, we iterate over the queue until
 * the queue is empty, placing each row into a temporary list to add to our results list. For each 
 * node, we loop through its children list, adding them to the queue.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> res = new LinkedList<List<Integer>>();
        Queue<Node> q = new LinkedList<Node>();
        
        if (root == null)
            return res;
        
        q.add(root);
        
        while (!q.isEmpty()) {
            int size = q.size();
            
            List<Integer> current = new LinkedList<Integer>();
            
            for (int i = 0; i < size; i++) {
                if (q.peek().children != null) {
                    for (int j = 0; j < q.peek().children.size(); j++) {
                        q.add(q.peek().children.get(j));
                    }
                }
                
                current.add(q.poll().val);
            }
            
            res.add(current);
        }
        
        return res;
    }
}