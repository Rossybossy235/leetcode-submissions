/*
 * Constructing Target Array With Multiple Sums - You are given a target array of integers, and an
 * operation you can perform: starting from an array of 1s of the same size as target, replace one
 * index with the sum of all elements. Determine whether performing this operation any number of 
 * times can result in the target array.
 * 
 * We use a max heap, and work backwards, starting at the target array and working towards an array 
 * of 1s. First, we loop through the array, keeping a sum of all numbers and adding them to our heap.
 * Then, while the heap has elements in it, we take the largest number in the heap, and subtract the
 * sum of the other elements from it. If the sum of the other elements is greater than the largest
 * number or the sum of the others elements is 0, we can return false. Otherwise, we perform the
 * subtraction, subtract the current largest number from our total sum, and push the new number
 * to our heap.
 */

class Solution {
    public boolean isPossible(int[] target) {
        PriorityQueue<Integer> heap = new PriorityQueue<>(Collections.reverseOrder());
        long sum = 0;
        
        for (int i = 0; i < target.length; i++) {
            sum += target[i];
            
            if (target[i] != 1)
                heap.add(target[i]);
        }
        
        while (!heap.isEmpty()) {
            long tar = heap.poll();
            
            long rsum = sum - tar;
            
            if (rsum >= tar || rsum == 0)
                return false;
            
            int temp = (int) tar;
            tar = tar % rsum == 0 ? rsum : tar % rsum;
            sum -= temp - tar;
            
            if (tar != 1)
                heap.add((int) tar);
        }
        
        return true;
    }
}