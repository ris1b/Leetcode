class Solution {
    int dp[][];
    public int longestCommonSubsequence(String text1, String text2) {
        int n = text1.length();
        int m = text2.length();

        dp = new int[n+1][m+1];
        for(int arr[] : dp){
            Arrays.fill(arr, -1);
        }
        return lcs(n-1, m-1, text1, text2);
    }

    public int lcs(int i, int j, String s, String p){
        if(i < 0 || j < 0){
            return 0;
        }

        if(dp[i][j] != -1){
            return dp[i][j];
        }

        char s1 = s.charAt(i);
        char s2 = p.charAt(j);

        if(s1 == s2){
            dp[i][j] = 1 + lcs(i-1, j-1, s, p);
        }
        if(s1 != s2){
            dp[i][j] = Math.max(lcs(i-1, j, s, p) , lcs(i, j-1, s, p));
        }

        return dp[i][j];
    }
}
