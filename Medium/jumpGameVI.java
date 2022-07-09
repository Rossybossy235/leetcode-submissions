/*
 * Jump Game VI - Starting from the beginning of an array of integers, you can jump forward at most k
 * distance. You want to reach the last element of the array while achieving the highest possible
 * score, with your score being the sum of array elements that you visited. Find the maximum score
 * you can get.
 * 
 * We use dynammic programming and a priority queue to keep track of the current max score, and move
 * through the array to ultimately find the largest score possible.
 */

class Solution {
    public int maxResult(int[] nums, int k) {
        int len = nums.length;
        int[] dp = new int[len + 1];
        Arrays.fill(dp, Integer.MIN_VALUE);
        
        PriorityQueue<Pair<Integer,Integer>> q = new PriorityQueue<Pair<Integer,Integer>>((a,b) -> b.getKey() - a.getKey());
        q.add(new Pair(0, len));
        dp[len] = 0;
        
        for (int i = len - 1; i >= 0; i--) {
            while (!q.isEmpty() && (q.peek().getValue() - i > k || (q.peek().getValue() == len && i != len - 1)))
                q.poll();
            
            if (!q.isEmpty())
                dp[i] = Math.max(q.peek().getKey() + nums[i], dp[i]);
            else
                dp[i] = Math.max(nums[i], dp[i]);
            
            while (!q.isEmpty() && q.peek().getKey() < dp[i])
                q.poll();
            
            q.add(new Pair(dp[i], i));
        }
        
        return dp[0];
    }
}