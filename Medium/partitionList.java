/*
 * Partition List - Given the head of a linked list, and a target value, return the head of a list
 * such that any nodes whos values are less than the target are grouped together, and nodes whos
 * values are greater than or equal to the target are grouped together. Relative ordering of the
 * nodes should stay the same.
 * 
 * We make two new ListNodes head1 and head2 that will act as the heads of two new lists. Then, we
 * iterate through the linked list. If a value is less than the target, we add it to the first list.
 * If a value is greater than or equal to the target, we add it to the second list. At the end, we
 * put our two lists together to get our resulting list. We set the last node's next to null to
 * avoid a cycle/loop in our result list.
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
    public ListNode partition(ListNode head, int x) {
        ListNode head1 = new ListNode(0);
        ListNode head2 = new ListNode(0);
        
        ListNode current1 = head1;
        ListNode current2 = head2;
        
        while (head != null) {
            if (head.val < x) {
                current1.next = head;
                current1 = head;
            }
            else {
                current2.next = head;
                current2 = head;
            }
            
            head = head.next;
        }
        
        current2.next = null;
        current1.next = head2.next;
        return head1.next;
    }
}