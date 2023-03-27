class Solution {
    int dp[][];
    public int minPathSum(int[][] A) {
        dp = new int[A.length][A[0].length];
        dp[0][0] = A[0][0];
        for(int i=1; i<A[0].length; i++){
            dp[0][i] = A[0][i] + dp[0][i-1];
        }
        for(int i=1; i<A.length; i++){
            // System.out.println("OOB " + i1);
            dp[i][0] =  A[i][0] + dp[i-1][0];
            //A[i1][0] + A[i1-1][0]
            // System.out.println("OOB after" + i1);
        }

        for(int i=1; i<A.length; i++){
            for(int j=1; j<A[0].length; j++){
                dp[i][j] = A[i][j] + Math.min(dp[i-1][j], dp[i][j-1]);
            }
        }

        return dp[A.length-1][ A[0].length-1 ];
    }
}