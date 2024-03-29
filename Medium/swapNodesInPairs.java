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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null)
            return head;
        
        ListNode dummy = new ListNode();
        ListNode prev = dummy;
        ListNode current = head;
        
        while (current != null && current.next != null)
        {
            prev.next = current.next;
            current.next = prev.next.next;
            prev.next.next = current;
            
            prev = current;
            current = current.next;
        }
        
        return dummy.next;
    }
}