/*
 * Merge Two Sorted Lists - Given the heads of two sorted singly-linked lists, combine them such
 * that the resulting list is sorted.
 * 
 * We can use a recursive approach this time. First we check if our current nodes are null, meaning we
 * have either reached the end of a list, or the lists were empty to begin with. Then, we check
 * which node has a lesser value, as that node will be next in the resulting list, and make
 * a recursive call accordingly.
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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        
        if (list1 == null)
            return list2;
        if (list2 == null)
            return list1;
        
        if (list1.val < list2.val) {
            list1.next = mergeTwoLists(list1.next, list2);
            return list1;
        }
        else {
            list2.next = mergeTwoLists(list1, list2.next);
            return list2;
        }
    }
}