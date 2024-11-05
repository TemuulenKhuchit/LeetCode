package Problems.DynamicProgramming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class LinearDP {

    public static void main(String[] args) {
//        climbStairs(3);
//        fib(25);
//        tribonacci(25);
//        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        minCostClimbingStairs(new int[]{10, 15, 20});
//        DecodeWays.numDecodings("11106");
        NumTrees.numTrees(6);
    }

    // Easy 70. Climbing Stairs
    public static int climbStairs(int n) {
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
    public static int fib(int n) {
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
    public static int tribonacci(int n) {
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
    public static int maxProfit(int[] prices) {
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
    public static int minCostClimbingStairs(int[] cost) {


        return 0;
    }

    // Medium 91. Decode Ways
    public static class DecodeWays {
        static Map<Integer, Integer> memo = new HashMap<>();

        public static int numDecodings(String s) {
            return recursiveWithMemo(0, s);
        }

        private static int recursiveWithMemo(int index, String str) {
            // Have we already seen this substring?
            if (memo.containsKey(index)) return memo.get(index);

            // If you reach the end of the string
            // Return 1 for success.
            if (index == str.length()) return 1;

            // If the string starts with a zero, it can't be decoded
            if (str.charAt(index) == '0') return 0;

            if (index == str.length() - 1) return 1;

            int ans = recursiveWithMemo(index + 1, str);
            if (Integer.parseInt(str.substring(index, index + 2)) <= 26)
                ans += recursiveWithMemo(index + 2, str);

            // Save for memoization
            memo.put(index, ans);

            return ans;
        }
    }

    // Medium 96. Unique Binary Search Trees
    public static class NumTrees {
        static Integer[] memo;

        public static int numTrees(int n) {
            memo = new Integer[n + 1];
            return recursiveNumTrees(n);
        }

        public static int recursiveNumTrees(int n) {
            if (n < 2) return 1;

            if (memo[n] != null) return memo[n];

            int total = 0;
            for (int i = 1; i <= n; i++)
                total += (recursiveNumTrees(i - 1) * recursiveNumTrees(n - i));

            memo[n] = total;
            return total;
        }

    }

}
