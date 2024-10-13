package Weekly.Contest419;

import java.util.Arrays;

public class Question1 {

    public static void main(String[] args) {
        findXSum(new int[]{1, 1, 2, 2, 3, 4, 2, 3}, 6, 2);
    }

    public static int[] findXSum(int[] nums, int k, int x) {
        int n = nums.length;
        int[] result = new int[n - k + 1];

        for (int i = 0; i < result.length; i++) {
            int count = 0;
            while (count < k) {
                result[i] += nums[i + count];
                System.out.print(nums[i + count] + ", ");
                count++;
            }
            System.out.println();
        }

        System.out.println(Arrays.toString(result));
        return result;
    }

}
