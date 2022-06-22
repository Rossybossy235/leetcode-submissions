/*
 * Delete Node in a Linked List - Given a linked list node to be deleted, remove that node from
 * the linked list.
 * 
 * Since we aren't given the head node of the list, we have to change node values instead. So we 
 * iterate from the given to to the end of the list, changing values as we go. Then, we remove the
 * last node. This is an odd problem, as it somewhat defeats the purpose of linked lists, and 
 * excludes some extranous test cases, like if the node to be deleted was the tail of the list.
 */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode current = node;
        
        while (current.next.next != null) {
            current.val = current.next.val;
            current = current.next;
        }
        
        current.val = current.next.val;
        current.next = null;
    }
}