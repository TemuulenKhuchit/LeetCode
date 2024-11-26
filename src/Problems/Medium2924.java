package Problems;

import java.util.HashMap;
import java.util.Map;

public class Medium2924 {

    public static void main(String[] args) {
        Medium2924 obj = new Medium2924();
        int[][] edges = {{0, 1}, {1, 2}};
        System.out.println(obj.findChampion(3, edges));
    }

    // Medium 2924. Find Champion II
    public int findChampion(int n, int[][] edges) {
        int[] all = new int[n];
        int result = -1;
        int count = 0;

        for (int[] edge : edges)
            all[edge[1]]++;

        for (int i = 0; i < n; i++) {
            if (all[i] == 0) {
                result = i;
                count++;
            }
        }

        return count > 1 ? -1 : result;
    }
}
