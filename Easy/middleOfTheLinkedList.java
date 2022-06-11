/*
 * Middle of the Linked List - Given the head of a singly-linked list, return the middle node
 * of the list. If the list has an even length, return the second of the middle two nodes.
 * 
 * We use two pointers, one slow and one fast. For each iteration, the slow pointer will move
 * one to the right, and the fast pointer will move two to the right. When the fast pointer
 * reaches the end of the list, our slow pointer will be on the middle node.
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
    public ListNode middleNode(ListNode head) {
        ListNode current1 = head;
        ListNode current2 = head;
        
        while (current2 != null && current2.next != null) {
            current1 = current1.next;
            current2 = current2.next.next;
        }
        
        return current1;
    }
}