/*
 * Reverse Linked List - Given the head of a singly-linked list, reverse it.
 * 
 * We recursively swap elements as we go.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        return reverse(head, null);
    }
    
    public ListNode reverse(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        
        ListNode nextNode = head.next;
        head.next = newHead;
        
        return reverse(nextNode, head);
    }
}