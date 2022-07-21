/*
 * Reverse Linked List II - Given the head of a linked list and two integers, left and right, reverse
 * the nodes in the list from position left to position right.
 * 
 * We can use a dummy node placed before the head for convenience. We iterate a previous pointer to
 * the start of the interval to reverse, set a start pointer and a current pointer (rev), then 
 * reverse the interval of the list. We return dummy.next, since it is the head.
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null)
            return null;
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode previous = dummy;
        
        for (int i = 0; i < left - 1; i++)
            previous = previous.next;
        
        ListNode start = previous.next;
        ListNode rev = start.next;
        
        for (int i = 0; i < right - left; i++) {
            start.next = rev.next;
            rev.next = previous.next;
            previous.next = rev;
            rev = start.next;
        }
        
        return dummy.next;
    }
}