package Weekly.Contest436;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Question1 {

    public static void main(String[] args) {
        int[][] grid = {
                {5, 3, 9},
                {1, 4, 7},
                {8, 6, 2}
        };
        System.out.println(Arrays.deepToString(sortMatrix(grid)));
    }

    public static int[][] sortMatrix(int[][] grid) {
        int n = grid.length;

        for (int diff = 1 - n; diff < n - 1; diff++) {
            int row = diff >= 0 ? diff : 0;
            int col = diff >= 0 ? 0 : -diff;

            List<Integer> diag = new ArrayList<>();
            int i = row;
            int j = col;
            while (i < n && j < n)
                diag.add(grid[i++][j++]);

            if (diff < 0)
                Collections.sort(diag);
            else
                Collections.sort(diag, Collections.reverseOrder());

            i = row;
            j = col;
            int ind = 0;
            while (i < n && j < n)
                grid[i++][j++] = diag.get(ind++);
        }

        return grid;
    }
}
