package LeetCode.BinarySearch;

public class Medium1011 {

    public static void main(String[] args) {
        System.out.println(shipWithinDays(new int[]{3, 2, 2, 4, 1, 4}, 3));
    }

    // Medium 1011. Capacity To Ship Packages Within D Days
    public static int shipWithinDays(int[] weights, int days) {
        int lo = 0;
        int hi = 0;
        for (int weight : weights) {
            lo = Math.max(lo, weight);
            hi += weight;
        }

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int shippedDays = 1;
            int shipped = 0;

            for (int weight : weights) {
                if (shipped + weight > mid) {
                    shippedDays++;
                    shipped = 0;
                }
                shipped += weight;
            }

            if (shippedDays <= days)
                hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
