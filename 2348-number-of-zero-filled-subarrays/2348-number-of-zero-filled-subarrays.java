class Solution {
    public long zeroFilledSubarray(int[] nums) {
        
        long sum = 0;
        for(int i=0; i<nums.length; i++){
            int c = 1;
            while(i<nums.length && nums[i] == 0){
                c++;
                i++;
            }
            sum += ((long)c*(c-1)/2);
            // System.out.println(c + " sub arr");
        }
        return sum;
    }
}