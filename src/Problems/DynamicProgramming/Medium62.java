package Problems.DynamicProgramming;

import java.lang.reflect.Array;
import java.util.Arrays;

public class Medium62 {

    public static void main(String[] args) {
        System.out.println(uniquePaths(3, 7));
    }

    // Medium 62. Unique Paths
    // Approach 1: Dynamic Programming 2D
    public static int uniquePaths2D(int m, int n) {
        int[][] dp = new int[m][n];

        for (int i = 0; i < m; i++)
            dp[i][0] = 1;

        for (int i = 0; i < n; i++)
            dp[0][i] = 1;

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];

        return dp[m - 1][n - 1];
    }

    // Approach 2: Dynamic Programming 1D
    public static int uniquePaths(int m, int n) {
        int[] dp = new int[n];
        dp[0] = 1;

        for (int i = 0; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[j] = dp[j - 1] + dp[j];

        return dp[n - 1];
    }
}
