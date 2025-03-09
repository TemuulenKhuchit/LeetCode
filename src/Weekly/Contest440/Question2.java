package Weekly.Contest440;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Question2 {

    private static class Pair {
        int num1;
        int num2;
        int index;

        Pair(int num1, int num2, int index) {
            this.num1 = num1;
            this.num2 = num2;
            this.index = index;
        }
    }

    public long[] findMaxSum(int[] nums1, int[] nums2, int k) {
        int n = nums1.length;
        long[] answer = new long[n];

        Pair[] pairs = new Pair[n];
        for (int i = 0; i < n; i++)
            pairs[i] = new Pair(nums1[i], nums2[i], i);

        Arrays.sort(pairs, Comparator.comparingInt(p -> p.num1));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0;

        int i = 0;
        while (i < n) {
            int j = i;
            while (j < n && pairs[j].num1 == pairs[i].num1) {
                answer[pairs[j].index] = currentSum;
                j++;
            }
            for (int t = i; t < j; t++) {
                int value = pairs[t].num2;
                if (minHeap.size() < k) {
                    minHeap.offer(value);
                    currentSum += value;
                } else if (!minHeap.isEmpty() && value > minHeap.peek()) {
                    currentSum -= minHeap.poll();
                    minHeap.offer(value);
                    currentSum += value;
                }
            }
            i = j;
        }

        return answer;
    }
}
