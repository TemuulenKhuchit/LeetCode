package Problems;

import com.sun.jdi.Value;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Medium1405 {

    public static void main(String[] args) {
        Medium1405 prob = new Medium1405();

        prob.longestDiverseString(1, 1, 7);
        prob.longestDiverseString(7, 1, 0);
    }

    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<Pair> pq = new PriorityQueue<>((x, y) -> y.value - x.value);
        if (a > 0)
            pq.add(new Pair('a', a));
        if (b > 0)
            pq.add(new Pair('b', b));
        if (c > 0)
            pq.add(new Pair('c', c));

        StringBuilder result = new StringBuilder();
        while (!pq.isEmpty()) {
            Pair p = pq.poll();
            if (result.length() >= 2
                    && result.charAt(result.length() - 1) == p.key
                    && result.charAt(result.length() - 2) == p.key) {
                if (pq.isEmpty()) break;
                Pair temp = pq.poll();
                result.append(temp.key);
                if (temp.value - 1 > 0) {
                    pq.add(new Pair(temp.key, temp.value - 1));
                }
            } else {
                p.value--;
                result.append(p.key);
            }

            if (p.value > 0) {
                pq.add(new Pair(p.key, p.value));
            }
        }

        System.out.println(result);
        return result.toString();
    }

    public class Pair {

        Character key;
        Integer value;

        Pair(Character key, Integer value) {
            this.key = key;
            this.value = value;
        }
    }

}
