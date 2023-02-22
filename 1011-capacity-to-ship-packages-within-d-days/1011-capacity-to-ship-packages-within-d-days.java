class Solution {
    public int shipWithinDays(int[] weights, int days) {
        int sum =0;
        int max = Integer.MIN_VALUE;
        int n = weights.length;

        for(int i : weights){
            sum += i;
            max = Math.max(i, max);
        }
  
        // range : [max, sum]
        int lo = max;
        int hi = sum;
        int ans = sum;
        while(lo <= hi){
            int mid = (lo+hi)/2;  // say 32,
            int curr = 0;
            int c = 0;
            for(int i:weights){
                if(curr+i > mid){
                    c++;
                    curr=0;
                }
                curr +=i;
            }
            if(c+1 > days) {
                lo = mid+1;
            } else{
                hi = mid-1;
            }
        }
        return lo;
    }
}







