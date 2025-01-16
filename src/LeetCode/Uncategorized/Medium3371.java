package LeetCode.Uncategorized;

import java.util.TreeMap;

public class Medium3371 {

    public static void main(String[] args) {
        getLargestOutlier(new int[]{2, 3, 5, 10});
    }

    // Medium 3371. Identify the Largest Outlier in an Array
    public static int getLargestOutlier(int[] nums) {
        TreeMap<Integer, Integer> frequencyMap = new TreeMap<>();
        int result = Integer.MIN_VALUE;
        int sum = 0;

        for (int num : nums) {
            sum += num;
            frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        }

        for (int num : nums) {
            if ((sum - num) % 2 == 0) {
                int target = (sum - num) / 2;

                frequencyMap.put(num, frequencyMap.get(num) - 1);
                if (frequencyMap.get(num) == 0)
                    frequencyMap.remove(num);

                if (frequencyMap.containsKey(target))
                    result = Math.max(result, num);

                frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
            }
        }

        return result;
    }
}
