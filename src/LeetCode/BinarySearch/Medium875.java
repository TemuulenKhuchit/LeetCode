package LeetCode.BinarySearch;

public class Medium875 {

    public static void main(String[] args) {
        System.out.println(minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
    }

    // Medium 875. Koko Eating Bananas
    public static int minEatingSpeed(int[] piles, int h) {
        int lo = 1;
        int hi = 1;
        for (int pile : piles)
            hi = Math.max(hi, pile);

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int spentHours = 0;

            for (int pile : piles)
                spentHours += Math.ceil((double) pile / mid);

            if (spentHours <= h)
                hi = mid;
            else lo = mid + 1;
        }

        return lo;
    }
}
