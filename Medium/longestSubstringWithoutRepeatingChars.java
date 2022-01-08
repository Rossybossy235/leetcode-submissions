class Solution {
    public int lengthOfLongestSubstring(String s) {
        
        Queue<Character> q = new LinkedList<>();
        int result = 0;
        
        for (char c : s.toCharArray())
        {
            while (q.contains(c))
            {
                q.poll();
            }
            q.offer(c);
            
            result = Math.max(result, q.size());
        }
        return result;
    }
}