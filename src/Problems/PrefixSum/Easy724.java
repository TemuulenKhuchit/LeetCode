package Problems.PrefixSum;

public class Easy724 {

    public static void main(String[] args) {
        System.out.println(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));
    }

    // Easy 724. Find Pivot Index
    public static int pivotIndex(int[] nums) {
        int n = nums.length;

        int[] left_prefix = new int[n + 1];
        for (int i = 0; i < n; i++)
            left_prefix[i + 1] = left_prefix[i] + nums[i];

        int[] right_prefix = new int[n + 1];
        for (int i = n - 1; i >= 0; i--)
            right_prefix[i] = right_prefix[i + 1] + nums[i];

        for (int i = 0; i < n; i++)
            if (left_prefix[i] == right_prefix[i + 1])
                return i;

        return -1;
    }

}
