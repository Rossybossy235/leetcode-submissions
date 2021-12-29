package Easy;

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
    public ListNode removeElements(ListNode head, int val) {
        
        
        ListNode current = head;
        ListNode previous = head;
        
        while(current != null)
        {
            if (current.val == val)
            {
                if (current == head)
                {
                    head = current.next;
                    current = current.next;
                    previous = current;
                }
                else
                {
                    previous.next = current.next;
                    current = current.next;
                }
            }
            else
            {
                if (current == previous)
                {
                    current = current.next;
                }
                else
                {
                    previous = previous.next;
                    current = current.next;
                }
            }
        }
        
        return head;
    }
}
