package LeetCode.Uncategorized;

import java.util.*;

public class Medium1942 {

    public static void main(String[] args) {
        smallestChair(new int[][]{{1, 4}, {2, 3}, {4, 6}}, 1);
        smallestChair(new int[][]{{3, 10}, {1, 5}, {2, 6}}, 0);
    }

    public static int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;

        int[][] friends = new int[n][3];
        for (int i = 0; i < n; i++) {
            friends[i][0] = times[i][0]; // arrival time
            friends[i][1] = times[i][1]; // leaving time
            friends[i][2] = i;           // friend index
        }

        Arrays.sort(friends, Comparator.comparingInt(a -> a[0]));

        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);
        }

        PriorityQueue<int[]> occupiedChairs = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));

        for (int[] friend : friends) {
            int arrival = friend[0];
            int leaving = friend[1];
            int index = friend[2];

            while (!occupiedChairs.isEmpty() && occupiedChairs.peek()[0] <= arrival) {
                availableChairs.add(occupiedChairs.poll()[1]);
            }

            int assignedChair = availableChairs.poll();

            if (index == targetFriend) {
                return assignedChair;
            }

            occupiedChairs.add(new int[]{leaving, assignedChair});
        }

        return -1;
    }

}
