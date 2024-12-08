package Weekly.Contest427;

import java.util.Arrays;
import java.util.Stack;

public class Question2 {
    static int[] min = new int[]{Integer.MAX_VALUE, Integer.MAX_VALUE};
    static int[] max = new int[]{Integer.MIN_VALUE, Integer.MIN_VALUE};

    public static void main(String[] args) {
        int[][] points1 = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}};
        int[][] points2 = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int[][] points3 = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}, {1, 2}, {3, 2}};
        int[][] points4 = new int[][]{{0, 0}, {1, 0}, {2, 0}, {3, 0}};
        int[][] points5 = new int[][]{{1, 1}, {1, 3}, {3, 1}, {3, 3}};
        Question2 obj = new Question2();
        System.out.println(obj.maxRectangleArea(points1));
        System.out.println(obj.maxRectangleArea(points2));
        System.out.println(obj.maxRectangleArea(points3));
        System.out.println(obj.maxRectangleArea(points4));
        System.out.println(obj.maxRectangleArea(points5));
    }

    public int maxRectangleArea(int[][] points) {
        int area = -1;

        for (int i = 0; i < points.length; i++) {
            int dfsRes = dfs(points, i);
            if (dfsRes == -1) return -1;
            area = Math.max(area, dfsRes);
        }

        System.out.println(Arrays.toString(min) + " " + Arrays.toString(max));

        for (int[] point : points) {
            int x = point[0];
            int y = point[1];

            if (x > min[0] && x < max[0] || y > min[1] && y < max[1]) {
                return -1;
            }
        }

        if (min[0] == max[0] || max[1] == min[1]) return -1;

        return area;
    }

    public static int dfs(int[][] points, int pointInd) {
        int[] visited = new int[points.length];

        Stack<Integer> stack = new Stack<>();
        stack.push(pointInd);

        while (!stack.isEmpty()) {
            int currPointInd = stack.pop();

            visited[currPointInd] = 1;

            int x1 = points[currPointInd][0];
            int y1 = points[currPointInd][1];

            if (x1 < min[0] && y1 < min[1]) min = new int[]{x1, y1};
            if (x1 > max[0] && y1 > max[1]) max = new int[]{x1, y1};

            for (int i = 0; i < points.length; i++) {
                if (currPointInd == i) continue;

                int x2 = points[i][0];
                int y2 = points[i][1];

                if ((x1 == x2 || y1 == y2) && visited[i] == 0 && !stack.contains(i)) stack.push(i);
            }
        }

        return (max[0] - min[0]) * (max[1] - min[1]);
    }
}