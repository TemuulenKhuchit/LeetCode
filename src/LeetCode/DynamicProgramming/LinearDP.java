package LeetCode.DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class LinearDP {

    public static void main(String[] args) {
//        climbStairs(3);
//        fib(25);
//        tribonacci(25);
//        maxProfit(new int[]{7, 1, 5, 3, 6, 4});
//        MinCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20});
//        MinCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
//        minCostClimbingStairs3(new int[]{10, 15, 20});
//        minCostClimbingStairs3(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1});
//        DecodeWays.numDecodings("11106");
        NumTreesMemo.numTrees(6);
        NumTreesTabular(6);
//        divisorGame(3);
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

    // Easy 1025. Divisor Game
    public static boolean divisorGame(int n) {
        return n % 2 == 0;
    }

    // Easy 746. Min Cost Climbing Stairs
    // Approach 1: Bottom-Up Dynamic Programming (Tabulation)
    public static int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];

        for (int i = 2; i <= n; i++) {
            int step1 = dp[i - 1] + cost[i - 1];
            int step2 = dp[i - 2] + cost[i - 2];
            dp[i] += Math.min(step1, step2);
        }

        return dp[n];
    }

    // Approach 2: Top-Down Dynamic Programming (Recursion + Memoization)
    public static class MinCostClimbingStairs {
        static Map<Integer, Integer> memo = new HashMap<>();

        public static int minCostClimbingStairs(int[] cost) {
            System.out.println(recMinCostClimbingStairs(cost.length, cost));
            return recMinCostClimbingStairs(cost.length, cost);
        }

        public static int recMinCostClimbingStairs(int n, int[] cost) {
            if (n < 2) return 0;

            if (memo.containsKey(n)) return memo.get(n);

            int step1 = cost[n - 1] + recMinCostClimbingStairs(n - 1, cost);
            int step2 = cost[n - 2] + recMinCostClimbingStairs(n - 2, cost);
            memo.put(n, Math.min(step1, step2));

            return memo.get(n);
        }
    }

    // Approach 3: Bottom-Up, Constant Space
    public static int minCostClimbingStairs3(int[] cost) {
        int step1 = 0;
        int step2 = 0;

        for (int i = 2; i <= cost.length; i++) {
            int temp = step1;
            step1 = Math.min(step1 + cost[i - 1], step2 + cost[i - 2]);
            step2 = temp;
        }

        return step1;
    }

    // Medium 91. Decode Ways (Memoization)
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
    // Top-Down Memoization approach
    public static class NumTreesMemo {
        static Integer[] memo;

        public static int numTrees(int n) {
            memo = new Integer[n + 1];
            return recNumTrees(n);
        }

        public static int recNumTrees(int n) {
            if (n < 2) return 1;

            if (memo[n] != null) return memo[n];

            int total = 0;
            for (int i = 1; i <= n; i++) {
                int leftNode = i - 1;
                int leftTotal = recNumTrees(leftNode);

                int rightNode = n - i;
                int rightTotal = recNumTrees(rightNode);

                total += (leftTotal * rightTotal);
            }
            memo[n] = total;
            return total;
        }

    }

    // Bottom-Up Tabular approach
    public static int NumTreesTabular(int n) {
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            int total = 0;
            for (int j = 1; j <= i; j++) {
                int leftNode = j - 1;
                int leftTotal = dp[leftNode];

                int rightNode = i - j;
                int rightTotal = dp[rightNode];

                total += (leftTotal * rightTotal);
            }
            dp[i] = total;
        }

        return dp[n];
    }
}
