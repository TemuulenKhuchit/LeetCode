package Problems.Graph;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Stack;

public class Medium2101 {

    public static void main(String[] args) {
        int[][] bombs1 = {{2, 1, 3}, {6, 1, 4}};
        int[][] bombs2 = {{1, 1, 5}, {10, 10, 5}};
        int[][] bombs3 = {{1, 2, 3}, {2, 3, 1}, {3, 4, 2}, {4, 5, 3}, {5, 6, 4}};

        System.out.println(maximumDetonation(bombs1));
        System.out.println(maximumDetonation(bombs2));
        System.out.println(maximumDetonation(bombs3));
    }

    // Medium 2101. Detonate the Maximum Bombs
    public static int maximumDetonation(int[][] bombs) {
        int count = 0;

        for (int i = 0; i < bombs.length; i++)
//            count = Math.max(count, bfs(bombs, i)); // BFS solution
            count = Math.max(count, dfs(bombs, i)); // DFS with stack solution

        return count;
    }

    // BFS solution
    public static int bfs(int[][] bombs, int bombInd) {
        int count = 0;
        int[] counted = new int[bombs.length];

        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(bombInd);

        while (!queue.isEmpty()) {
            int currBombInd = queue.poll();

            count++;
            counted[currBombInd] = 1;

            int x1 = bombs[currBombInd][0];
            int y1 = bombs[currBombInd][1];
            int r1 = bombs[currBombInd][2];

            for (int i = 0; i < bombs.length; i++) {
                if (currBombInd == i)
                    continue;

                int x2 = bombs[i][0];
                int y2 = bombs[i][1];

                double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

                if (dist <= r1 && counted[i] == 0 && !queue.contains(i))
                    queue.offer(i);
            }
        }

        return count;
    }

    // DFS with stack solution
    public static int dfs(int[][] bombs, int bombInd) {
        int count = 0;
        int[] counted = new int[bombs.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(bombInd);

        while (!stack.isEmpty()) {
            int currBombInd = stack.pop();

            count++;
            counted[currBombInd] = 1;

            int x1 = bombs[currBombInd][0];
            int y1 = bombs[currBombInd][1];
            int r1 = bombs[currBombInd][2];

            for (int i = 0; i < bombs.length; i++) {
                if (currBombInd == i)
                    continue;

                int x2 = bombs[i][0];
                int y2 = bombs[i][1];

                double dist = Math.sqrt(Math.pow((x2 - x1), 2) + Math.pow((y2 - y1), 2));

                if (dist <= r1 && counted[i] == 0 && !stack.contains(i))
                    stack.push(i);
            }
        }

        return count;
    }
}
