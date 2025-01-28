package LeetCode.ArraysAndHashing;

public class Medium304 {

    public static void main(String[] args) {
        int[][] matrix = {{3, 0, 1, 4, 2}, {5, 6, 3, 2, 1}, {1, 2, 0, 1, 5}, {4, 1, 0, 1, 7}, {1, 0, 3, 0, 5}};
        Medium304 numMatrix = new Medium304(matrix);
        System.out.println(numMatrix.sumRegion(2, 1, 4, 3));
        System.out.println(numMatrix.sumRegion(1, 1, 2, 2));
        System.out.println(numMatrix.sumRegion(1, 2, 2, 4));
    }

    // Medium 304. Range Sum Query 2D - Immutable
    private int[][] ps;

    public Medium304(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        ps = new int[m + 1][n + 1];
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                ps[i + 1][j + 1] = ps[i + 1][j] + ps[i][j + 1] - ps[i][j] + matrix[i][j];
    }

    public int sumRegion(int row1, int col1, int row2, int col2) {
        return ps[row2 + 1][col2 + 1] + ps[row1][col1] - ps[row1][col2 + 1] - ps[row2 + 1][col1];
    }

}
