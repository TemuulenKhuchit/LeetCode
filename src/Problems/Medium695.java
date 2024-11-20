package Problems;

import java.util.*;

public class Medium695 {

    public static void main(String[] args) {
        Medium695 medium695 = new Medium695();
        int[][] grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        medium695.maxAreaOfIsland(grid);
    }

    // Easy 695. Max Area of Island
    public int maxAreaOfIsland(int[][] grid) {
        Set<Pair> dirs = new HashSet<>();
        dirs.add(new Pair(-1, 0)); // Up
        dirs.add(new Pair(1, 0)); // Down
        dirs.add(new Pair(0, 1)); // Right
        dirs.add(new Pair(0, -1)); // Left

        int[][] visited = new int[grid.length][grid.length];


//        for ()
        return 0;
    }

    class Pair {
        int row;
        int col;

        public Pair(int row, int col) {
            this.row = row;
            this.col = col;
        }
    }
}
