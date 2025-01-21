package LeetCode.ArraysAndHashing;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Medium2661 {

    public static void main(String[] args) {
        Medium2661 test = new Medium2661();
        int[] arr1 = new int[]{1, 3, 4, 2};
        int[][] mat1 = {{1, 4}, {2, 3}};
        System.out.println(test.firstCompleteIndex(arr1, mat1));

        int[] arr2 = new int[]{2, 8, 7, 4, 1, 3, 5, 6, 9};
        int[][] mat2 = {{3, 2, 5}, {1, 4, 6}, {8, 7, 9}};
        System.out.println(test.firstCompleteIndex(arr2, mat2));

        int[] arr3 = new int[]{1, 4, 5, 2, 6, 3};
        int[][] mat3 = {{4, 3, 5}, {1, 2, 6}};
        System.out.println(test.firstCompleteIndex(arr3, mat3));
    }

    // Medium 2661. First Completely Painted Row or Column
    public int firstCompleteIndex(int[] arr, int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;

        int[] rowCount = new int[m];
        int[] colCount = new int[n];

        Map<Integer, int[]> locationsMap = new HashMap<>();
        for (int i = 0; i < m; i++)
            for (int j = 0; j < n; j++)
                locationsMap.put(mat[i][j], new int[]{i, j});

        for (int i = 0; i < m * n; i++) {
            int[] location = locationsMap.get(arr[i]);
            int row = location[0];
            int col = location[1];
            rowCount[row]++;
            colCount[col]++;
            if (rowCount[row] == n || colCount[col] == m)
                return i;
        }

        return 0;
    }

}
