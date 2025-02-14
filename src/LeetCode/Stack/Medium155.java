package LeetCode.Stack;

import java.util.ArrayList;
import java.util.List;

public class Medium155 {

    // 155. Min Stack
    private int size = -1;
    private List<Integer> list = new ArrayList<>();
    private List<Integer> minValList = new ArrayList<>();

    public void push(int val) {
        if (minValList.isEmpty() || minValList.get(size) > val)
            minValList.add(val);
        else minValList.add(minValList.get(size));
        list.add(val);
        size++;
    }

    public void pop() {
        list.remove(size);
        minValList.remove(size);
        size--;
    }

    public int top() {
        return list.get(size);
    }

    public int getMin() {
        return minValList.get(size);
    }

}
