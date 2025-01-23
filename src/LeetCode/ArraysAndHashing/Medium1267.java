package LeetCode.ArraysAndHashing;

public class Medium1267 {

    public static void main(String[] args) {
        int[][] grid = new int[][]{{1, 1, 0, 0}, {0, 0, 1, 0}, {0, 0, 1, 0}, {0, 0, 0, 1}};
        System.out.println(countServers(grid));
    }

    // Medium 1267. Count Servers that Communicate
    public static int countServers(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int[] rowCount = new int[n];
        int[] colCount = new int[m];

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1) {
                    rowCount[j]++;
                    colCount[i]++;
                }

        int result = 0;
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (grid[i][j] == 1)
                    if (rowCount[j] > 1 || colCount[i] > 1)
                        result++;

        return result;
    }

}
