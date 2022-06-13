/*
 * Triangle - Given a triangle array, return the minimum sum from top to bottom.
 * 
 * Used Bottom-Up dynamic programming to explore the possible paths from bottom to top,
 * saving the minimum values in a newly created list of the same size as the triangle's 
 * bottom row. At the end, the minimum sum will be saved in the first space of the new
 * list.
 */

class Solution {
    public int minimumTotal(List<List<Integer>> triangle) {
        List<Integer> res = triangle.get(triangle.size() - 1);
        
        for (int i = triangle.size() - 2; i >= 0; i--) {
            for (int j = 0; j < triangle.get(i).size(); j++) {
                res.set(j, Math.min(res.get(j), res.get(j + 1)) + triangle.get(i).get(j));
            }
        }
        
        return res.get(0);
    }
}