/*
 * Reduce Array Size to the Half - Given an array containing duplicate numbers, return the size of the
 * smallest set of numbers to remove such that at least half of the array is removed.
 * 
 * We iterate through the array, placing the frequencies of numbers into a hash map. We then place
 * the numbers into an array and sort. Then, we take the numbers with the highest frequencies until
 * half of the array is removed.
 */

class Solution {
    public int minSetSize(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        
        for (int n : arr) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        
        int[] counts = new int[map.values().size()];
        int i = 0;
        
        for (int c : map.values()) {
            counts[i++] = c;
        }
        
        Arrays.sort(counts);
        int res = 0;
        int removed = 0;
        int half = arr.length / 2;
        i = counts.length - 1;
        
        while (removed < half) {
            res++;
            removed += counts[i--];
        }
        
        return res;
    }
}