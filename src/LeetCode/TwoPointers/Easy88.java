package LeetCode.TwoPointers;

public class Easy88 {

    public static void main(String[] args) {
        merge(new int[]{1, 2, 3, 0, 0, 0}, 3, new int[]{2, 5, 6}, 3);
    }

    // Easy 88. Merge Sorted Array
    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int i = m - 1;
        int j = n - 1;
        for (int k = nums1.length - 1; k >= 0; k--) {
            if (i < 0 || (j >= 0 && nums1[i] < nums2[j]))
                nums1[k] = nums2[j--];
            else
                nums1[k] = nums1[i--];
        }
    }

}
