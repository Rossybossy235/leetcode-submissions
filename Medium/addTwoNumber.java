package Medium;

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        int carryNum = 0;
        
        ListNode newHead = new ListNode(0);
        ListNode current1 = l1;
        ListNode current2 = l2;
        ListNode newCurrent = newHead;
        
        while (current1 != null || current2 != null)
        {
            int x = 0;
            int y = 0;
            int sum;
            
            if (current1 != null)
            {
                x = current1.val;
            }
            
            if (current2 != null)
            {
                y = current2.val;
            }
            
            sum = carryNum + x + y;
            carryNum = sum / 10;
            
            newCurrent.next = new ListNode(sum % 10);
            newCurrent = newCurrent.next;
            
            if (current1 != null)
                current1 = current1.next;
            
            if (current2 != null)
                current2 = current2.next;
        }
        
        if (carryNum > 0)
        {
            newCurrent.next = new ListNode(carryNum);
        }
        
        return newHead.next;
    }
}
