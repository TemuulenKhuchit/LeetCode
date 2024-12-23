package Problems.ArraysAndHashing;

import java.util.Arrays;

public class Medium73 {

    public static void main(String[] args) {
        int[][] matrix1 = {
                {1, 1, 1},
                {1, 0, 1},
                {1, 1, 1}
        };
        int[][] matrix2 = {
                {0, 1, 2, 0},
                {3, 4, 5, 2},
                {1, 3, 1, 5}
        };
//        setZeroes(matrix1);
        setZeroes(matrix2);
    }

    // Medium 73. Set Matrix Zeroes
    public static void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == 0) {
                    for (int k = 0; k < m; k++)
                        if (matrix[k][j] != 0)
                            matrix[k][j] = -11145615;
                    for (int l = 0; l < n; l++)
                        if (matrix[i][l] != 0)
                            matrix[i][l] = -11145615;
                }

        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                if (matrix[i][j] == -11145615)
                    matrix[i][j] = 0;
    }
}
