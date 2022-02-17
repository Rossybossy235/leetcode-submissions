class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        
        List<List<Integer>> result = new ArrayList<>();
        
        getCombos(candidates, 0, target, result, new ArrayList<Integer>());
        
        return result;
    }
    
    public void getCombos(int[] nums, int start, int target, List<List<Integer>> result,                    List<Integer> tempList)
    {
        if (target < 0)
            return;
        else if (target == 0)
        {
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        else
        {
            for (int i = start; i < nums.length; i++)
            {
                target -= nums[i];
                tempList.add(nums[i]);
                getCombos(nums, i, target, result, tempList);
                tempList.remove(tempList.size() - 1);
                target += nums[i];
            }
        }
    }
}