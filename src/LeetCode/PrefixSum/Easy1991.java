package LeetCode.PrefixSum;

public class Easy1991 {

    public static void main(String[] args) {
        System.out.println(findMiddleIndex(new int[]{2, 3, -1, 8, 4}));
    }

    // Easy 1991. Find the Middle Index in Array
    public static int findMiddleIndex(int[] nums) {
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
