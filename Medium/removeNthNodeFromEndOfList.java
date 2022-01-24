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
        
        ListNode previous;
        ListNode current = head;
        int length = 1;
        int count = 1;
        
        while (current != null)
        {
            length++;
            current = current.next;
        }
        
        previous = head;
        current = head;
        
        while (length - count != n && current.next != null)
        {
            if (previous == current)
            {
                current = current.next;
            }
            else
            {
                previous = previous.next;
                current = current.next;
            }
            
            count++;
        }
        
        if (previous == current)
        {
            head = head.next;
        }
        else
        {
            if (current.next != null)
            {
                previous.next = current.next;
            }
            else
            {
                previous.next = null;
            }
            
            current.next = null;
        }
        
        return head;
    }
}