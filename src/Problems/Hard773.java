package Problems;

import java.util.LinkedList;
import java.util.Queue;

public class Hard773 {

    public static void main(String[] args) {
        Hard773 obj = new Hard773();

        int[][] board = {{1, 2, 3}, {4, 0, 5}};
        obj.slidingPuzzle(board);
    }

    // Hard 773. Sliding Puzzle
    public int slidingPuzzle(int[][] board) {

    }

    void bfs(int[][] board, int[] point) {
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(point);

        while (!queue.isEmpty()) {
            queue.poll();


        }
    }
}
