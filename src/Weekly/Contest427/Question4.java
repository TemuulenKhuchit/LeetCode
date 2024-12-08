package Weekly.Contest427;

import java.util.*;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public class Question4 {
    public static long maxRectangleArea(int[] xCoord, int[] yCoord) {
        int n = xCoord.length;
        if (n < 4) return -1;

        // Step 1: Coordinate Compression
        int[] uniqueX = Arrays.stream(xCoord).distinct().sorted().toArray();
        int[] uniqueY = Arrays.stream(yCoord).distinct().sorted().toArray();

        Map<Integer, Integer> xToIndex = new HashMap<>();
        Map<Integer, Integer> yToIndex = new HashMap<>();
        for (int i = 0; i < uniqueX.length; i++) xToIndex.put(uniqueX[i], i);
        for (int i = 0; i < uniqueY.length; i++) yToIndex.put(uniqueY[i], i);

        // Step 2: Build Grid
        int[][] grid = new int[uniqueX.length][uniqueY.length];
        for (int i = 0; i < n; i++) {
            int xi = xToIndex.get(xCoord[i]);
            int yi = yToIndex.get(yCoord[i]);
            grid[xi][yi] = 1;
        }

        // Build prefix sums P (use int since we are just counting points)
        int[][] P = new int[uniqueX.length+1][uniqueY.length+1];
        for (int i = 1; i <= uniqueX.length; i++) {
            for (int j = 1; j <= uniqueY.length; j++) {
                P[i][j] = grid[i-1][j-1]
                        + P[i-1][j]
                        + P[i][j-1]
                        - P[i-1][j-1];
            }
        }

        // Function to count how many points lie in the rectangle defined by compressed indices
        BiFunction<int[], int[], Integer> countPoints = (xx, yy) -> {
            int x1 = xx[0], x2 = xx[1], y1 = yy[0], y2 = yy[1];
            return P[x2+1][y2+1] - P[x2+1][y1] - P[x1][y2+1] + P[x1][y1];
        };

        // Store points in a set for O(1) corner existence checks
        Set<String> pointSet = new HashSet<>(n);
        for (int i = 0; i < n; i++) {
            pointSet.add(xCoord[i] + "," + yCoord[i]);
        }

        long maxArea = -1;

        // Step 3: Iterate over pairs (consider them as diagonal corners)
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                int x1 = xCoord[i], y1 = yCoord[i];
                int x2 = xCoord[j], y2 = yCoord[j];

                // Points must differ in both x and y to form a rectangle diagonal
                if (x1 != x2 && y1 != y2) {
                    // The other two corners
                    String c3 = x1 + "," + y2;
                    String c4 = x2 + "," + y1;

                    if (pointSet.contains(c3) && pointSet.contains(c4)) {
                        // We have a rectangle
                        int xmin = Math.min(x1, x2);
                        int xmax = Math.max(x1, x2);
                        int ymin = Math.min(y1, y2);
                        int ymax = Math.max(y1, y2);

                        int xi1 = xToIndex.get(xmin), xi2 = xToIndex.get(xmax);
                        int yi1 = yToIndex.get(ymin), yi2 = yToIndex.get(ymax);

                        int insideCount = countPoints.apply(new int[]{xi1, xi2}, new int[]{yi1, yi2});
                        if (insideCount == 4) {
                            // Calculate area using long to avoid overflow
                            long area = (long) (xmax - xmin) * (ymax - ymin);
                            if (area > maxArea) {
                                maxArea = area;
                            }
                        }
                    }
                }
            }
        }

        return maxArea;
    }

    public static void main(String[] args) {
        // Test cases
        int[] x1 = {1,1,3,3};
        int[] y1 = {1,3,1,3};
        System.out.println(maxRectangleArea(x1, y1)); // Expected 4

        int[] x2 = {1,1,3,3,2};
        int[] y2 = {1,3,1,3,2};
        System.out.println(maxRectangleArea(x2, y2)); // Expected -1 (point inside)

        // Larger coordinate values to demonstrate long usage
        int[] x3 = {1000000000, 1000000000, 1000000002, 1000000002};
        int[] y3 = {1000000000, 1000000002, 1000000000, 1000000002};
        System.out.println(maxRectangleArea(x3, y3));
        // Area = (1000000002-1000000000)*(1000000002-1000000000) = 2*2=4 (fits in int but shows we can handle large coords)

        int[] x4 = {0,0,1000000000,1000000000};
        int[] y4 = {0,1000000000,0,1000000000};
        // Huge rectangle area = 1000000000L * 1000000000L = 10^18, needs long
        System.out.println(maxRectangleArea(x4, y4)); // Expected: 1000000000000000000 (10^18)
    }
}
