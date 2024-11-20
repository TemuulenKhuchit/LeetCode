package Problems;

import java.util.*;

public class Medium200 {
    private int rowSize;
    private int colSize;
    public int[][] dirs = {
            {0, 1},     // Down
            {0, -1},    // Up
            {-1, 0},    // Left
            {1, 0}      // Right
    };

    public static void main(String[] args) {
        char[][] grid = new char[][]{
                {'1', '1', '0', '0', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '1', '0', '0'},
                {'0', '0', '0', '1', '1'}
        };
        Medium200 medium200 = new Medium200();
        medium200.numIslands(grid);
    }

    // Medium 200. Number of Islands
    public int numIslands(char[][] grid) {
        rowSize = grid.length;
        colSize = grid[0].length;
        int islandsQty = 0;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (grid[row][col] == '1') {
                    islandsQty++;
                    bfs(grid, row, col); // BFS solution
                    dfs(grid, row, col); // DFS with stack solution
                    dfsRec(grid, row, col); // DFS with recursive solution
                }
            }
        }

        System.out.println(islandsQty);
        return islandsQty;
    }

    // BFS solution
    public void bfs(char[][] grid, int row, int col) {
        Queue<int[]> queue = new ArrayDeque<>();
        queue.offer(new int[]{row, col});

        grid[row][col] = '0';

        while (!queue.isEmpty()) {
            int[] curr = queue.poll();

            for (int[] dir : dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && grid[newRow][newCol] == '1') {
                    queue.offer(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }

    // DFS with stack solution
    public void dfs(char[][] grid, int row, int col) {
        Stack<int[]> stack = new Stack<>();
        stack.push(new int[]{row, col});

        grid[row][col] = '0';

        while (!stack.isEmpty()) {
            int[] curr = stack.pop();

            for (int[] dir : dirs) {
                int newRow = curr[0] + dir[0];
                int newCol = curr[1] + dir[1];

                if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && grid[newRow][newCol] == '1') {
                    stack.push(new int[]{newRow, newCol});
                    grid[newRow][newCol] = '0';
                }
            }
        }
    }

    // DFS with recursive solution
    public void dfsRec(char[][] grid, int row, int col) {
        grid[row][col] = '0';

        for (int[] dir : dirs) {
            int newRow = row + dir[0];
            int newCol = col + dir[1];

            if (newRow >= 0 && newRow < rowSize && newCol >= 0 && newCol < colSize && grid[newRow][newCol] == '1')
                dfsRec(grid, newRow, newCol);
        }
    }
}
