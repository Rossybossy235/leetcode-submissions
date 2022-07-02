/*
 * Combinations - Given two integers n and k, return all possible combinations of k numbers in the
 * range 1->n. Repeated combinations are not allowed (i.e. 1,4 and 4,1, or 1,1).
 * 
 * We use backtracking. We iterate over all possible numbers, using a start variable so that we don't
 * repeat numbers. After each iteration, we add the current combination to our result list.
 */

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> combos = new ArrayList<List<Integer>>();
        List<Integer> curr = new ArrayList<Integer>();
        
        combo(combos, curr, 1, n, k);
        return combos;
    }
    
    public void combo(List<List<Integer>> combos, List<Integer> curr, int start, int n, int k) {
        if (k == 0) {
            combos.add(new ArrayList<Integer>(curr));
            return;
        }
        
        for (int i = start; i <= n; i++) {
            curr.add(i);
            combo(combos, curr, i + 1, n, k - 1);
            curr.remove(curr.size() - 1);
        }
    }
}