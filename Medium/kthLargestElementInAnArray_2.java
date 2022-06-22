/*
 * Kth Largest Element in an Array - Given an array of integers, find the kth (second, third, etc) 
 * largest element in the array.
 * 
 * We use a min-heap (java default). We loop through the array, adding elements to the heap. When 
 * the size of the heap exceeds k, we pop the top element. This happens because the largest 
 * elements get added to the bottom of the heap, which pushes values that are too small up and out
 * of our bounds (k). At the end, the kth largest element will be at the top of our heap.
 */

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        
        for (int i = 0; i < nums.length; i++) {
            heap.add(nums[i]);
            
            if (heap.size() > k)
                heap.poll();
        }
        
        return heap.peek();
    }
}