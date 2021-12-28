package Easy;
class Solution {
    public int[] twoSum(int[] nums, int target) {
        
        int[] solution = new int[2];
        
        int numLength = nums.length;
        
        for (int i = 0; i < numLength; i++)
        {
            solution[0] = i;
            
            for (int j = i + 1; j < numLength; j++)
            {
                if (nums[i] + nums[j] == target)
                {
                    solution[1] = j;
                    return solution;
                }
            }
        }
        
        return null;
    }
}