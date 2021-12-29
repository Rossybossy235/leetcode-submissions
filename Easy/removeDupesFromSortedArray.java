package Easy;

// NEEDS IMPROVEMENT
// Take this with a grain of salt, this solution could definitely be improved

class Solution {
    public int removeDuplicates(int[] nums) {
        
        int length = nums.length;
        int solutionSize = nums.length;
        int removed;
        
        for (int i = 0; i < length; i++)
        {
            for (int j = i + 1; j < solutionSize; j++)
            {
                if (nums[i] == nums[j])
                {
                    removed = nums[j];
                    
                    for (int k = j; k < length - 1; k++)
                    {
                        nums[k] = nums[k + 1];
                    }
                    
                    nums[length - 1] = removed;
                    solutionSize--;
                    j--;
                }
            }
        }
        
        return solutionSize;
    }
}
