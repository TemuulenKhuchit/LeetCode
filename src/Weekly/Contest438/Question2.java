package Weekly.Contest438;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Question2 {

    public static void main(String[] args) {
        System.out.println(maxSum(new int[][]{{1, 2}, {3, 4}}, new int[]{1, 2}, 2));
        System.out.println(maxSum(new int[][]{{5, 3, 7}, {8, 2, 6}}, new int[]{2, 2}, 3));
    }

    public static long maxSum(int[][] grid, int[] limits, int k) {
        int n = grid.length;
        int m = grid[0].length;

        List<Integer> candidates = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            Arrays.sort(grid[i]);
            int takeCount = Math.min(limits[i], m);

            for (int j = 0; j < takeCount; j++) {
                int indexFromEnd = m - 1 - j;
                candidates.add(grid[i][indexFromEnd]);
            }
        }

        candidates.sort((a, b) -> Integer.compare(b, a));

        int pickCount = Math.min(k, candidates.size());
        long answer = 0;
        for (int i = 0; i < pickCount; i++)
            answer += candidates.get(i);

        return answer;
    }
}
