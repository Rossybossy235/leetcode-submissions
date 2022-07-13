/*
 * Sliding Window Maximum - Given an array of integers and the size of a viewing window, return a list
 * of the maximum values in every placement of the window, where the window can only be moved one
 * place at a time.
 * 
 * We used a double ended queue to keep track of current values in the window. We place new values
 * into the deque, and remove any queues before it that are less than the current value. We check
 * to make sure the number of elements in the deque match the size of the window, then place the last
 * value in the deque into our results list, as that is the current maximum value.
 */

class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> deq = new LinkedList<Integer>();
        int[] res = new int[nums.length - (k - 1)];
        int current = 0;
        
        for (int i = 0; i < nums.length; i++) {
            while (!deq.isEmpty() && nums[deq.getFirst()] < nums[i])
                deq.removeFirst();
            deq.addFirst(i);
            
            if (deq.getLast() <= i - k)
                deq.removeLast();
            
            if (i >= k - 1) {
                res[current] = nums[deq.getLast()];
                current++;
            }
        }
        
        return res;
    }
}