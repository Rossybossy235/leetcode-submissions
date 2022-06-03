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
    public ListNode deleteDuplicates(ListNode head) {
        
        if (head == null)
            return null;
        
        if (head.next == null)
            return head;
        
        ListNode current = head;
        ListNode newCurrent = head.next;
        
        while (current != null && newCurrent != null)
        {
            if (current.val != newCurrent.val)
            {
                newCurrent = newCurrent.next;
                current = current.next;
            }
            else 
            {
                newCurrent = newCurrent.next;
                current.next = newCurrent;
            }
        }
        
        return head;
    }
}