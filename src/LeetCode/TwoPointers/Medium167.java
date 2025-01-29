package LeetCode.TwoPointers;

import java.util.Arrays;

public class Medium167 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(twoSum(new int[]{2, 7, 11, 15}, 9)));
    }

    // Medium 167. Two Sum II - Input Array Is Sorted
    public static int[] twoSum(int[] numbers, int target) {
        int i = 0;
        int j = numbers.length - 1;
        while (i < j) {
            if (numbers[i] + numbers[j] == target)
                return new int[]{i + 1, j + 1};
            else if (numbers[i] + numbers[j] < target)
                i++;
            else
                j--;
        }

        return new int[2];
    }
}
