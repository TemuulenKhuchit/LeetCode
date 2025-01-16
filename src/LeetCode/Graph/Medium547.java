package LeetCode.Graph;

import java.util.Arrays;

public class Medium547 {
    static int[][] grid;
    static int[] visited;

    public static void main(String[] args) {
        int[][] grid1 = {
                {1, 1, 0},
                {1, 1, 0},
                {0, 0, 1}
        };
        int[][] grid2 = {
                {1, 0, 0},
                {0, 1, 0},
                {0, 0, 1}
        };
        int[][] grid3 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1},
        };
        System.out.println(findCircleNum(grid1));
        System.out.println(findCircleNum(grid2));
        System.out.println(findCircleNum(grid3));
    }

    // Medium 547. Number of Provinces
    public static int findCircleNum(int[][] isConnected) {
        grid = isConnected;
        int n = grid.length;
        visited = new int[n];
        int provinces = 0;

        for (int i = 0; i < n; i++) {
            if (visited[i] == 0) {
                provinces++;
                dfs(i, 0);
            }
        }
        System.out.println(Arrays.deepToString(isConnected));
        return provinces;
    }

    public static void dfs(int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[0].length)
            return;

        visited[i] = 1;

        dfs(i, j + 1);
        if (visited[j] == 0 && grid[i][j] == 1) {}
            dfs(j, i);
    }
}
