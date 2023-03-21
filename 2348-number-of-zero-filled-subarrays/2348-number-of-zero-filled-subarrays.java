class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long ans = 0;
        long subArr = 0;
        for(int i=0; i<nums.length; i++){
            int x = nums[i];
            if(x == 0){
                subArr++;
            } else{
                subArr = 0;
            }
            ans += subArr;
        }
        return ans;
    }
}