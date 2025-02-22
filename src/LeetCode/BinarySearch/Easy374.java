package LeetCode.BinarySearch;

import java.util.Random;

public class Easy374 {

    public static void main(String[] args) {
        System.out.println(guessNumber(5));
    }

    // Easy 374. Guess Number Higher or Lower
    public static int guessNumber(int n) {
        int lo = 0;
        int hi = n;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            if (guess(mid) == 0)
                return mid;
            else if (guess(mid) == 1)
                lo = mid + 1;
            else hi = mid - 1;
        }

        return -1;
    }

    public static int guess(int n) {
        return 0;
    }
}
