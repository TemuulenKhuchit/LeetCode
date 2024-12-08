package Weekly.Contest427;

public class Question3 {

    public static void main(String[] args) {
        // Example 1:
        int[] nums1 = {1, 2};
        int k1 = 1;
        System.out.println(maxSubarraySumDivisibleByK(nums1, k1)); // Expected 3

        // Example 2:
        int[] nums2 = {-1, -2, -3, -4, -5};
        int k2 = 4;
        System.out.println(maxSubarraySumDivisibleByK(nums2, k2)); // Expected -10
    }

    public static int maxSubarraySumDivisibleByK(int[] nums, int k) {
        int n = nums.length;
        long[] prefix = new long[n + 1];
        // Compute prefix sums
        for (int i = 1; i <= n; i++) {
            prefix[i] = prefix[i - 1] + nums[i - 1];
        }

        // For storing the minimum prefix sum for each index remainder
        long[] minPrefixForIndexRem = new long[k];
        for (int i = 0; i < k; i++) {
            minPrefixForIndexRem[i] = Long.MAX_VALUE;
        }

        // Initialize for remainder = 0 with prefix[0] = 0
        minPrefixForIndexRem[0] = 0;

        long maxSum = Long.MIN_VALUE;

        for (int i = 1; i <= n; i++) {
            int remainder = i % k;

            if (minPrefixForIndexRem[remainder] != Long.MAX_VALUE) {
                long candidate = prefix[i] - minPrefixForIndexRem[remainder];
                if (candidate > maxSum) {
                    maxSum = candidate;
                }
            }

            // Update minPrefix for this remainder
            if (prefix[i] < minPrefixForIndexRem[remainder]) {
                minPrefixForIndexRem[remainder] = prefix[i];
            }
        }

        return (int) maxSum;
    }
}
