package LeetCode.PrefixSum;

public class Easy3354 {

    public static void main(String[] args) {
        System.out.println(countValidSelections(new int[]{1, 0, 2, 0, 3}));
    }

    // Easy 3354. Make Array Elements Equal to Zero
    public static int countValidSelections(int[] nums) {
        int n = nums.length;
        int result = 0;

        int sum = 0;
        for (int num : nums)
            sum += num;

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == 0) {
                if (leftSum == sum - leftSum)
                    result += 2;
                else if (leftSum == sum - leftSum + 1 || leftSum + 1 == sum - leftSum)
                    result++;
            }
            else leftSum += nums[i];
        }
        return result;
    }

}
