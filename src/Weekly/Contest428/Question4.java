package Weekly.Contest428;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Question4 {

    public static int minOperationsToMakeGood(String s) {
        Map<Character, Integer> freqCnt = new HashMap<>();
        for (char c : s.toCharArray())
            freqCnt.put(c, freqCnt.getOrDefault(c, 0) + 1);

        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        maxHeap.addAll(freqCnt.values());

        int operations = 0;

        // Step 3: Process the heap to make all frequencies unique
        while (maxHeap.size() > 1) {
            int current = maxHeap.poll(); // Get the largest frequency
            if (current == maxHeap.peek()) {
                // If the next largest frequency is the same, we need to reduce the current frequency
                if (current > 1) {
                    maxHeap.add(current - 1); // Reduce the frequency and reinsert into the heap
                }
                operations++; // Increment the operation count
            }
        }

        return operations;
    }

    public static void main(String[] args) {
        // Test cases
        String s1 = "acab";
        System.out.println("Output: " + minOperationsToMakeGood(s1)); // Expected: 1

        String s2 = "wddw";
        System.out.println("Output: " + minOperationsToMakeGood(s2)); // Expected: 0

        String s3 = "aaabc";
        System.out.println("Output: " + minOperationsToMakeGood(s3)); // Expected: 2
    }

}
