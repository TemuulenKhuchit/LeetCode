package Biweekly.Contest437;

public class Question2 {

    public static void main(String[] args) {
        int[][] squares1 = {{0, 0, 1}, {2, 2, 1}};
        System.out.println(separateSquares(squares1));

        int[][] squares2 = {{0, 0, 2}, {1, 1, 1}};
        System.out.println(separateSquares(squares2));
    }

    public static double separateSquares(int[][] squares) {
        double totalArea = 0.0;
        long minY = Long.MAX_VALUE;
        long maxY = Long.MIN_VALUE;
        for (int[] square : squares) {
            long y = square[1];
            long l = square[2];
            totalArea += (double) l * l;
            minY = Math.min(minY, y);
            maxY = Math.max(maxY, y + l);
        }

        double halfArea = totalArea / 2.0;

        double shift = minY;
        double lo = 0.0;
        double hi = maxY - minY;

        for (int iter = 0; iter < 60; iter++) {
            double mid = lo + (hi - lo) / 2;
            double areaAbove = computeAreaAboveShifted(mid, squares, shift);
            if (areaAbove > halfArea)
                lo = mid;
            else
                hi = mid;
        }

        return (lo + hi) / 2.0 + shift;
    }

    private static double computeAreaAboveShifted(double H, int[][] squares, double shift) {
        double area = 0.0;
        for (int[] square : squares) {
            double y = square[1] - shift;
            double l = square[2];
            double top = y + l;
            if (H <= y)
                area += l * l;
            else if (H < top)
                area += l * (top - H);
        }
        return area;
    }

}
