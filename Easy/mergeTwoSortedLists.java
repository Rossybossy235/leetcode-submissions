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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        
        ListNode newHead = null;
        ListNode current1 = list1;
        ListNode current2 = list2;
        
        if (list1 != null && list2 != null)
        {
            if (list1.val < list2.val)
            {
                newHead = list1;
                current1 = current1.next;
            }
            else if (list2.val < list1.val)
            {
                newHead = list2;
                current2 = current2.next;
            }
            else
            {
                newHead = list1;
                current1 = current1.next;
            }
        }
        else if (list2 != null)
        {
            newHead = list2;
            current2 = current2.next;
        }
        else if (list1 != null)
        {
            newHead = list1;
            current1 = current1.next;
        }
        
        ListNode newCurrent = newHead;
        
        while (current1 != null && current2 != null)
        {
            if (current1.val < current2.val)
            {
                newCurrent.next = new ListNode(current1.val);
                current1 = current1.next;
            }
            else if (current2.val < current1.val)
            {
                newCurrent.next = new ListNode(current2.val);
                current2 = current2.next;
            }
            else
            {
                newCurrent.next = new ListNode(current1.val);
                current1 = current1.next;
            }
            
            newCurrent = newCurrent.next;
        }
        
        if (current1 != null)
        {
            while (current1 != null)
            {
                newCurrent.next = new ListNode(current1.val);
                current1 = current1.next;
                
                newCurrent = newCurrent.next;
            }
        }
        else if (current2 != null)
        {
            while (current2 != null)
            {
                newCurrent.next = new ListNode(current2.val);
                current2 = current2.next;
                
                newCurrent = newCurrent.next;
            }
        }
        
        return newHead;
    }
}
