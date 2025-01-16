package LeetCode.DynamicProgramming;

public class Medium64 {

    public static void main(String[] args) {
        int[][] grid1 = new int[][]{{1, 3, 1}, {1, 5, 1}, {4, 2, 1}};
        int[][] grid2 = new int[][]{{1, 2, 3}, {4, 5, 6}};

        System.out.println(minPathSum(grid1));
        System.out.println(minPathSum(grid2));
    }

    // Medium 64. Minimum Path Sum
    // Approach 1: Dynamic Programming 2D
    public static int minPathSum2D(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        dp[0][0] = grid[0][0];

        for (int i = 1; i < m; i++)
            dp[i][0] = dp[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            dp[0][j] = dp[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + grid[i][j];

        return dp[m - 1][n - 1];
    }

    // Approach 2: Dynamic Programming 1D
    public static int minPathSum1D(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[] dp = new int[n];

        dp[0] = grid[0][0];

        for (int i = 1; i < n; i++)
            dp[i] = dp[i - 1] + grid[0][i];

        for (int i = 1; i < m; i++) {
            dp[0] = dp[0] + grid[i][0];
            for (int j = 1; j < n; j++)
                dp[j] = Math.min(dp[j], dp[j - 1]) + grid[i][j];
        }

        return dp[n - 1];
    }

    // Approach 3: Dynamic Programming Without Extra Space (But never change parameter value in real code)
    public static int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int i = 1; i < m; i++)
            grid[i][0] = grid[i - 1][0] + grid[i][0];

        for (int j = 1; j < n; j++)
            grid[0][j] = grid[0][j - 1] + grid[0][j];

        for (int i = 1; i < m; i++)
            for (int j = 1; j < n; j++)
                grid[i][j] = Math.min(grid[i][j - 1], grid[i - 1][j]) + grid[i][j];

        return grid[m - 1][n - 1];
    }
}
