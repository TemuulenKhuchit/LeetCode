package LeetCode.BinarySearch;

public class Easy69 {

    public static void main(String[] args) {
        System.out.println(mySqrt(8));
    }

    // Easy 69. Sqrt(x)
    public static int mySqrt(int x) {
        int lo = 0;
        int hi = x;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            long num = (long) mid * mid;
            if (num == x)
                return mid;
            else if (num > x)
                hi = mid - 1;
            else lo = mid + 1;
        }

        return lo - 1;
    }
}
