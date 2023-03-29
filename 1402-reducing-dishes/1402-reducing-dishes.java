class Solution {
    public int maxSatisfaction(int[] satisfaction) {
        Arrays.sort(satisfaction);
        int n = satisfaction.length;
        int ans = 0;
        int prod = 0;
        for(int i=0; i<n; i++){
            if(prod + satisfaction[n-i-1]< 0) break;
            prod += satisfaction[n-i-1];

            ans += prod;
        }

        return ans;
    }
}

// [-1, -8, 0, 5, -9]
// [-9, -8, -1, 0, 5]
