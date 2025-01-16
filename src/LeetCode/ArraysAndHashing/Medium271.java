package LeetCode.ArraysAndHashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Medium271 {

    public static void main(String[] args) {
        System.out.println(decode(encode(Arrays.asList("Hello", "World"))));
    }

    // Medium 271. Encode and Decode Strings
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        StringBuilder encodedString = new StringBuilder();
        for (String s : strs) {
            encodedString.append(s);
            encodedString.append("π");
        }
        return encodedString.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        String[] decodedStrings = s.split("π", -1);
        return new ArrayList<>(Arrays.asList(decodedStrings).subList(0, decodedStrings.length - 1));
    }

}
