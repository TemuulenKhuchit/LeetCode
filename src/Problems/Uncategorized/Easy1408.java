package Problems.Uncategorized;

import java.util.ArrayList;
import java.util.List;

public class Easy1408 {

    public static void main(String[] args) {
        System.out.println(stringMatching(new String[]{"mass", "as", "hero", "superhero"}));
    }

    // Easy 1408. String Matching in an Array
    public static List<String> stringMatching(String[] words) {
        List<String> result = new ArrayList<>();
        for (String s : words)
            for (String word : words)
                if (s.contains(word) && !s.equals(word) && !result.contains(word))
                    result.add(word);
        return result;
    }

}
