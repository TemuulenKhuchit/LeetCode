package cses.graph;


import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Labyrinth {

    static class Point {
        int x, y;
        Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First line: read n and m
        String[] dimensions = sc.nextLine().split(" ");
        int n = Integer.parseInt(dimensions[0]);
        int m = Integer.parseInt(dimensions[1]);

        // Read the map lines into a 2D char array
        char[][] grid = new char[n][m];
        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            for (int j = 0; j < m; j++)
                grid[i][j] = line.charAt(j);
        }

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        char[] moves = {'U', 'D', 'L', 'R'};

        Point start = null, end = null;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i][j] == 'A') start = new Point(i, j);
                if (grid[i][j] == 'B') end = new Point(i, j);
            }
        }

        Queue<Point> queue = new LinkedList<>();
        boolean[][] visited = new boolean[n][m];
        Point[][] parent = new Point[n][m];

        queue.add(start);
        visited[start.x][start.y] = true;

        while (!queue.isEmpty()) {
            Point current = queue.poll();

            if (current.x == end.x && current.y == end.y) {
                StringBuilder path = new StringBuilder();
                Point trace = end;
                while (trace != null && trace != start) {
                    Point prev = parent[trace.x][trace.y];
                    if (prev == null) break;

                    for (int d = 0; d < 4; d++) {
                        if (prev.x + dx[d] == trace.x && prev.y + dy[d] == trace.y) {
                            path.append(moves[d]);
                            break;
                        }
                    }

                    trace = prev;
                }
                System.out.println("YES");
                System.out.println(path.length());
                System.out.println(path.reverse());
                return;
            }

            for (int d = 0; d < 4; d++) {
                int nx = current.x + dx[d];
                int ny = current.y + dy[d];

                if (nx >= 0 && nx < n && ny >= 0 && ny < m && !visited[nx][ny] && grid[nx][ny] != '#') {
                    visited[nx][ny] = true;
                    parent[nx][ny] = current;
                    queue.add(new Point(nx, ny));
                }
            }
        }

        System.out.println("NO");
    }
}
/*
    public static void bfs2(int row, int col) {
        ArrayDeque<int[]> queue = new ArrayDeque<>();
        queue.add(new int[]{row, col});

        int[][] visited = new int[n][m];
        int[][] directions = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

        StringBuilder path = new StringBuilder();
        String result = "";

        while (!queue.isEmpty()) {
            queue.remove();
            visited[row][col] = 1;

            for (int[] dir : directions) {
                int newRow = row + dir[0];
                int newCol = col + dir[1];

                char direction = ' ';
                if (dir[0] == 0 && dir[1] == 1) direction = 'R';
                else if (dir[0] == 0 && dir[1] == -1) direction = 'L';
                else if (dir[0] == 1 && dir[1] == 0) direction = 'D';
                else if (dir[0] == -1 && dir[1] == 0) direction = 'U';

                if (newRow >= 0 && newRow < n && newCol >= 0 && newCol < m && grid[newRow][newCol] != '#' && visited[newRow][newCol] == 0) {
                    queue.add(new int[]{newRow, newCol});
                    path.append(direction);
                    if (grid[newRow][newCol] == 'B') {
                        System.out.println(result + " " + path);
                        if (result.isEmpty() || result.length() > path.length())
                            result = path.toString();
                        return;
                    }
                }
            }
        }

    }

    public static void dfs(int row, int col, String path, char direction, int[][] visited) {
        if (row < 0 || col < 0 || row >= n || col >= m)
            return;

        if (grid[row][col] == '#' || visited[row][col] == 1)
            return;

        if (grid[row][col] != 'B')
            visited[row][col] = 1;
        path += direction == ' ' ? "" : direction;

        if (grid[row][col] == 'B') {
            System.out.println(result + " " + path);
            if (result.isEmpty() || result.length() > path.length()) {
                result = path;
            }
            System.out.println(result + " " + path);
            return;
        }

        dfs(row, col + 1, path, 'R', visited);
        dfs(row, col - 1, path, 'L', visited);
        dfs(row + 1, col, path, 'D', visited);
        dfs(row - 1, col, path, 'U', visited);
    }
*/
