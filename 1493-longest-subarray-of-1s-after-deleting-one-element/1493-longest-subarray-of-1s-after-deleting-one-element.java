class Solution {
    public int longestSubarray(int[] nums) {
        boolean zero = false;
        int c = 0;

        for(int i = 0; i<nums.length; i++){
            int x = nums[i];
            int left = 0;
            int right = 0;
            if (x == 0){
                zero = true;
                int j = i-1;
                int k = i+1;

                while(j>=0 && nums[j] == 1) {
                    j--;
                    left++;
                }
                while(k<nums.length && nums[k] == 1) {
                    k++;
                    right++;
                }
                c = Math.max(c , left + right);
            }
        }
        return zero ? c : nums.length-1;
    }
}