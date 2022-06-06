/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */

/*
 * Intersection of 2 Linked Lists - Given the heads of two linked lists, return the ListNode
 * where they intersect. If they do not intersect, return null. The structure and values
 * of the lists should stay the same.
 * 
 * We can iterate over the first list, changing the values to (value * -1). Then we iterate over the
 * second list, and if we find a negative value, then that is the intersection point. We can use
 * a boolean to check if we already found the itersection point.
 * Now, we have to iterate over the first list again to change all the values back to their
 * original ones such that the list structures are the same when we are finished.
 */

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode current1 = headA;
        ListNode current2 = headB;
        ListNode res = null;
        boolean found = false;
        
        while(current1 != null) {
            current1.val = current1.val * -1;
            
            current1 = current1.next;
        }
        
        while (current2 != null) {
            if (current2.val < 0) {
                if (found == false) {
                    res = current2;
                    found = true;
                }
            }
            
            current2 = current2.next;
        }
        
        current1 = headA;
        
        while(current1 != null) {
            if (current1.val < 0)
                current1.val = current1.val * -1;
            
            current1 = current1.next;
        }
        
        return res;
    }
}