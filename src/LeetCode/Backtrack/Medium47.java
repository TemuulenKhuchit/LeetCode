package LeetCode.Backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Medium47 {

    public static void main(String[] args) {
        System.out.println(permuteUnique(new int[]{1, 1, 2}));
    }

    // Medium 47. Permutations II
    public static List<List<Integer>> permuteUnique(int[] nums) {
        Map<Integer, Integer> counterMap = new HashMap<>();
        for (int num : nums)
            counterMap.put(num, counterMap.getOrDefault(num, 0) + 1);
        List<List<Integer>> res = new ArrayList<>();
        findPermutes(new ArrayList<>(), res, counterMap, nums.length);
        return res;
    }

    private static void findPermutes(
            List<Integer> curr, List<List<Integer>> res, Map<Integer, Integer> counterMap, int len) {
        if (curr.size() == len) {
            res.add(new ArrayList<>(curr));
            return;
        }

        for (Map.Entry<Integer, Integer> entry : counterMap.entrySet()) {
            Integer num = entry.getKey();
            Integer count = entry.getValue();
            if (count == 0)
                continue;
            curr.add(num);
            counterMap.put(num, count - 1);

            findPermutes(curr, res, counterMap, len);

            curr.remove(curr.size() - 1);
            counterMap.put(num, count);
        }
    }
}
