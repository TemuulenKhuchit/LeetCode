package HackerRank;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class QueensAttack {
    public static int[][] dirs = {
            {1, -1},    // Up + Left
            {1, 0},     // Up
            {1, 1},     // Up + Right
            {0, 1},     // Right
            {-1, 1},    // Down + Right
            {-1, 0},    // Down
            {-1, -1},   // Down + Left
            {0, -1},    // Left
    };

    public static void main(String[] args) {
        List<List<Integer>> obstacles = new ArrayList<>();
        obstacles.add(List.of(5, 5));
        obstacles.add(List.of(4, 2));
        obstacles.add(List.of(2, 3));
        System.out.println(queensAttack(5, 3, 4, 3, obstacles));
    }

    public static int queensAttack(int n, int k, int r_q, int c_q, List<List<Integer>> obstacles) {
        int count = 0;
        Set<String> obstacleSet = new HashSet<>();
        for (List<Integer> obstacle : obstacles)
            obstacleSet.add(obstacle.get(0) + " " + obstacle.get(1));

        for (int[] dir : dirs) {
            int newRow = r_q + dir[0];
            int newCol = c_q + dir[1];

            while (newRow >= 1 && newRow <= n && newCol >= 1 && newCol <= n) {
                if (obstacleSet.contains(newRow + " " + newCol))
                    break;
                count++;
                newRow += dir[0];
                newCol += dir[1];
            }
        }
        return count;
    }

}
