package LeetCode.Heap_PriorityQueue;

import java.util.PriorityQueue;
import java.util.Queue;

public class Easy703 {

    // Easy 703. Kth Largest Element in a Stream
    private Queue<Integer> minHeap = new PriorityQueue<>();
    private int k;

    public Easy703(int k, int[] nums) {
        this.k = k;
        for (int num : nums)
            add(num);
    }

    public int add(int val) {
        if (minHeap.size() < k || val > minHeap.peek()) {
            minHeap.add(val);
            if (minHeap.size() > k)
                minHeap.remove();
        }
        return minHeap.peek();
    }
}
