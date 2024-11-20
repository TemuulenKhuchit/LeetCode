package Problems;

import java.util.*;

public class Medium695 {
    public int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
    public int m;
    public int n;
    public int max;

    public static void main(String[] args) {
        Medium695 medium695 = new Medium695();
        int[][] grid = {
                {0, 0, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0},
                {0, 1, 0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 1, 1, 0, 0, 0, 0}
        };
        medium695.maxAreaOfIsland(grid);
    }

    // Easy 695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        max = 0;

        for (int row = 0; row < m; row++)
            for (int col = 0; col < n; col++)
                if (grid[row][col] == 1) {
                    bfs(grid, row, col, 0); // BFS solution
                    dfs(grid, row, col, 0); // DFS with stack solution
                    dfsRec(grid, row, col, 0); // DFS with recursive solution
                }

        return max;
    }

    // BFS solution
    public void bfs(int[][] grid, int row, int col, int currSize) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        grid[row][col] = 0;

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                }
            }

            max = Math.max(max, ++currSize);
        }
    }

    // DFS with stack solution
    public void dfs(int[][] grid, int row, int col, int currSize) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        grid[row][col] = 0;

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            for (int[] dir : dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1) {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = 0;
                }
            }

            max = Math.max(max, ++currSize);
        }
    }

    // DFS with recursive solution
    public int dfsRec(int[][] grid, int row, int col, int currSize) {
        grid[row][col] = 0;

        max = Math.max(max, ++currSize);

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1)
                currSize = dfsRec(grid, newRow, newCol, currSize);
        }

        return currSize;
    }
}
