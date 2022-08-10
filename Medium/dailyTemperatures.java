/*
 * Daily Temperatures - Given an array of temperatures, return a resulting array such that for each
 * day, it shows the number of days needed until a warmer temperature appears.
 * 
 * We can use a monotonic stack, where we only store values that are strictly increasing. For each
 * temperature, we pop off temperatures that are less than the current one. For each pop, we update
 * the resulting array, since each pop means we have found a temperature that is warmer than the
 * previous.
 */

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> s = new Stack<>();
        int[] res = new int[temperatures.length];
        
        for (int i = 0; i < temperatures.length; i++) {
            while (!s.isEmpty() && temperatures[s.peek()] < temperatures[i]) {
                int val = s.pop();
                
                res[val] = i - val;
            }
            
            s.push(i);
        }
        
        return res;
    }
}