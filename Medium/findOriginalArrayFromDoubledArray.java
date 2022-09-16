/*
 * Find Original Array From Doubled Array - An integer array becomes the changed array by appending
 * the twice the value of all elements to the original list, then shuffling the resulting array. Find
 * and return the original array.
 * 
 * First, we check if the changed array is an odd length, since an array of odd length is not a properly
 * doubled array. Then, we sort the array, and place the values, along with the frequencies, or counts,
 * of each value into a hash map. Then, if any zeroes are in the hash map, we check if there is an
 * even number of them, then place half of those zeroes into our resulting list (since 0*2 is 0). Then,
 * for each number in the sorted changed array, we check if the double of that number exists in the hash
 * map. If it does, we check if that number has already been used, i.e. the count in the hash map is 0.
 * If it hasn't been used, then we lower the count of the current number and the double of the current
 * number, and add the current number to the results list. We do this until our pointer p2 is equal
 * to the size of our results list. If at any point the hash map does not contain the double of the
 * current number, we return an empty list.
 */

class Solution {
    public int[] findOriginalArray(int[] changed) {
        
        if (changed.length % 2 != 0)
            return new int[]{};
        
        int[] res = new int[changed.length / 2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        
        Arrays.sort(changed);
        
        for (int i = 0; i < changed.length; i++) {
            map.put(changed[i], map.getOrDefault(changed[i], 0) + 1);
        }
        
        int p1 = 0;
        int p2 = 0;
        
        if (map.containsKey(0) && map.get(0) % 2 != 0)
            return new int[]{};
        else if (map.containsKey(0)) {
            for (int i = 0; i < map.get(0) / 2; i++) {
                res[p2] = 0;
                p2++;
            }
            
            p1 += map.get(0);
            map.remove(0);
        }
        
        while(p2 < changed.length / 2) {
            if (map.containsKey(changed[p1] * 2) && map.get(changed[p1] * 2) > 0 && map.get(changed[p1]) > 0) {
                res[p2] = changed[p1];
                
                map.put(changed[p1] * 2, map.get(changed[p1] * 2) - 1);
                map.put(changed[p1], map.get(changed[p1]) - 1);
                
                p1++;
                p2++;
            }
            else if (map.get(changed[p1]) > 0) {
                return new int[]{};
            }
            else
                p1++;
        }
        
        if (p2 < changed.length / 2)
            return new int[]{};
        else
            return res;
    }
}