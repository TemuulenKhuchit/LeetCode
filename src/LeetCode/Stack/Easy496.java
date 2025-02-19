package LeetCode.Stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Easy496 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(nextGreaterElement(new int[]{4, 1, 2}, new int[]{1, 3, 4, 2})));
    }

    // Easy 496. Next Greater Element I
    public static int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        Map<Integer, Integer> map = new HashMap<>();

        for (int num : nums2) {
            while (!st.isEmpty() && st.peek() < num)
                map.put(st.pop(), num);
            st.push(num);
        }

        while (!st.isEmpty())
            map.put(st.pop(), -1);

        int[] res = new int[nums1.length];
        for (int i = 0; i < res.length; i++)
            res[i] = map.get(nums1[i]);

        return res;
    }

}
