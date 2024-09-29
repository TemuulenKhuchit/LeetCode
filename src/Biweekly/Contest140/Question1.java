package Biweekly.Contest140;

public class Question1 {
    public int minElement(int[] nums) {
        int minSum = Integer.MAX_VALUE;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            sum = 0;
            while (num > 0) {
                sum = sum + num % 10;
                num /= 10;
            }
            if (minSum > sum)
                minSum = sum;
        }
        return minSum;
    }
}