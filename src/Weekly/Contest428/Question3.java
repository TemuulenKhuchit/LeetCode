package Weekly.Contest428;

import java.util.*;

public class Question3 {

    public static void main(String[] args) {
        // Example 1
        int[] nums1 = {1, 1, 2, 1};
        System.out.println("Output: " + beautifulSplits(nums1)); // Expected output: 2

        // Example 2
        int[] nums2 = {1, 2, 3, 4};
        System.out.println("Output: " + beautifulSplits(nums2)); // Expected output: 0
    }

    public static int beautifulSplits(int[] nums) {
        int n = nums.length;
        int res = 0;

        int[] pxSum = new int[n];
        pxSum[0] = nums[0];
        for (int i = 1; i < n; i++)
            pxSum[i] = pxSum[i - 1] + nums[i];

        int totalSum = pxSum[n - 1];

        for (int i = 0; i < n - 2; i++) {
            int sum1 = pxSum[i];
            for (int j = i + 1; j < n - 1; j++) {
                int sum2 = pxSum[j] - pxSum[i];
                int sum3 = totalSum - pxSum[j];

                if (sum1 == sum2 || sum2 == sum3)
                    res++;
            }
        }

        return res;
    }

    public static int beautifulSplits2(int[] nums) {
        int n = nums.length;
        int count = 0;

        // Prefix sum array
        int[] pxSum = new int[n];
        pxSum[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pxSum[i] = pxSum[i - 1] + nums[i];
        }

        // Total sum of the array
        int totalSum = pxSum[n - 1];

        for (int i = 0; i < n - 2; i++) {
            int sum1 = pxSum[i]; // Sum of nums1
            for (int j = i + 1; j < n - 1; j++) {
                int sum2 = pxSum[j] - pxSum[i]; // Sum of nums2
                int sum3 = totalSum - pxSum[j]; // Sum of nums3

                // Check the beautiful split condition
                if (sum1 <= sum2 && sum2 <= sum3) {
                    if (sum1 == sum2 || sum2 == sum3) {
                        count++;
                    }
                }
            }
        }

        return count;
    }


}
