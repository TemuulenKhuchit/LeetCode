package Biweekly.Contest148;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(maxAdjacentDistance(new int[]{-5, -10, -5}));
    }

    public static int maxAdjacentDistance(int[] nums) {
        int n = nums.length;
        int diff = Math.abs(nums[n - 1] - nums[0]);
        for (int i = 1; i < n; i++)
            diff = Math.max(diff, Math.abs(nums[i] - nums[i - 1]));
        return diff;
    }

}
