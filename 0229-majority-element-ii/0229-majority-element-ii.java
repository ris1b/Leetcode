class Solution {
    public List<Integer> majorityElement(int[] nums) {
        /* Moore's Voting Algo 
         When majority element is greater than n/2 --> Single majority element can exist
         And when majority is greater than n/3 --> Two majority elements can exist 
        */
        int n = nums.length;
        List<Integer> ans = new ArrayList<>();
        int count1 = 0;
        int count2 = 0;
    
        int first =  Integer.MIN_VALUE;;
        int second = Integer.MAX_VALUE;
     
        for (int i = 0; i < n; i++) {
            if (first == nums[i])
                count1++;

            else if (second == nums[i])
                count2++;
         
            else if (count1 == 0) {
                count1++;
                first = nums[i];
            }
     
            else if (count2 == 0) {
                count2++;
                second = nums[i];
            }

            else {
                count1--;
                count2--;
            }
        }
     
        count1 = 0;
        count2 = 0;
     
        for (int i = 0; i < n; i++) {
            if (nums[i] == first)
                count1++;
     
            else if (nums[i] == second)
                count2++;
        }
     
        if (count1 > n / 3)
            ans.add(first);
     
        if (count2 > n / 3)
            ans.add(second);
        
        return ans;
    }
}