package cses.graph;

import java.util.Scanner;

public class CountingRooms {
    static int n;
    static int m;
    static int[][] visited;
    static char[][] grid;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First line: read n and m
        String[] dimensions = sc.nextLine().split(" ");
        n = Integer.parseInt(dimensions[0]);
        m = Integer.parseInt(dimensions[1]);

        // Read the map lines into a 2D char array
        grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++)
                grid[i][j] = line.charAt(j);
        }

        int rooms = 0;
        visited = new int[n][m];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (visited[i][j] == 0 && grid[i][j] == '.') {
                    rooms++;
                    dfs(i, j);
                }
            }
        }

        System.out.println(rooms);
    }

    public static void dfs(int row, int col) {
        if (row < 0 || col < 0 || row >= n || col >= m)
            return;

        if (visited[row][col] == 1 || grid[row][col] == '#')
            return;

        visited[row][col] = 1;

        dfs(row, col + 1);
        dfs(row, col - 1);
        dfs(row + 1, col);
        dfs(row - 1, col);
    }
}