package LeetCode.SlidingWindow;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium658 {

    public static void main(String[] args) {
        System.out.println(findClosestElements(new int[]{1, 2, 3, 4, 5}, 4, 3));
    }

    // Medium 658. Find K Closest Elements
    public static List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> res = new ArrayList<>();

        if (arr.length == k) {
            for (int num : arr)
                res.add(num);
            return res;
        }

        int left = 0;
        int right = arr.length;
        int mid = 0;
        while (left < right) {
            mid = (left + right) / 2;
            if (arr[mid] >= x)
                right = mid;
            else
                left = mid + 1;
        }

        left--;
        right = left + 1;

        while (right - left - 1 < k) {
            if (left == -1) {
                right++;
                continue;
            }
            if (right == arr.length || Math.abs(arr[left] - x) <= Math.abs(arr[right] - x))
                left--;
            else
                right++;
        }

        for (int i = left + 1; i < right; i++)
            res.add(arr[i]);

        return res;
    }

}
