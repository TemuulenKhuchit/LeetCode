package LeetCode.Backtrack;

public class Easy1863 {

    public static void main(String[] args) {
        System.out.println(subsetXORSum(new int[]{5, 1, 6}));
    }

    // Easy 1863. Sum of All Subset XOR Totals
    public static int subsetXORSum(int[] nums) {
        return XORSum(nums, 0, 0);
    }

    private static int XORSum(int[] nums, int idx, int currXOR) {
        if (idx == nums.length)
            return currXOR;

        int withElement = XORSum(nums, idx + 1, currXOR ^ nums[idx]);
        int withoutElement = XORSum(nums, idx + 1, currXOR);

        return withElement + withoutElement;
    }
}
