class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        if(!(target%2)){
            for(int index = 0; index < nums.size()-1; index++){
                for(int i = index+1; i < nums.size(); i++){
                    if(!(nums[index]%2)){
                        if(!(nums[i]%2)){
                            if(nums[index]+nums[i] == target){
                                return {index, i};
                            }
                        }
                    } else {
                        if(nums[i]%2){
                            if(nums[index]+nums[i] == target){
                                return {index, i};
                            }
                        }
                    }
                }
            }
        } else {
            for(int index = 0; index < nums.size()-1; index++){
                for(int i = index+1; i < nums.size(); i++){
                    if(!(nums[index]%2)){
                        if(nums[i]%2){
                            if(nums[index]+nums[i] == target){
                                return {index, i};
                            }
                        }
                    } else {
                        if(!(nums[i]%2)){
                            if(nums[index]+nums[i] == target){
                                return {index, i};
                            }
                        }
                    }
                }
            }
        }
        return {0, 0};
    }
};