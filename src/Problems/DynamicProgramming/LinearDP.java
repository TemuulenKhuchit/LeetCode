package Problems.DynamicProgramming;

import java.util.Arrays;

public class LinearDP {

    public static void main(String[] args) {
        LinearDP ldp = new LinearDP();

//        ldp.climbStairs(3);
//        ldp.fib(25);
//        ldp.tribonacci(25);
        ldp.maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        ldp.minCostClimbingStairs(new int[]{10, 15, 20});
    }

    // Easy 70. Climbing Stairs
    public int climbStairs(int n) {
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Easy 509. Fibonacci Number
    public int fib(int n) {
        if (n == 0) return 0;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Easy 1137. N-th Tribonacci Number
    public int tribonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;

        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
        }

        return dp[n];
    }

    // Easy 121. Best Time to Buy and Sell Stock
    public int maxProfit(int[] prices) {
        int n = prices.length;
        if (n == 1) return 0;

        int[] dp = new int[n + 1];

        for (int i = 0; i < n; i++)
            for (int j = i + 1; j <= n; j++)
                dp[j] = Math.max(prices[j - 1] - prices[i], Math.max(dp[j], dp[j - 1]));

        return dp[n];
    }

    // Easy 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {


        return 0;
    }

}
