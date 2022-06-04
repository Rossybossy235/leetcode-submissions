class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        
        Map<Character, Boolean> map = new HashMap<Character, Boolean>();
        
        int numJewel = 0;
        
        for (int i = 0; i < jewels.length(); i++) {
            map.put(jewels.charAt(i), true);
        }
        
        for (int i = 0; i < stones.length(); i++) {
            if (map.containsKey(stones.charAt(i))) {
                numJewel++;
            }
        }
        
        return numJewel;
    }
}