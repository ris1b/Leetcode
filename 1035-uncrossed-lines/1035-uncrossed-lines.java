class Solution {
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int dp[][] = new int [n][m];

        for(int[] num : dp)
            Arrays.fill(num,-1);

        return edit(nums1,n-1,nums2,m-1,dp);
    }
    public int edit(int nums1[], int i,int nums2[],int j,int dp[][]){
        if(i < 0 || j < 0){
            return 0;
        }
        
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(nums1[i] == nums2[j]){
            return 1 + edit(nums1,i-1,nums2,j-1,dp);
        }

        // exlude, include
        dp[i][j] = Math.max(edit(nums1,i-1,nums2,j,dp),edit(nums1,i,nums2,j-1,dp));

        return dp[i][j];
    }
}