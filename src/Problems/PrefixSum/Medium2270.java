package Problems.PrefixSum;

public class Medium2270 {

    public static void main(String[] args) {
        System.out.println(waysToSplitArray(new int[]{10, 4, -8, 7}));
    }

    // Medium 2270. Number of Ways to Split Array
    public static int waysToSplitArray(int[] nums) {
        int n = nums.length;
        long[] ps = new long[n];
        ps[0] = nums[0];
        for (int i = 1; i < n; i++)
            ps[i] = ps[i - 1] + nums[i];

        int count = 0;
        for (int i = 0; i < n - 1; i++)
            if (ps[i] >= ps[n - 1] - ps[i])
                count++;
        return count;
    }

}
