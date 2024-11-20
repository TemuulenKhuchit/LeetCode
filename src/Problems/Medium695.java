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
//                    bfs(grid, row, col); // BFS solution
//                    dfs(grid, row, col); // DFS with stack solution
//                    max = Math.max(max, dfsRec(grid, row, col)); // DFS with recursive solution
                    max = Math.max(max, dfsRec2(grid, row, col)); // DFS with recursive fastest solution
                }

        System.out.println(max);
        return max;
    }

    // BFS solution
    public void bfs(int[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        int area = 0;
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

            max = Math.max(max, ++area);
        }
    }

    // DFS with stack solution
    public void dfs(int[][] grid, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        int area = 0;
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

            max = Math.max(max, ++area);
        }
    }

    // DFS with recursive solution
    public int dfsRec(int[][] grid, int row, int col) {
        int area = 1;
        grid[row][col] = 0;

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n && grid[newRow][newCol] == 1)
                area += dfsRec(grid, newRow, newCol);
        }

        return area;
    }

    // DFS with recursive fastest solution
    public int dfsRec2(int[][] grid, int row, int col) {
        if (row < 0 || row >= m || col < 0 || col >= n || grid[row][col] == 0)
            return 0;

        grid[row][col] = 0;

        int area = 1;
        area += dfsRec2(grid, row + 1, col);
        area += dfsRec2(grid, row - 1, col);
        area += dfsRec2(grid, row, col + 1);
        area += dfsRec2(grid, row, col - 1);

        return area;
    }
}
