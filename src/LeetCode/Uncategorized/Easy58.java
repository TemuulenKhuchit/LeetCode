package LeetCode.Uncategorized;

import java.util.Arrays;
import java.util.List;

public class Easy58 {

    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("Hello World"));
        System.out.println(lengthOfLastWord("   fly me   to   the moon  "));
    }

    // Easy 58. Length of Last Word
    public static int lengthOfLastWord(String s) {
        List<String> words = Arrays.asList(s.split(" "));
        return words.get(words.size() - 1).length();
    }
}
