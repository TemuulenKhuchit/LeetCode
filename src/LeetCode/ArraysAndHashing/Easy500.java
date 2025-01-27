package LeetCode.ArraysAndHashing;

import java.util.*;

public class Easy500 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(findWords(new String[]{"Hello", "Alaska", "Dad", "Peace"})));
    }

    public static String[] findWords(String[] words) {
        String row1 = "qwertyuiop";
        String row2 = "asdfghjkl";
        String row3 = "zxcvbnm";
        Map<Character, Integer> map = new HashMap<>();
        for (char letter : row1.toCharArray())
            map.put(letter, 1);
        for (char letter : row2.toCharArray())
            map.put(letter, 2);
        for (char letter : row3.toCharArray())
            map.put(letter, 3);
        List<String> result = new ArrayList<>();
        for (String word : words) {
            String lowerWord = word.toLowerCase();
            char[] letters = lowerWord.toCharArray();
            int firstLetter = map.get(letters[0]);
            boolean isNotValid = false;
            for (char letter : letters)
                if (map.get(letter) != firstLetter) {
                    isNotValid = true;
                    break;
                }
            if (!isNotValid)
                result.add(word);
        }
        return result.toArray(new String[0]);
    }

}
