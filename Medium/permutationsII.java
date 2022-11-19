/*
 * Permutations II - Given an array of numbers that can contain duplicates, return all unique
 * permutations.
 * 
 * We use a backtracking solution. We first get a count of all the numbers in the list, and place
 * them into a hash map. Since the list can contain duplicate numbers, we need to keep the counts
 * in order to know when the maximum amount of a certain number has been placed into the current
 * permutation. We place current permutations into a linked list. When they reach the size of 
 * the given array, we place it into a results list if it is not already in the list.
 */

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        LinkedList<Integer> current = new LinkedList<>();

        HashMap<Integer, Integer> counts = new HashMap<>();

        for (int n : nums) {
            if (!counts.containsKey(n))
                counts.put(n, 0);
            counts.put(n, counts.get(n) + 1);
        }

        findPermutations(res, current, nums.length, counts);

        return res;
    }

    public void findPermutations(List<List<Integer>> res, LinkedList<Integer> current, int size, HashMap<Integer, Integer> c) {
        if (current.size() == size) {
            res.add(new ArrayList<Integer>(current));

            return;
        }

        for (Map.Entry<Integer, Integer> e : c.entrySet()) {
            Integer num = e.getKey();
            Integer count = e.getValue();
            if (count == 0)
                continue;

            current.addLast(num);
            c.put(num, count - 1);

            findPermutations(res, current, size, c);

            current.removeLast();
            c.put(num, count);
        }
    }
}