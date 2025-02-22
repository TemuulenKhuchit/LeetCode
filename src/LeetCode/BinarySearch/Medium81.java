package LeetCode.BinarySearch;

public class Medium81 {

    public static void main(String[] args) {
        System.out.println(search(new int[]{2, 5, 6, 0, 0, 1, 2}, 0));
    }

    // Medium 81. Search in Rotated Sorted Array II
    public static boolean search(int[] nums, int target) {
        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[mid] == target)
                return true;

            if (nums[lo] == nums[mid]) {
                lo++;
                continue;
            }

            boolean pivotArray = nums[lo] <= nums[mid];
            boolean targetArray = nums[lo] <= target;

            if (pivotArray ^ targetArray) {
                if (pivotArray)
                    lo = mid + 1;
                else hi = mid - 1;
            }
            else {
                if (nums[mid] < target)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }

        return false;
    }
}
