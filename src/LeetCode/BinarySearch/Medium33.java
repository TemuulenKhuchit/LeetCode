package LeetCode.BinarySearch;

public class Medium33 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{4, 5, 6, 7, 0, 1, 2}, 0));
    }

    // Medium 33. Search in Rotated Sorted Array
    public static int search(int[] nums, int target) {
        int n = nums.length;
        int lo = 0;
        int hi = n - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return mid;
            else if (nums[mid] >= nums[lo]) {
                if (nums[lo] <= target && nums[mid] > target)
                    hi = mid - 1;
                else lo = mid + 1;
            }
            else {
                if (nums[hi] >= target && nums[mid] < target)
                    lo = mid + 1;
                else hi = mid - 1;
            }
        }

        return -1;
    }
}
