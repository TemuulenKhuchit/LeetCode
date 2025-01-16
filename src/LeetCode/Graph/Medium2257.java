package LeetCode.Graph;

public class Medium2257 {
    public static void main(String[] args) {
        Medium2257 medium2257 = new Medium2257();
        int[][] guards = {{0,0}, {1,1}, {2,3}};
        int[][] walls = {{0,1}, {2,2}, {1,4}};
        medium2257.countUnguarded(4, 6, guards, walls);
    }

    // Medium 2257. Count Unguarded Cells in the Grid
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        int[][] grid = new int[m][n];

        for (int[] guard : guards) {
            grid[guard[0]][guard[1]] = 2;
        }

        for (int[] wall : walls) {
            grid[wall[0]][wall[1]] = 3;
        }

        for (int[] guard : guards) {
            dfs(guard[0] - 1, guard[1], grid, 'U'); // Up
            dfs(guard[0] + 1, guard[1], grid, 'D'); // Down
            dfs(guard[0], guard[1] - 1, grid, 'L'); // Left
            dfs(guard[0], guard[1] + 1, grid, 'R'); // Right
        }

        int count = 0;
        for (int[] row : grid) {
            for (int cell : row) {
                if (cell == 0) count++;
            }
        }

        return count;
    }

    public void dfs(int row, int col, int[][] grid, char direction) {
        if (row < 0 || row >= grid.length || col < 0 || col >= grid[0].length
                || grid[row][col] == 2 || grid[row][col] == 3) {
            return;
        }
        grid[row][col] = 1; // Mark cell as guarded
        if (direction == 'U') dfs(row - 1, col, grid, 'U'); // Up
        if (direction == 'D') dfs(row + 1, col, grid, 'D'); // Down
        if (direction == 'L') dfs(row, col - 1, grid, 'L'); // Left
        if (direction == 'R') dfs(row, col + 1, grid, 'R'); // Right
    }
}
