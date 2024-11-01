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
        if (prices.length == 1)
            return 0;

        int[] dp = new int[prices.length];
        int min = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }

        return dp[prices.length - 1];
    }

    // Easy 746. Min Cost Climbing Stairs
    public int minCostClimbingStairs(int[] cost) {


        return 0;
    }

}
