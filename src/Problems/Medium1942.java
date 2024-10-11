package Problems;

import java.util.*;

public class Medium1942 {

    public static void main(String[] args) {
        smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1);
        smallestChair(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0);
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int result = 0;
        int[] target = times[targetFriend];

        Arrays.sort(times, Comparator.comparing(n -> n[0]));

        Queue<Integer> pq = new PriorityQueue<>();

        for (int i = 0; i <= target[0]; i++) {
//            if (times[])
        }

        System.out.println(Arrays.deepToString(times));

        return result;
    }

}
