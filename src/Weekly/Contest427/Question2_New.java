package Weekly.Contest427;

import java.util.HashSet;
import java.util.Set;

public class Question2_New {
    public static void main(String[] args) {
        int[][] points1 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};
        int[][] points2 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {2, 2}};
        int[][] points3 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}, {1, 2}, {3, 2}};
        int[][] points4 = {{0, 0}, {1, 0}, {2, 0}, {3, 0}};
        int[][] points5 = {{1, 1}, {1, 3}, {3, 1}, {3, 3}};

        System.out.println(maxRectangleArea(points1)); // Should be 4
        System.out.println(maxRectangleArea(points2)); // -1 due to extra point inside
        System.out.println(maxRectangleArea(points3)); // -1 due to points on the border
        System.out.println(maxRectangleArea(points4)); // -1 no rectangle can form
        System.out.println(maxRectangleArea(points5)); // 4 (same as points1)
    }

    public static int maxRectangleArea(int[][] points) {
        int n = points.length;
        if (n < 4) return -1;

        Set<String> pointSet = new HashSet<>();
        for (int[] p : points) {
            pointSet.add(p[0] + "," + p[1]);
        }

        int maxArea = -1;

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int x1 = points[i][0], y1 = points[i][1];
                int x2 = points[j][0], y2 = points[j][1];

                if (x1 != x2 && y1 != y2) {
                    String corner3 = x1 + "," + y2;
                    String corner4 = x2 + "," + y1;

                    if (pointSet.contains(corner3) && pointSet.contains(corner4)) {
                        int xMin = Math.min(x1, x2);
                        int xMax = Math.max(x1, x2);
                        int yMin = Math.min(y1, y2);
                        int yMax = Math.max(y1, y2);

                        int countInside = 0;
                        for (int[] p : points) {
                            int px = p[0], py = p[1];
                            if (px >= xMin && px <= xMax && py >= yMin && py <= yMax) {
                                countInside++;
                                if (countInside > 4) {
                                    break;
                                }
                            }
                        }

                        if (countInside == 4) {
                            int area = (xMax - xMin) * (yMax - yMin);
                            maxArea = Math.max(maxArea, area);
                        }
                    }
                }
            }
        }

        return maxArea;
    }
}
