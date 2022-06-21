/*
 * Furthest Building You Can Reach - View LeetCode problem for explanation.
 * 
 * We use a greedy algorithm. GREEDY IS GOD MORTY. We iterate through the list, placing our ladders
 * at the tallest locations. Then, when we run out of ladders, we begin filling in locations with
 * bricks, and go as far as we can.
 */

class Solution {
    public int furthestBuilding(int[] heights, int bricks, int ladders) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        int bricksUsed = 0;
        
        for (int i = 1; i < heights.length; i++) {
            int diff = heights[i] - heights[i - 1];
            if (diff > 0) {
                if (ladders > 0 && (heap.isEmpty() || heap.size() != ladders || diff > heap.peek())) {
                    if (heap.size() == ladders && diff > heap.peek()) {
                        bricksUsed += heap.poll();
                    }
                    heap.add(diff);
                }
                else
                    bricksUsed += diff;
                
                if (bricksUsed > bricks)
                    return i - 1;
            }
        }
        
        return heights.length - 1;
    }
}