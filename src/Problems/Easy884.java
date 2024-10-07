package Problems;

import java.util.*;

public class Easy884 {
    public String[] uncommonFromSentences(String s1, String s2) {
        String s = s1 + " " + s2;
        String[] sentence = s.split(" ");
        List<String> result = new ArrayList<>();

        Map<String, Integer> data = new HashMap<>();
        for (String text : sentence) {
            data.put(text, data.getOrDefault(text, 0) + 1);
        }

        data.forEach((key, value) -> {
            if (value == 1)
                result.add(key);
        });

        return result.toArray(new String[0]);
    }

    public static void main(String[] args) {
        var prob = new Easy884();
        String s1 = "this apple is sweet";
        String s2 = "this apple is sour";
        System.out.println(Arrays.toString(prob.uncommonFromSentences(s1, s2)));
    }
}
