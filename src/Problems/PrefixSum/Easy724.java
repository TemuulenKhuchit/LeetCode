package Problems.PrefixSum;

public class Easy724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    // Easy 724. Find Pivot Index
    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        int sum = 0;
        for (int num : nums)
            sum += num;

        int leftSum = 0;
        for (int i = 0; i < n; i++) {
            if (leftSum == sum - leftSum - nums[i])
                return i;
            leftSum += nums[i];
        }

        return -1;
    }

}
