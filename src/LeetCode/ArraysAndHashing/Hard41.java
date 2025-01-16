package LeetCode.ArraysAndHashing;

import java.util.Arrays;

public class Hard41 {

    public static void main(String[] args) {
//        System.out.println(firstMissingPositive(new int[]{1, 2, 0}));
//        System.out.println(firstMissingPositive(new int[]{3, 4, -1, 1}));
//        System.out.println(firstMissingPositive(new int[]{100000, 3, 4000, 2, 15, 1, 99999}));
//        System.out.println(firstMissingPositive(new int[]{7, 8, 9, 11, 12}));
        System.out.println(firstMissingPositive(new int[]{1, 0}));
    }

    // Hard 41. First Missing Positive
    public static int firstMissingPositive(int[] nums) {
        if (nums.length == 1) {
            if (nums[0] != 1)
                return 1;
            else return 2;
        }
        Arrays.sort(nums);
        int min = Integer.MAX_VALUE;

        for (int i = 0; i < nums.length; i++)
            if (nums[i] > 0) {
                min = Math.min(nums[i], min);
                if (min != 1)
                    return 1;
                if (i + 1 < nums.length && nums[i] != nums[i + 1] - 1)
                    return nums[i] + 1;
            }

        if (min == Integer.MAX_VALUE)
            return 1;

        return nums[nums.length - 1] + 1;
    }
}
