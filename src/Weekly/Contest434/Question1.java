package Weekly.Contest434;

public class Question1 {

    public static void main(String[] args) {
        System.out.println(countPartitions(new int[]{10, 10, 3, 7, 6}));
    }

    public static int countPartitions(int[] nums) {
        int n = nums.length;
        int count = 0;
        int leftSum = 0;
        for (int i = 0; i < n - 1; i++) {
            leftSum += nums[i];
            int rightSum = 0;
            for (int j = i + 1; j < n; j++) {
                rightSum += nums[j];
            }
            if ((leftSum - rightSum) % 2 == 0)
                count++;
        }
        return count;
    }
}
