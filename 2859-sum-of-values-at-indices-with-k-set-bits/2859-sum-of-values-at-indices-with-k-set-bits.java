class Solution {
    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int sum = 0;
        for(int i=0; i<nums.size(); i++) {
            
            if(k == count(i))
                sum += nums.get(i);
        }
        
        return sum;
    }
    
    private int count(int n) {
        int c = 0;
        
        while(n > 0) {
            n = n & (n-1);
            c++;
        }
        
        return c;
    }
}