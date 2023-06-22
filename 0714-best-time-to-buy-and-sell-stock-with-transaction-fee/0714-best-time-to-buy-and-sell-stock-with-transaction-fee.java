class Solution {
    int[][] dp;
    public int maxProfit(int[] prices, int fee) {
        dp = new int[prices.length][2];
        for(int i = 0; i < prices.length; i++)
            Arrays.fill(dp[i], -1);

        return pay(prices, fee,0, 0);
    }

    public int pay(int[] prices, int fee, int holding, int day) {
        if (day == prices.length) return 0;

        if (dp[day][holding]!=-1) return dp[day][holding];
        
        // skip
        int ans = pay(prices, fee, holding, day+1);
        
        if (holding == 0) {
            // bought stock
            ans = Math.max(ans, pay(prices, fee, 1, day+1) - prices[day]);
        } else {      
            // sold stock    
            ans = Math.max(ans, pay(prices, fee, 0, day+1) + prices[day] - fee);
        }
        dp[day][holding] = ans;
        return ans;
    }
}