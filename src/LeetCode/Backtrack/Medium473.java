package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Medium473 {
    private List<Integer> nums = new ArrayList<>();
    private int[] sums = new int[4];
    private int side;

    public static void main(String[] args) {
        Medium473 obj = new Medium473();
        System.out.println(obj.makesquare(new int[]{1, 1, 2, 2, 2}));
    }

    // Medium 473. Matchsticks to Square
    public boolean makesquare(int[] matchsticks) {
        if (matchsticks.length == 0)
            return false;

        int perimeter = 0;
        for (int num : matchsticks) {
            perimeter += num;
            nums.add(num);
        }

        side = perimeter / 4;
        if (side * 4 != perimeter)
            return false;

        nums.sort(Collections.reverseOrder());
        return backtrack(0);
    }

    private boolean backtrack(int index) {
        if (index == nums.size())
            return sums[0] == sums[1] && sums[1] == sums[2] && sums[2] == sums[3];

        int currMatch = nums.get(index);
        for (int i = 0; i < 4; i++) {
            if (sums[i] + currMatch > side)
                continue;
            sums[i] += currMatch;
            if (backtrack(index + 1))
                return true;
            sums[i] -= currMatch;
        }

        return false;
    }
}
