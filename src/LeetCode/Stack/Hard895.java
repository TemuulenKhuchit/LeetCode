package LeetCode.Stack;

import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

public class Hard895 {

    Map<Integer, Integer> freq;
    Map<Integer, Stack<Integer>> group;
    int maxFreq;

    public Hard895() {
        freq = new HashMap<>();
        group = new HashMap<>();
        maxFreq = 0;
    }

    public void push(int val) {
        int f = freq.getOrDefault(val, 0) + 1;
        freq.put(val, f);
        if (f > maxFreq)
            maxFreq = f;

        group.computeIfAbsent(f, z -> new Stack<>()).push(val);
    }

    public int pop() {
        int x = group.get(maxFreq).pop();
        freq.put(x, freq.get(x) - 1);
        if (group.get(maxFreq).isEmpty())
            maxFreq--;
        return x;
    }

}
