package LeetCode.BinarySearch;

public class Hard4 {

    public static void main(String[] args) {
        System.out.println(findMedianSortedArrays(new int[]{1, 3}, new int[]{2, 4}));
    }

    // Hard 4. Median of Two Sorted Arrays
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;

        // nums1 should be shorter one
        if (n1 > n2)
            return findMedianSortedArrays(nums2, nums1);

        int total = n1 + n2;
        int half = (total + 1) / 2;

        int lo = 0;
        int hi = n1;

        while (lo <= hi) {
            int i = lo + (hi - lo) / 2; // mid1
            int j = half - i;           // mid2

            // four points of partitions
            int left1 = (i == 0) ? Integer.MIN_VALUE : nums1[i - 1];
            int right1 = (i == n1) ? Integer.MAX_VALUE : nums1[i];

            int left2 = (j == 0) ? Integer.MIN_VALUE : nums2[j - 1];
            int right2 = (j == n2) ? Integer.MAX_VALUE : nums2[j];

            // partition is correct
            if (left1 <= right2 && left2 <= right1) {
                if (total % 2 == 1)
                    return Math.max(left1, left2);
                return (Math.max(left1, left2) + Math.min(right1, right2)) / 2.0;
            }
            // partition is wrong (update left/right pointers)
            else if (left1 > right2)
                hi = i - 1;
            else lo = i + 1;
        }
        return 0.0;
    }
}
