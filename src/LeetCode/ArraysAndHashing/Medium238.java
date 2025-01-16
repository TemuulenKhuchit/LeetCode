package LeetCode.ArraysAndHashing;

import java.util.Arrays;

public class Medium238 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(productExceptSelf(new int[]{1, 2, 3, 4})));
    }

    // Medium 238. Product of Array Except Self
    // Solution 1. With extra space complexity
    public static int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];
        int[] answer = new int[n];

        left[0] = 1;
        for (int i = 1; i < n; i++)
            left[i] = left[i - 1] * nums[i - 1];

        right[n - 1] = 1;
        for (int i = n - 2; i >= 0; i--)
            right[i] = right[i + 1] * nums[i + 1];

        for (int i = 0; i < n; i++)
            answer[i] = left[i] * right[i];

        return answer;
    }

    // Solution 2. Without extra space complexity
    public static int[] productExceptSelf2(int[] nums) {
        int n = nums.length;
        int[] answer = new int[n];

        answer[0] = 1;
        for (int i = 1; i < n; i++)
            answer[i] = answer[i - 1] * nums[i - 1];

        int right = 1;
        int curr = 1;
        for (int i = n - 2; i >= 0; i--) {
            curr = right * nums[i + 1];
            answer[i] *= curr;
            right = curr;
        }

        return answer;
    }
}
