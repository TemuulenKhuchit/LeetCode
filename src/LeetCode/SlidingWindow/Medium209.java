package LeetCode.SlidingWindow;

public class Medium209 {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[]{2, 3, 1, 2, 4, 3}));
    }

    // Medium 209. Minimum Size Subarray Sum
    public static int minSubArrayLen(int target, int[] nums) {
        int start = 0, end = 0;
        int sum = 0;
        int res = Integer.MAX_VALUE;

        for (end = 0; end < nums.length; end++) {
            sum += nums[end];
            while (sum >= target) {
                res = Math.min(res, end - start + 1);
                sum -= nums[start++];
            }
        }
        return res == Integer.MAX_VALUE ? 0 : res;
    }

}
