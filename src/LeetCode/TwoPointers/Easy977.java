package LeetCode.TwoPointers;

import java.util.Arrays;

public class Easy977 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(sortedSquares(new int[]{-4, -1, 0, 3, 10})));
    }

    // Easy 977. Squares of a Sorted Array
    public static int[] sortedSquares(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int p1 = 0;
        int p2 = n - 1;
        for (int p = n - 1; p >= 0; p--) {
            if (Math.abs(nums[p1]) < Math.abs(nums[p2])) {
                result[p] = nums[p2] * nums[p2];
                p2--;
            }
            else {
                result[p] = nums[p1] * nums[p1];
                p1++;
            }
        }
        return result;
    }

}
