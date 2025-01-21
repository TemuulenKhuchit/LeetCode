package LeetCode.ArraysAndHashing;

import java.util.HashSet;
import java.util.Set;

public class Medium128 {

    public static void main(String[] args) {
        System.out.println(longestConsecutive(new int[]{100, 4, 200, 1, 3, 2}));
    }

    // Medium 128. Longest Consecutive Sequence
    public static int longestConsecutive(int[] nums) {
        if (nums.length <= 1) return nums.length;

        Set<Integer> set = new HashSet<>();
        for (int num : nums) set.add(num);

        int longest = 1;
        for (int num : nums) {
            if (!set.contains(num - 1)) {
                int currStreak = 1;
                int currNum = num + 1;
                while (set.contains(currNum)) {
                    currStreak++;
                    currNum++;
                    set.remove(num);
                }

                longest = Math.max(longest, currStreak);
            }
        }

        return longest;
    }
}
