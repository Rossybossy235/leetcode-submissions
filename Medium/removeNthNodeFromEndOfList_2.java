/*
 * Remove Nth Node From End of List - Given the head of a singly-linked list and an integer
 * n, remove the Nth node from the end of the list.
 * 
 * We use a two pointer approach, a current pointer and a previous pointer. We first iterate
 * through the list to determine its length. Then we reset our pointers, and iterate through
 * the list again until our current pointer lands on the node to remove. Then, we remove it
 * and return the head of the list.
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode current1 = head;
        ListNode current2 = head;
        int length = 1;
        int count = 1;
        
        while (current2 != null) {
            length++;
            current2 = current2.next;
        }
        
        current2 = head;
        
        while (length - count != n && current2 != null) {
            if (current1 == current2) {
                current2 = current2.next;
            }
            else {
                current1 = current1.next;
                current2 = current2.next;
            }
            
            count++;
        }
        
        if (current1 == current2)
            head = head.next;
        else {
            if (current2.next != null) {
                current1.next = current2.next;
            }
            else {
                current1.next = null;
            }
            
            current2.next = null;
        }
        
        return head;
    }
}