class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[2][prices.length];

        Arrays.fill(dp[0], -1);
        Arrays.fill(dp[1], -1);

        return pay(prices, fee,0, 0);
    }

    public int pay(int[] prices, int fee, int holding, int day) {
        if (day == prices.length) return 0;

        if (dp[holding][day]!=-1) return dp[holding][day];
        
        // skip
        int ans = pay(prices, fee, holding, day+1);
        
        if (holding == 0) {
            // bought stock
            ans = Math.max(ans, pay(prices, fee, 1, day+1) - prices[day]);
        } else {      
            // sold stock    
            ans = Math.max(ans, pay(prices, fee, 0, day+1) + prices[day] - fee);
        }
        dp[holding][day] = ans;
        
        return ans;
    }
}