/*
 * Populating Next Right Pointers in Each Node - Given a binary tree where each Node has a next
 * pointer to point to its next right node (directly to the right, not that node's .right), populate
 * those next pointers.
 * 
 * We iterate through the tree recursively. At each node, we check if that node's left is defined. 
 * If it is, we set the left node's right to the head node's right. We then check if the head node's
 * next is defined. If it is, we set the right node's next to the head node's next.left.
 */

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        
        traverse(root);
        
        return root;
    }
    
    public void traverse(Node head) {
        if (head == null)
            return;
        
        if (head.left != null) {
            head.left.next = head.right;
            
            if (head.next != null)
                head.right.next = head.next.left;
        }
        
        connect(head.left);
        connect(head.right);
    }
}