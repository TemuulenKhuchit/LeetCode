package LeetCode.BinarySearch;

public class Medium153 {

    public static void main(String[] args) {
        System.out.println(findMin(new int[]{3, 4, 5, 1, 2}));
    }

    // Medium 153. Find Minimum in Rotated Sorted Array
    public static int findMin(int[] nums) {
        if (nums[nums.length - 1] >= nums[0])
            return nums[0];
        int lo = 1;
        int hi = nums.length - 1;

        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            if (nums[mid] > nums[hi])
                lo = mid + 1;
            else hi = mid;
        }
        return nums[lo];
    }
}
