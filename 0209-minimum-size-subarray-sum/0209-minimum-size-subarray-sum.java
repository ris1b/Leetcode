class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int k = 0;
        int n = nums.length;
        int len = n+1;
        // boolean found = false;

        int sum = 0;
        for(int i=0; i<n; i++){
            int x = nums[i];
            if(x >= target) return 1;

            sum += x;
            while(k<i && sum >= target){
                // if(!found)
                //     found = true;
                len = Math.min(len, i-k+1);
                sum -= nums[k];
                k++;
            }
        }

        return len == n+1 ? 0 : len;
    }
}
