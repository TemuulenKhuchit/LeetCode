package LeetCode.BinarySearch;

public class Hard410 {

    public static void main(String[] args) {
        System.out.println(splitArray(new int[]{7, 2, 5, 10, 8}, 3));
    }

    // Hard 410. Split Array Largest Sum
    public static int splitArray(int[] nums, int k) {
        int sum = 0;
        int max = 0;
        for (int num : nums) {
            sum += num;
            max = Math.max(max, num);
        }

        int lo = max;
        int hi = sum;
        int res = hi;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (canSplit(nums, mid, k)) {
                res = mid;
                hi = mid - 1;
            }
            else lo = mid + 1;
        }

        return res;
    }

    private static boolean canSplit(int[] nums, int mid, int k) {
        int sum = 0;
        int splits = 1;
        for (int num : nums) {
            sum += num;
            if (sum > mid) {
                splits++;
                sum = num;
            }
        }
        return splits <= k;
    }
}
